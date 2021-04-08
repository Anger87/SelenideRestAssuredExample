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
	
	public String getProducts() {
		return given(requestSpecification)
				.get("/public-api/products")
				.then()
				.log().all()
				.extract().body()
				.jsonPath().getString("data");
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
	
	public User updateUser(String userId, String testUser) {
		return given(requestSpecification)
				.pathParam("userId", userId)
				.body(testUser)
				.patch("/public-api/users/{userId}")
				.then()
				.log().all()
				.extract().body()
				.jsonPath().getObject("data", User.class);
	}
	
	public String deleteUser(String userId) {
		return given(requestSpecification)
				.pathParam("userId", userId)
				.delete("/public-api/users/{userId}")
				.then()
				.log().all()
				.extract().body()
				.jsonPath().getString("code");
	}
	
}
