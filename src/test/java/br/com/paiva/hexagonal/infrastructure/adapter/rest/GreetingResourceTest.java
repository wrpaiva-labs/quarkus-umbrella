package br.com.paiva.hexagonal.infrastructure.adapter.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/greetings")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }
}