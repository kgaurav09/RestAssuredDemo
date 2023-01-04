import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReuseableMethod;

// given-- all input details
// when -- submit the API, resource , http methods
// then -- validate the response\

public class basic1 {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key" , "qaclick123").header("qaclick123","application/json")
		.body(Payload.AddPlace()).when().log().all().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();	
		
		System.out.println(response);
		
		
		JsonPath js= new JsonPath(response);// for parsing json
		
		String placeID=js.get("place_id");
		
		System.out.println(placeID);
		
		
		//update place
		
		String newAddress="70 winter walk,Dallas, USA";
		
		given().log().all().queryParam("key" , "qaclick123").header("qaclick123","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
			
		//to check updated address value (Get place)
		
		String getPlaceResponse=given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeID)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		
		JsonPath js1=ReuseableMethod.rawToJson(getPlaceResponse);
		String actualAddress=js1.getString("address");

		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
	}

}
