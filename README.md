# RestAssured

**JsonPath** => JsonPath dependency is used to parse the json values. Query language that helps you to parsing the Json data which can be used for validation or assertion in a test.

eg. -> public void test_get2(){
  String url ="";
  Response res = Restassured.given().get(url).andReturn();
  res.getBody().prettyString();
  asserTrue(response.getStatus == 200)
  Jsonpath js = new Jsonpath(res.toString);
  String result = js.get("result");
  Sysout(result);
}


**Hamcrest Library**
Hamcrest is a framework that comes with the library of useful matchers for writing match rules using matcher objects. Matcher are mostly used for:
Writing Test Assertion, Filtering, Data Validation
