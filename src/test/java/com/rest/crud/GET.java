package com.rest.crud;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GET {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification req = RestAssured.given();
		req.queryParam("page", "2");
		Response res = req.when().get().then().log().all().extract().response();
		System.out.println("--------------Body of the response is-----------------\n " + res.body().asPrettyString());
	}

}
