Feature: Validating Place API's
  
  @addPlace
  Scenario Outline: Verify if place is being successfully added using AddPlace API
  
    Given Add place payload with "<name>" "<language>" "<address>"
    When User calls "addPlaceAPI" with "post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_id created maps to "<name>" using "getPlaceAPI"
    And enter user credentials
    |test@123|admin|
  
  Examples:
  	| name 		| language 	| address				|
  	| AAhouse	| English	| World cross center	|
  	#| BBhouse	| Spanish	| Sea cross center		|

  @deletePlace
  Scenario: Verify if delete place functionality is working

    Given DeletePlace Payload
    When User calls "deletePlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"

  
    
