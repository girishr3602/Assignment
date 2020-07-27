package com.assignment.qa.apiFramework;

import com.assignment.qa.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;



public class ApiActions extends TestBase {

    public ApiActions(){
        super();
    }

    private final static String appid = "7fe67bf08c80ded756e598d6f8fedaea";

    public static Response post(String getResource){
        Response response =
        given()
                .baseUri("")
                .queryParam("q","")
                .queryParam("appid", appid)
                .log().all()
        .when()
                .get(getResource)
                .andReturn();

        return response;
    }

}
