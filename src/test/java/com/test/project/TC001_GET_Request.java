package com.test.project;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_Request {
    @Test
    public void getUserList(){

        //base URI
        RestAssured.baseURI="https://reqres.in";

        //Request object
        RequestSpecification httprequest=RestAssured.given();

        //Response object
        Response response=httprequest.request(Method.GET,"/api/users?page=2");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode,200);

        //status line validation
        String statusLine=response.statusLine();
        System.out.println("status line is: "+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
