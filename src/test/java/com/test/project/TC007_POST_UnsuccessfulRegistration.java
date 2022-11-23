package com.test.project;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_POST_UnsuccessfulRegistration {

    @Test
    public void unsuccesfullRegistration(){

        //base URI
        RestAssured.baseURI="https://reqres.in";

        //Request object
        RequestSpecification httprequest=RestAssured.given();

        //Request creating new user sending along with post request
        JSONObject requestParam=new JSONObject();

        requestParam.put("email","Nikola");

        //Response object
        Response response= httprequest.request(Method.POST,"/api/register"); //uz Post request uvek idu params

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode,415);

    }
}
