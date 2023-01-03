import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;

// given-- all input details
// when -- submit the API, resource , http methods
// then -- validate the response\

public class basic1 {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key" , "qaclick123").header("qaclick123","application/json")
		.body(Payload.AddPlace()).when().log().all().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)");
		
		
		
		
		
		

	}

}
