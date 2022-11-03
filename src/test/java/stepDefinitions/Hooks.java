package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@deletePlace")
    public void beforeScenario() throws IOException {
    	//write a code that will give place id
    	//execute this code only when place id is null

        placeValidation_StepDef reUseDef = new placeValidation_StepDef();
        if(placeValidation_StepDef.place_id==null)
        {

	        reUseDef.add_place_payload_with("Venkat","French", "India");
	        reUseDef.user_calls_with_http_request("addPlaceAPI","POST");
	        reUseDef.verify_place_id_created_maps_to_using("Venkat","getPlaceAPI");
	        
        }
    }

}
