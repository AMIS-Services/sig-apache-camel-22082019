# Camel Spring Boot Twitter and Websocket Example

### Introduction
The example is demonstrating how to poll a constant feed of twitter searches
and publish results in real time using web socket to a web page.

This example is already configured using a testing purpose twitter account named 'cameltweet'.
And therefore the example is ready to run out of the box.

This account is only for testing purpose, and should not be used in your custom applications.
For that you need to setup and use your own twitter account.

#Build

```
$ mvn clean compile
```
new resources are generated in generated.swagger.api and generated.swagger.model packeges

#Run
You can run this example using

```
$ mvn spring-boot:run
```

#View
Then open a browser to see live twitter updates in the web page

	http://localhost:8080
<http://localhost:8080>

To stop the example hit <kbd>ctrl</kbd>+<kbd>c</kbd>




