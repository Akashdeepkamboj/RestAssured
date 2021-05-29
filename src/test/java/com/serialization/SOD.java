package com.serialization;

import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SOD {

	private static final ObjectMapper Mapper = new ObjectMapper();

	public static void main(String[] args) throws JsonProcessingException {

		SerializationJackson object1 = new SerializationJackson();
		object1.setId(2444445);
		object1.setTitle("Post Request");
		object1.setAuthor("AkashAuthor");

		String url = "http://localhost:3000/posts";

		// converting java object to Json
		String json = Mapper.writeValueAsString(object1);

		Response res = RestAssured.given().contentType(ContentType.JSON).body(json).post(url).then().log().all()
				.extract().response();

		assertEquals(res.getStatusCode(), 201, "Http Message");
		System.out.println(res.getBody().asString());
	}

}
