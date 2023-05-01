package resources;

public enum APIPaths {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String path;
	
	APIPaths(String path){
		this.path=path;
	}
	
	public String getAPIPath() {
		return path;
	}
	

}
