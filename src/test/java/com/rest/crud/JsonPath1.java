package com.rest.crud;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPath1 {

	public static void main(String[] args) {

		String url = "http://localhost:3000/posts";
		String res = RestAssured.given().get(url).andReturn().asString();
		
		JsonPath jspath = new JsonPath(res);
		System.out.println(jspath.get("id["+0+"]").toString());
		
	
		

	}

}
