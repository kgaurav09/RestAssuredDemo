package files;

import io.restassured.path.json.JsonPath;

public class ReuseableMethod {
	
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1= new JsonPath(response);
		 return js1;
	}

}
