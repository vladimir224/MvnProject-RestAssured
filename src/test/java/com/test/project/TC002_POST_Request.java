package com.test.project;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_Request {

    @Test
    public void createNewUser(){

        //base URI
        RestAssured.baseURI="https://reqres.in";

        //Request object
        RequestSpecification httprequest=RestAssured.given();

        //Request creating new user sending along with post request
        JSONObject requestParam=new JSONObject();

        requestParam.put("name","Nikola");
        requestParam.put("job","QA engineer");

        httprequest.header("Content-Type","application/json");
        httprequest.body(requestParam.toJSONString());


        //Response object
        Response response= httprequest.request(Method.POST,"/api/users"); //uz Post request uvek idu params

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode,201);

        String createdUser=response.jsonPath().get("Nikola");
    }
}
