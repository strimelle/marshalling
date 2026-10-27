# Marshalling

Java application that transforms Java objects (POJO) to XML and back using JAXB,
and sends the XML document from a server to a client over the network using `java.net` sockets.

Created as Web Services Assessment Task 1 ("Marshaling and un-marshaling").

## Technologies

- Java 25
- Spring Boot 4.1
- JAXB (`jakarta.xml.bind-api`, `jaxb-runtime`)
- JUnit 5 and Mockito
- Maven

## How it works

1. On startup, `XmlServerRunner` reads `src/main/resources/XML/students.xml`
   (10 students, each with 10 courses) and transforms it to Java objects.
2. `XmlServer` waits for a client on port **8383**.
3. A `POST` request to `/api/client/receive` (port **9000**) starts `XmlClient`.
4. The server transforms the objects to XML, prints it and sends it to the client.
5. The client saves the received document to `received.xml`, validates it against the XSD schema,
   transforms it back to Java objects and prints the students to the console.

## Running the application

Start the application from the project folder:

```
./mvnw spring-boot:run
```

On Windows:

```
mvnw.cmd spring-boot:run
```

Or run `MarshallingApplication` from the IDE.

When the application has started, trigger the client from a second terminal:

```
curl -X POST http://localhost:9000/api/client/receive
```

In Windows PowerShell use `curl.exe` instead of `curl`.

The terminal shows `Received.`, and the application console shows the sent XML document
and the list of received students.

The server handles one client per run. To repeat, restart the application.

## Running the tests

Stop the application first, because the server test uses the same port (8383).

```
./mvnw test
```

On Windows:

```
mvnw.cmd test
```

## Project structure

```
src/main/java/lt/viko/eif/imazolevska/marshalling
├── MarshallingApplication.java   Spring Boot entry point
├── model/                        POJO classes mapped to XML (Students, Student, Course)
├── transform/                    XmlTransformer interface and its JAXB implementation
├── net/                          Socket server and client
└── runner/                       Startup runner and REST controller

src/main/resources/XML
├── students.xml                  XML document with 10 students
├── dtd-schema.dtd                DTD schema
└── xsd-schema.xsd                XSD schema

src/test/java/...                 Unit tests for every class
src/test/resources/xml            Valid and invalid XML files used by the tests
```

## Documentation

Generated JavaDoc is available in the `docs` folder. Open `docs/index.html` in a browser.
