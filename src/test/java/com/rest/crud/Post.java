package com.rest.crud;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

public class Post {


	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification req = RestAssured.given();
		String requestBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}";
		Response res = req.header("Content-type", "application/json").when().post("/api/users").then().extract()
				.response();

		Headers header = res.getHeaders();
		System.out.println("===============Header resived from the response is===================");
		for (Header h : header) {
			System.out.println("|" + h.getName() + "|" + h.getValue());
		}
		System.out
				.println("============\n Response body of the request is " + res.getBody().asString());

		System.out.println("============\nStatus of the request is " + res.getStatusCode());

	}

}
