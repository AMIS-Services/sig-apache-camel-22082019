package amis.camel.CamelSwaggerAPI.routes;

import amis.camel.CamelSwaggerAPI.generated.swagger.northbound.model.Pet;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class FindPetsRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        // Handles all other exceptions and returns HTTP status 500 with exception message in the HTTP body
        onException(Exception.class)
                .handled(true)
                .log(LoggingLevel.ERROR, "body: ${body} + headers: ${headers}")
                .choice()
                .when(simple("${headers.CamelHttpResponseCode} == null"))
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("500"))
                .otherwise()
                .setHeader(Exchange.HTTP_RESPONSE_CODE, simple("${headers.CamelHttpResponseCode}"))
                .setBody(simple(""))
                .end();


        from("direct:findPets").routeId("findPets-route")
                .removeHeaders("*")
                .to("mongodb3:mongo?database=pet-store&collection=pets&operation=findAll")
                .choice()
                .when(simple("${headers.CamelMongoDbResultPageSize} != 0"))
                    .unmarshal().json(JsonLibrary.Jackson, Pet.class)
                    .log("findAll result: \nBody: ${body}")
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                // Handles NotFoundException and returns HTTP status 404 with empty body
                .when(simple("${headers.CamelMongoDbResultPageSize} == 0"))
                    .log(LoggingLevel.ERROR, "HTTP response 404 Not Found \nBody: ${body}")
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404))
                    .setBody(simple(""))
                // Handles all other exceptions and returns HTTP status code
                .otherwise()
                    .log(LoggingLevel.ERROR, "ERROR: \nBody: ${body}")
                    .throwException(Exception.class, "Route failed!")
                .end();

    }

}