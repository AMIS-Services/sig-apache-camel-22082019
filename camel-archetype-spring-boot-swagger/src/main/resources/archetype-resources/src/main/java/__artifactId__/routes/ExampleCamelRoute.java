package ${groupId}.${artifactId}.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ExampleCamelRoute extends RouteBuilder {
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


        from("direct:getRandomJokeUsingGET").routeId("getRandomJokeUsingGETRoute")
                .removeHeaders("*")
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.GET))
                .to("{{endpoints.chucknorris-api}}?bridgeEndpoint=true&throwExceptionOnFailure=false").streamCaching()
                .choice()
                .when(simple("${headers.CamelHttpResponseCode} == 200"))
                // Choose a proper data model to unmarshal the API response
//                .unmarshal().json(JsonLibrary.Jackson, Joke.class)
                .log("https4 result: ${body}")
                .setBody(simple("${body.getValue}"))
                // Handles NotFoundException and returns HTTP status 404 with empty body
                .when(simple("${headers.CamelHttpResponseCode} == 404"))
                .log(LoggingLevel.ERROR, "https4 response 404 Not Found \nBody: ${body}")
                .setBody(simple(""))
                // Handles all other exceptions and returns HTTP status code
                .otherwise()
                .log(LoggingLevel.ERROR, "ERROR: ${body}")
                .throwException(Exception.class, "Route failed!")
                .end();

    }

}