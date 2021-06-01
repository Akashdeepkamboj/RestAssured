package com.rs.library.API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class AddBook {

	
	@Test
	public void addBook() {
		
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String Response = given().header("Content-Type","application/json")
		.body(PayloadData.AddBookData("za","00309032"))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsObje = new JsonPath(Response);
		String id = jsObje.getString("ID");
		System.out.println(id);
		
	}
	
	// Example of the data-provider
	@Test(dataProvider="BookAddition")
	public void addBookwithData(String isbn, String aile) {

		RestAssured.baseURI = "http://216.10.245.166";
		
		String Response = given().header("Content-Type","application/json")
		.body(PayloadData.AddBookData(isbn,aile))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsObje = new JsonPath(Response);
		String id = jsObje.getString("ID");
		System.out.println(id);
	}
	
	@DataProvider(name="BookAddition")
	public Object[][] getData() {
		return new Object[][] {{"zasdhgasdfsdas","02334342343"},{"znfsfsdfdvj","050654648994"}};
	}

}
