package RestAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_User {
  @Test
  public void getUser() {
	  RestAssured.baseURI="https://api.restful-api.dev";
	  RestAssured.given().when().get("/objects").then().statusCode(200).log().all();
  }
}
