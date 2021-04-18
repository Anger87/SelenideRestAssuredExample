package tests.api.requestActions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import tests.api.requestActions.responseClasses.Location;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReguestAction {
	private RequestSpecification requestSpecification;
	
	public ReguestAction(String URL) {
		this.requestSpecification = new RequestSpecBuilder()
				.setBaseUri(URL)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
	}
	
	public String locationSearchByName(String name) {
		return given(requestSpecification)
				.pathParam("name", name)
				.get("/api/location/search/?query={name}")
				.then()
				.log().all()
				.extract().body()
				.jsonPath().getString("");
	}
	
	public List<Location> locationSearchByLatlong(String latlong) {
		return given(requestSpecification)
				.pathParam("latlong", latlong)
				.get("/api/location/search/?lattlong={latlong}")
				.then()
				.log().all()
				.extract().body()
				.jsonPath().getList("", Location.class);
	}
	
	public String locationSearchByWoeid(String woeid) {
		return given(requestSpecification)
				.pathParam("woeid", woeid)
				.get("/api/location/{woeid}/")
				.then()
				.log().all()
				.extract().body()
				.jsonPath().getString("");
	}
}
