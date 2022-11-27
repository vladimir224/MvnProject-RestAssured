package com.test.project.refactor;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//Refactor of TC003_GET_Request
public class TC003_SingleUserTests {
    private RequestSpecification httpRequest;

    @BeforeClass
    public void init() {
        //base URI
        RestAssured.baseURI = "https://reqres.in";

        //Request object
        httpRequest = RestAssured.given();
    }

    @Test
    public void getSingleUser() {
        //Execute request
        Response response = httpRequest.request(Method.GET, "/api/users/3");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code doesn't match");
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8", "Content-Type response header doesn't match");

        JsonPath responseJson = response.jsonPath();
        Assert.assertNotNull(responseJson.get("data"), "data object is null");
        Assert.assertNotNull(responseJson.get("support"), "support object is null");
    }

    @Test
    @Ignore
    public void createUser() {

    }

    @Test
    @Ignore
    public void userShouldNotBeCreatedWithInvalidPayload() {

    }
}
