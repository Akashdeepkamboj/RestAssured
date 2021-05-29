package com.serialization;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import groovyjarjarasm.asm.TypeReference;
import io.restassured.RestAssured;

public class Deserialization {

	private static final ObjectMapper Mapper = new ObjectMapper();
	public static void main(String[] args) {

		String url = "http://localhost:3000/posts/24";
		SerializationJackson object =  RestAssured.given().get(url).as(SerializationJackson.class);
		
		System.out.println("Post profile details are "+ object.toString());
		String url2 = "http://localhost:3000/posts";

//		Type type = new TypeReference <List<SerializationJackson>>() {}.getType();
//		List<SerializationJackson> blogpost = RestAssured.get(url2).as(type);
//		

	}

}
