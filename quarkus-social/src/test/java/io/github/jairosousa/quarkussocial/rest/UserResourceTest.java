package io.github.jairosousa.quarkussocial.rest;

import io.github.jairosousa.quarkussocial.rest.dto.CreateUserRequest;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Autor Jairo Nascimento
 * @Created 18/11/2021 - 15:43
 */
@QuarkusTest
class UserResourceTest {

    @Test
    @DisplayName("should create an user successfully")
    public void createUserTest() {
        var user = new CreateUserRequest();
        user.setAge(30);
        user.setName("Fulano");

        var response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .then()
                .extract().response();

        assertEquals(201, response.statusCode());
        assertNotNull(response.jsonPath().getString("id"));
    }

}