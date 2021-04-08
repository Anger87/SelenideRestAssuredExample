package de.gorest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.requestActions.ReguestAction;
import tests.responseClasses.User;
import tests.utils.HelpMethods;

import java.util.List;

public class Goretest extends BaseTest {
	ReguestAction reguestAction;
	
	@BeforeClass
	public void beforeClass() {
		reguestAction = new ReguestAction(BaseTest.requestSpecification);
		
	}
	
	@Test
	public void testUserList() {
		List<User> userList = reguestAction.getUserList();
		Assert.assertFalse(userList.isEmpty(), "User list is empty");
	}
	
	@Test
	public void testProducts() {
		String products = reguestAction.getProducts();
		Assert.assertFalse(products.isEmpty(), "Products list is empty");
	}
	
	@Test
	public void testCreateUpdateDeleteUser() {
		User userBody = new User()
				.name("TestName")
				.email(HelpMethods.generateRandomString("test", "email") + "@test")
				.gender("Male")
				.status("Active");
		//create user
		User user = reguestAction.createUser(HelpMethods.ConvertJavaObjectToJsonString(userBody));
		Assert.assertTrue(user.created_at.length() > 0, "User not created");
		
		User userBodyUpdated = userBody.name("TestName Updated");
		//update user
		User userBodyUpdatedResponse = reguestAction.updateUser(user.id, HelpMethods.ConvertJavaObjectToJsonString(userBodyUpdated));
		Assert.assertEquals(userBodyUpdated.name, userBodyUpdatedResponse.name, "User name was not updated");
		
		//delete user
		String response =reguestAction.deleteUser(user.id);
		Assert.assertEquals(response, "204"," The request was handled successfully and the response contains no body content");
	}
	
}
