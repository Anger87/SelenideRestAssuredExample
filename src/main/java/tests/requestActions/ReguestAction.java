package tests.requestActions;

import io.restassured.specification.RequestSpecification;
import tests.responseClasses.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReguestAction {
	private RequestSpecification requestSpecification;
	
	public ReguestAction(RequestSpecification requestSpecification) {
		this.requestSpecification = requestSpecification;
	}
	
	public List<User> getUserList() {
		return given(requestSpecification)
				.get("/public-api/users")
				.then()
				.log().all()
				.extract().body()
				.jsonPath().getList("data", User.class);
	}
	
	public User createUser(String testUser) {
		return given(requestSpecification)
				.body(testUser)
				.post("/public-api/users")
				.then()
				.log().all()
				.extract().body()
				.jsonPath().getObject("data", User.class);
	}
	
	
}
