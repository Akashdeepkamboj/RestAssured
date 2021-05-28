package com.rest.crud;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Demo1 {

	@BeforeSuite
	public void setUp() {
		System.out.println("Setup");
	}

	@Test
	public void get_req() {
		RestAssured.baseURI = "http://localhost:3000/";
		given().log().all().when().get("/profile").then().log().all().assertThat().statusCode(200).body("name", equalTo("typicode"));
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("TearDown");
	}

}
