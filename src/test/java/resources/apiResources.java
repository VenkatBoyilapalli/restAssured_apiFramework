package resources;
// enum ia a special class in java which has collection of constants or methods
public enum apiResources {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	apiResources(String resource) {

		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
