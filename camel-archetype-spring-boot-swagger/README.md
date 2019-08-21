# maven archetype camel-swagger-rest-dsl-generator

This archetype is a very simple artifact, that contains the project prototype we wish to create in case of developing microservices at LG.
An archetype is made up of:

an archetype descriptor (archetype.xml in directory: src/main/resources/META-INF/maven/). It lists all the files that will be contained in the archetype and categorizes them so they can be processed correctly by the archetype generation mechanism.
the prototype files that are copied by the archetype plugin (directory: src/main/resources/archetype-resources/)
the prototype pom (pom.xml in: src/main/resources/archetype-resources)
a pom for the archetype (pom.xml in the archetype's root directory).

```
archetype
|-- pom.xml
`-- src
    `-- main
        |-- resources
        |   `-- archetype-resources
        |       |-- pom.xml
        |       |-- README.md
        |       |-- maven-settings.xml
        |       |-- Jenkinsfile
        |       |-- .gitignore
        |       `-- src
        |           |-- main
        |           |   `-- java
        |           |       `-- App.java
        |           |
        |           |-- resources
        |           |   |-- static
        |           |   |   |-- docs
        |           |   |   |   |-- favicon-16x16.png
        |           |   |   |   |-- favicon-32x32.png
        |           |   |   |   |-- index.html
        |           |   |   |   |-- oauth2-redirect.html
        |           |   |   |   |-- swagger-ui.css
        |           |   |   |   |-- swagger-ui.css.map
        |           |   |   |   |-- swagger-ui.js
        |           |   |   |   |-- swagger-ui.js.map
        |           |   |   |   |-- swagger-ui-bundle.js
        |           |   |   |   |-- swagger-ui-bundle.js.map
        |           |   |   |   |-- swagger-ui-standalone-present.js
        |           |   |   |   `-- swagger-ui-standalone-present.js.map
        |           |   |   |
        |           |   |   |-- index.html
        |           |   |   |-- northbound-swagger.json
        |           |   |   `-- southbound-swagger.json
        |           |   |   
        |           |   |-- application.yml
        |           |   `-- logback.xml
        |           |
        |           `-- test
        |               `-- java
        |                   `-- AppTest.java
        `-- resources-filtered
            `-- META-INF
                `-- maven
                    `--archetype-metadata.xml
```

# Install the archetype and run the archetype plugin
Now you are ready to install the archetype:
```
mvn install
```
Now that you have created an archetype, you can try it on your local system by using the following command. In this command, you need to specify the full information about the archetype you want to use (its groupId, its artifactId, its version) and the information about the new project you want to create (artifactId and groupId). Don't forget to include the version of your archetype (if you don't include the version, you archetype creation may fail with a message that version:RELEASE was not found)

```
mvn archetype:generate                                  \
  -DarchetypeGroupId=nl.msp.archetypes                	 \
  -DarchetypeArtifactId=camel-archetype-spring-boot-swagger          \
  -DarchetypeVersion=1.0.2                				 	 \
  -DgroupId=<my.groupid>                                 \
  -DartifactId=<my-artifactId>
```