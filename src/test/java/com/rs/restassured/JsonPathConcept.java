package com.rs.restassured;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class JsonPathConcept {

	public static void main(String[] args) {

		String jsonData = "{\r\n" + "\r\n" + "\"dashboard\": {\r\n" + "\r\n" + "\"purchaseAmount\": 910,\r\n"
				+ "\r\n" + "\"website\": \"rahulshettyacademy.com\"\r\n" + "\r\n" + "},\r\n" + "\r\n"
				+ "\"courses\": [\r\n" + "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"Selenium Python\",\r\n" + "\r\n"
				+ "\"price\": 50,\r\n" + "\r\n" + "\"copies\": 6\r\n" + "\r\n" + "},\r\n" + "\r\n" + "{\r\n" + "\r\n"
				+ "\"title\": \"Cypress\",\r\n" + "\r\n" + "\"price\": 40,\r\n" + "\r\n" + "\"copies\": 4\r\n" + "\r\n"
				+ "},\r\n" + "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"RPA\",\r\n" + "\r\n" + "\"price\": 45,\r\n"
				+ "\r\n" + "\"copies\": 10\r\n" + "\r\n" + "}\r\n" + "\r\n" + "]\r\n" + "\r\n" + "}";
		
		
		JsonPath jspath = new JsonPath(jsonData);
		
		//1. Print number of courses returned by API
		int coursesNumber = jspath.getInt("courses.size()");
		System.out.println("Number of courses are "+coursesNumber);
		
		//2. Print Purchase Amount
		int dashboardPurchaseAmount = jspath.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount is "+dashboardPurchaseAmount);
		
		//3. First Course Title
		String firstTitle = jspath.getString("courses[0].title");
		System.out.println("First course title "+firstTitle);
		
		//4. All course title and prices
		for(int i=0 ; i <coursesNumber; i++) {
			System.out.println("Courese title of the "+i+" course is "+ jspath.getString("courses["+i+"].title")+" and price of the course is " +jspath.getString("courses["+i+"].price"));
		}
		
		//5.print number of copies sold by RPA course
		System.out.println("Number of copies sold by RPA course is "+ jspath.getString("courses[2].copies"));
		
		//6.verify sum of all course prices matches with purchase amount
		int coursePriceSum = 0;
		for(int i=0 ; i <coursesNumber; i++) {
			coursePriceSum += (jspath.getInt("courses["+i+"].price") * jspath.getInt("courses["+i+"].copies"));
		}
		System.out.println(coursePriceSum);
		Assert.assertEquals(dashboardPurchaseAmount, coursePriceSum, "Both the Price does not mathces");

	}

}
