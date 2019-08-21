# Twitter and Websocket Example

### Introduction
The example is demonstrating how to poll a constant feed of twitter searches
and publish results in real time using web socket to a web page.

This example is already configured using a testing purpose twitter account named 'cameltweet'.
And therefore the example is ready to run out of the box.

This account is only for testing purpose, and should not be used in your custom applications.
For that you need to setup and use your own twitter account.

### Run
To run the example simply type

	mvn compile camel:run

Then open a browser to see live twitter updates in the web page

	http://localhost:9090
<http://localhost:9090>

To stop the example hit <kbd>ctrl</kbd>+<kbd>c</kbd>
