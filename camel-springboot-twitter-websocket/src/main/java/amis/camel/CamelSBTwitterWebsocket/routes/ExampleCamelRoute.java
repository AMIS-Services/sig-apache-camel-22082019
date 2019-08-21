package amis.camel.CamelSBTwitterWebsocket.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExampleCamelRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        // poll twitter search for new tweets
        fromF("twitter-search://%s?delay=%s", "{{twitter.searchTerm}}", "{{twitter.delay}}")
                .to("log:tweet")
                // and push tweets to all web socket subscribers on camel-tweet
                .to("websocket:camel-tweet?sendToAll=true");

    }

}