package com.specification;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationBuilder {

	public static void main(String[] args) {
	test_with();

	}
	static void test_with() {
		String url = "https://reqres.in/api/users?page=2";
		
		RestAssured.given().when().get(url).then().assertThat().spec(commonSpec());
		
	}
	
	static ResponseSpecification commonSpec() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		ResponseSpecification responseSpec = builder.build();
		return responseSpec;
	}

}
