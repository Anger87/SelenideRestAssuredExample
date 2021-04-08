package de.gorest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import tests.utils.ReadProperties;

import java.lang.reflect.Method;
import java.util.Properties;

public class BaseTest {
	
	public String URL;
	public String authCode;
	
	public static Logger logger = Logger.getLogger(BaseTest.class);
	public static RequestSpecification requestSpecification;
	
	@BeforeTest
	public void setup() {
		
		BasicConfigurator.configure();
		Properties property = new ReadProperties().initProperty();
		URL = ReadProperties.getPropValue(property, "URL");
		authCode = ReadProperties.getPropValue(property, "Authorization");
		requestSpecification = getRequestSpecification();
	}
	
	
	@AfterTest
	public void tearDown() {
	
	}
	
	public RequestSpecification getRequestSpecification() {
		logger.info("GetRequestSpecification");
		return new RequestSpecBuilder()
				.setBaseUri(URL)
				.addHeader("Authorization", authCode)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method testMethod, ITestContext testContext) {
		String className = testMethod.getDeclaringClass().getSimpleName();
		String methodName = testMethod.getName();
		String testName = testContext.getName();
		logger.info("\n\n:::\nStarting test: " + testName + "." + className + "." + methodName);
	}
	
	
}
