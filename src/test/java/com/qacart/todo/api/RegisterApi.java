package com.qacart.todo.api;

import com.qacart.todo.config.EndPoints;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private static List<Cookie> restAssuredCookies;
    private static String accessToken;
    private static String userId;
    private static String firstName;


    public String getToken() {
        return accessToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserId() {
        return userId;
    }

    public List<Cookie> getCookies() {
        return restAssuredCookies;
    }

    public void register() {
        User user = UserUtils.generateRandomUser();
        Response response =
                given()

                        .baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type", "application/json")
                        .body(user)
                        .log().all()
                        .when()
                        .post(EndPoints.API_REGISTER_ENDPOINT)
                        .then()
                        .log().all()
                        .extract().response();
        if (response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with the request");
        }
        //restassured cookies
        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
















