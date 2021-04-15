package tests.responseClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Location {
	public String woeid;
	public String title;
	public String location_type;
	public String latt_long;
	public String distance;
	
	
	public Location(String woeid, String title, String location_type, String latt_long, String distance) {
		this.woeid = woeid;
		this.title = title;
		this.location_type = location_type;
		this.latt_long = latt_long;
		this.distance = distance;
	}
	
	public Location() {
		super();
	}
	
	
}
