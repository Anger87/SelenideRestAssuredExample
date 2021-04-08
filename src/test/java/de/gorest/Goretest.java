package de.gorest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.requestActions.ReguestAction;
import tests.responseClasses.User;
import tests.utils.HelpMethods;

import java.util.List;

public class Goretest extends BaseTest{
	ReguestAction reguestAction;
	
	@BeforeClass
	public void beforeClass() {
		reguestAction = new ReguestAction(BaseTest.requestSpecification);
		
	}
	
	@Test
	public void testUserList(){
		List<User> userList= reguestAction.getUserList();
		Assert.assertFalse(userList.isEmpty(),"User list is empty");
	}
	
	@Test
	public void testCreateUser(){
		User userBody = new User()
				.name("TestName")
				.email(HelpMethods.generateRandomString("test","email")+"@test")
				.gender("Male")
				.status("Active");
		User user=reguestAction.createUser(HelpMethods.ConvertJavaObjectToJsonString(userBody));
		Assert.assertTrue(user.created_at.length()>0, "User not created");
		
		
	}
	
}
