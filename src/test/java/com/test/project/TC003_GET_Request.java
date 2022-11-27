package com.test.project;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GET_Request {

    @Test
    public void getUserSingle(){

        //base URI
        RestAssured.baseURI="https://reqres.in";

        //Request object
        RequestSpecification httprequest=RestAssured.given();

        //Response object
        Response response=httprequest.request(Method.GET,"/api/users/3");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        //System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode,200);

        //validation header
        String contentType=response.header("Content-Type");
        //System.out.println("Content Type is: "+contentType);
        Assert.assertEquals(contentType,"application/json; charset=utf-8");

        String server=response.header("Server");
        //System.out.println("Server is: "+server);
        Assert.assertEquals(server,"cloudflare");

        String contentEncoding=response.header("Content-Encoding");
        //System.out.println("Content-Encoding is : "+contentEncoding);
        Assert.assertEquals(contentEncoding,"br");
    }
}
