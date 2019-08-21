package amis.camel.CamelSwaggerAPI.generated.swagger.northbound.api;

import javax.annotation.Generated;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.CollectionFormat;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

/**
 * Generated from Swagger specification by Camel REST DSL generator.
 */
@Generated("org.apache.camel.generator.swagger.PathGenerator")
@Component
public final class SwaggerPetstore extends RouteBuilder {
    /**
     * Defines Apache Camel routes using REST DSL fluent API.
     */
    public void configure() {
        rest("/api")
            .get("/pets")
                .id("findPets")
                .description("Returns all pets from the system that the user has access to")
                .produces("application/json,application/xml,text/xml,text/html")
                .param()
                    .name("tags")
                    .type(RestParamType.query)
                    .dataType("array")
                    .collectionFormat(CollectionFormat.csv)
                    .arrayType("string")
                    .required(false)
                    .description("tags to filter by")
                .endParam()
                .param()
                    .name("limit")
                    .type(RestParamType.query)
                    .dataType("integer")
                    .required(false)
                    .description("maximum number of results to return")
                .endParam()
                .to("direct:findPets")
            .post("/pets")
                .id("addPet")
                .description("Creates a new pet in the store.  Duplicates are allowed")
                .produces("application/json")
                .param()
                    .name("pet")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Pet to add to the store")
                .endParam()
                .to("direct:addPet")
            .get("/pets/{id}")
                .id("findPetById")
                .description("Returns a user based on a single ID, if the user does not have access to the pet")
                .produces("application/json,application/xml,text/xml,text/html")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                    .description("ID of pet to fetch")
                .endParam()
                .to("direct:findPetById")
            .delete("/pets/{id}")
                .id("deletePet")
                .description("deletes a single pet based on the ID supplied")
                .param()
                    .name("id")
                    .type(RestParamType.path)
                    .dataType("integer")
                    .required(true)
                    .description("ID of pet to delete")
                .endParam()
                .to("direct:deletePet");
    }
}
