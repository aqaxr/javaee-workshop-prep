package com.dedalus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class AnimalResourceIT  {
    // Execute the same tests but in packaged mode.

    @Test
    void testGetAnimals(){
        given()
                .when().get("/animal")
                .then()
                .statusCode(200)
                .body("$.size()", is(5));
    }

//    @Test
//    void testAnimalAdoption(){
//
//    }
}
