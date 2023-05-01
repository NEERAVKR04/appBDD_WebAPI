package resources;

import java.util.ArrayList;
import java.util.List;

import pojos.AddPlaceAPI;
import pojos.DeletePlace;
import pojos.Location;

public class APIDataBuilder {
	

	public AddPlaceAPI addPlaceDataPayload(String name, String phone_no, String language, String address) {
		 AddPlaceAPI payload = new AddPlaceAPI();
		 Location loc=new Location();
		 loc.setLat(-33.67891);
		 loc.setLng(34.45123);
		 
		 payload.setAccuracy(55);
		 payload.setAddress(address);
		 payload.setLanguage(language);
		 payload.setName(name);
		 payload.setWebsite("https://rahulshettyacademy.com");
		 payload.setPhone_number(phone_no);
		 payload.setLocation(loc);
		 
		 
		 List<String> types=new ArrayList<String>();
		 types.add("Camera");
		 types.add("Raincoat");
		 
		 payload.setTypes(types);
		 
		 return payload;
	}
	
	public DeletePlace deletePlacePayload(String place_id) {
		
		DeletePlace payload=new DeletePlace();
		payload.setPlace_id(place_id);
		
		return payload;
	}

}
