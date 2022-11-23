package com.test.project;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_GET_ValidationJSONResponse {
    @Test
    public void getUserSingle() {

        //base URI
        RestAssured.baseURI = "https://reqres.in";

        //Request object
        RequestSpecification httprequest = RestAssured.given();

        //Response object
        Response response = httprequest.request(Method.GET, "/api/users/2");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        Assert.assertEquals(responseBody.contains("Janet"),true);
    }
}
