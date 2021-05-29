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


**Specifications**
Specification helps us to make our code achive DRY(Dont Repeat Yourself) approcah
If we are running multiple tests and some parameter of the request and response is same for all the testcases [Like Base URI and URL] then we can use Specification in order to avoid Duplicacy in our code.

There are two types of Specifications 1) RequestSpecification 2) ResponseSpecification
