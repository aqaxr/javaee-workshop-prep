
package com.dedalus;

import com.dedalus.model.PetHolderEntity;
import com.dedalus.persistence.PetHolderRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class PetHoldersResourceTest {

    @Inject
    PetHolderRepository petHolderRepository;

    @BeforeEach
    @Transactional
    public void setup() {
        int randomID = (int) Math.random() * 1000000;
        PetHolderEntity holder = new PetHolderEntity();
        holder.setName("John Doe " + randomID);
        petHolderRepository.saveNewHolder(holder);
    }

    @Test
    public void testInsertNewHolder() {
        PetHolderEntity holder = new PetHolderEntity();
        holder.setName("Jane Doe");

        given()
                .contentType(ContentType.JSON)
                .body(holder)
                .when()
                .post("/pet-holder")
                .then()
                .statusCode(200)
                .body("name", startsWith("Jane Doe"));
    }

    @Test
    public void testGetAllHolders() {
        given()
                .when()
                .get("/pet-holder")
                .then()
                .statusCode(200);

    }

    @Test
    @Transactional
    public void testAdoptHolder() {
        // Assume there's an animal with ID 1 for adoption
        // Insert the animal entity or mock the adoption service appropriately if needed
        String result = given()
                .when()
                .post("/pet-holder/1/adopt/1")
                .then()
                .statusCode(200)
                .extract().asString();
        assert(result.startsWith("Herzlichen Glückwunsch"));
        // Add more assertions based on the expected result of the adoption
        //assert result.equals("Adoption Successful");
    }
}
