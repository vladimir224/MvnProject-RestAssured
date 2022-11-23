package com.test.project;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_GET_ExtracValuesOfEachNodeInJSON {

    @Test
    public void getUserSingle() {

        //base URI
        RestAssured.baseURI = "https://reqres.in";

        //Request object
        RequestSpecification httprequest = RestAssured.given();

        //Response object
        Response response = httprequest.request(Method.GET, "/api/users?page=2");

        //print response in console window message
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        //json path
        JsonPath jsonpath=response.jsonPath();
        int page=jsonpath.get("page");
        int perPage=jsonpath.get("per_page");
        int total=jsonpath.get("total");
        int totalPages=jsonpath.get("total_pages");

        Assert.assertEquals(page,2);
        Assert.assertEquals(perPage,6);
        Assert.assertEquals(total,12);
        Assert.assertEquals(totalPages,2);
    }
}
