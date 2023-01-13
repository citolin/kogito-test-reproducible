package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.Matchers.hasKey
import org.junit.jupiter.api.Test

@QuarkusTest
class TestClass {

    @Test
    fun testCodedHelloEndpoint() {
        given()
            .contentType(ContentType.JSON)
            .get("/hello")
            .then()
            .statusCode(200)
    }

    @Test
    fun testKogitoHelloWorldEndpoint() {
        given()
            .contentType(ContentType.JSON)
            .post("/helloWorld")
            .then()
            .statusCode(201)
            .body("$", hasKey("id"))

    }
}