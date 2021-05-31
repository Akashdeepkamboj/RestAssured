package com.rs.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class AddPlace {
//	static String place_id ;

	public static void main(String[] args) {

//given: - all input details
		// when- Submit the API
		// then- Validate the response
		
		//Post Method
		String bodyPayloadData = "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n" + "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"Bhukari-Kharwan\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().queryParam("key", "qaclick123").body(bodyPayloadData).when()
				.post("/maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope",equalTo("APP"))
				.header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response()
				.asString();
		
		System.out.println("Result of the response body is "+res);
		
		
		//PUT Mehtod
		
		//Json Path class helps in extracting and parsing the json values 
		JsonPath js = new JsonPath(res);
		String place_id = js.getString("place_id");
		System.out.println("place id is"+place_id);
		
		String putResponse = given().log().all().queryParam("key", "qaclick123").headers("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+place_id+"\",\r\n" + 
				"\"address\":\"Bhukari-Kharwan123\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"")
				.when().put("/maps/api/place/update/json")
				.then().assertThat().statusCode(200).extract().response().asString();
		
//		 Get Method
//		getPlace
		String getPlaceResponse = given().log().all().queryParam("place_id", place_id).queryParam("key", "qaclick123").when().get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200).log().all().extract().response().asString();
		
		JsonPath getjs =  new JsonPath(getPlaceResponse);
		String addressfromGET = getjs.getString("address");
		System.out.println("address after get request is "+addressfromGET );

		assertEquals(addressfromGET,"Bhukari-Kharwan123");
		
		System.out.println("executed the code");
	}

}
