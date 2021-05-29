package com.specification;

import org.apache.http.client.methods.RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationDemo {

	static RequestSpecification getCommonSpec() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://reqres.in/");
		builder.setBasePath("api/users");
		
		RequestSpecification requestSpec = builder.build();
		return requestSpec;
	}
	
	static void test_withoutparam() {
		System.out.println("*******Request without Query Param***************");
		Response res = RestAssured
		.given()
		.spec(getCommonSpec()).when().get().then().log().all().extract().response();
	}
	
	static void test_withparam() {
		System.out.println("*******Request with Query Param***************");
		Response res= RestAssured.given().spec(getCommonSpec())
		.queryParam("page", "2")
		.when()
		.get().then().log().all().extract().response();
		
	}
	
	public static void main(String[] args) {
		test_withoutparam();
		test_withparam();
	}

}
