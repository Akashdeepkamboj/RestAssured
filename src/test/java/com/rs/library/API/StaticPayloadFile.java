package com.rs.library.API;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticPayloadFile {

	// Content of the file to String
	// TO do this follow below steps
	// Convert the content of the file to the Byte
	// Byte to String

	public static void main(String[] args) throws IOException {

		String currentDir = System.getProperty("user.dir");
		byte[] jsonByte = Files.readAllBytes(Paths.get(
				"C:\\Users\\len\\Desktop\\RestAssuredGit\\RestGit\\RestAssured\\src\\test\\java\\com\\rs\\library\\API\\payload.json"));

		RestAssured.baseURI = "http://216.10.245.166";

		String Response = given().header("Content-Type", "application/json").body(new String(jsonByte)).when()
				.post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath jsObje = new JsonPath(Response);
		String id = jsObje.getString("ID");
		System.out.println(id);
		System.out.println("Executed");

	}

}
