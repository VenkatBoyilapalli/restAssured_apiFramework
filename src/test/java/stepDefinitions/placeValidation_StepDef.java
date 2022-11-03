package stepDefinitions;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;
//import java.text.SimpleDateFormat;
import java.util.HashMap;

//import org.hamcrest.core.StringContains;
import static org.hamcrest.Matchers.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;
import resources.apiResources;

public class placeValidation_StepDef extends Utils {

	ResponseSpecification responseSpec;
	RequestSpecification res;
	Response response;
	static String place_id;
	TestDataBuild data = new TestDataBuild();

	HashMap<String, Object> map = new HashMap<>();

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name, language, address));

	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions

		// Constructor will be called with value of resource which you pass in Gherkin
		// step
		apiResources resourceApi = apiResources.valueOf(resource); // enum concept
//		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//		System.out.println(resourceApi.getResource());
		if (method.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceApi.getResource());
			
		} else if (method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceApi.getResource());
			
			
//			System.out.println(response);
		}

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response, keyValue), expectedValue);

	}

	@Then("Verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {

		// prepare request spec
		place_id = getJsonPath(response, "place_id");
//		res = given().spec(requestSpecification()).queryParam("place_id", "d1dc7a78000929332ce9e0c841e20381");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualName = getJsonPath(response, "name"); //
		assertEquals(actualName, expectedName);
	}

	@Given("DeletePlace Payload")
	public void deleteplacePayload() throws IOException {
		map.put("place_id", place_id);
//		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
		res = given().spec(requestSpecification()).body(map);

	}
	
	@Then("enter user credentials")
	public void enter_user_credentials(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		System.out.println(dataTable.cell(0, 0));
		
	}
	
}
