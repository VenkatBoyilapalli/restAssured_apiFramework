package stepDefinitions;

import java.io.IOException;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonArray;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredClass {
	
	public static void main(String[] args) throws IOException {
		
		
		RestAssured RestAPI = new RestAssured();
		RestAPI.baseURI = "";
		given().queryParam("Key", "value").header("content-Type","application/JSON")
		.body("").when().post("")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().header(DEFAULT_BODY_ROOT_PATH);
		
		RestAPI.registerParser("text/plain", Parser.TEXT);
		PreemptiveBasicAuthScheme authSchema = new PreemptiveBasicAuthScheme();
		authSchema.setUserName(DEFAULT_BODY_ROOT_PATH);
		String username = "";
		String password = "";
		given().auth().basic(username, password).when().get().then().statusCode(200);
		
		JsonArray jsonArray = new JsonArray();
		jsonArray = given().queryParam("Key", "value").header("content-Type","application/JSON")
		.body("").when().get("").as(JsonArray.class);
		for (int i = 0; i < jsonArray.size(); i++) {
//			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
//			System.out.println(jsonObject.get("first_name").getAsString());

		}
		
	}

}
