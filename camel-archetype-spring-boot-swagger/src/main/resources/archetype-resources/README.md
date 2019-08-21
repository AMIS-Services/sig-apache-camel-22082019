# ${artifactId} - Spring Boot with generated Camel REST DSL API

The project generates resources based on the swagger.json specification stored in resources/static folder
and new resources are packeged in generated.swagger.api and generated.swagger.model

## How to generate artifacts

Replace the swagger.json file in src/main/resources/static directory with your own OpenAPI specification
and run the Maven compile command to generate Camel REST DSL and data models

```
$ mvn clean compile
```
new resources are generated in generated.swagger.api and generated.swagger.model packeges


## How to run
You can run this example using

```
$ mvn spring-boot:run
```

## Testing the project


To get info about application health

```
curl -XGET -s http://localhost:8080/actuator/health
```

To show a summary of all the routes

```
curl -XGET -s http://localhost:8080/actuator/camelroutes
```

To show detailed information for a specific route

```
curl -XGET -s http://localhost:8080/actuator/camelroutes/{id}/detail
```

To view graphical representation of your API definition

```
curl -XGET -s http://localhost:8080
```

## More information

You can find more information about Apache Camel at the website: http://camel.apache.org/



