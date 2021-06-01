package com.rs.library.API;

public class PayloadData {
	
	public static String AddBookData(String isbn ,String aisle) {
		String payload = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"Akashdeep\"\r\n" + 
				"}\r\n" + 
				"";
		return payload;
	}

}
