package amis.camel.CamelSwaggerAPI.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AddPetRoute extends RouteBuilder {

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


        from("direct:addPet").routeId("addPet-route")
                .removeHeaders("*")
                .log("addPet request: \nBody: ${body}")
                .to("mongodb3:mongo?database=pet-store&collection=pets&operation=insert")
                .choice()
                .when(simple("${headers.CamelMongoOid} != null"))
                    .log("addPet result: \nBody: ${body}")
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                // Handles all other exceptions and returns HTTP status code
                .otherwise()
                    .log(LoggingLevel.ERROR, "ERROR: \nBody: ${body}")
                    .throwException(Exception.class, "Route failed!")
                .end();
    }
}
