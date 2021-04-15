package de.allstars;

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
	
	public static String URLMetaweather;
	public static String authCode;
	
	public static Logger logger = Logger.getLogger(BaseTest.class);
	
	@BeforeTest
	public void setup() {
		
		BasicConfigurator.configure();
		Properties property = new ReadProperties().initProperty();
		URLMetaweather = ReadProperties.getPropValue(property, "URLMetaweather");
	}
	
	
	@AfterTest
	public void tearDown() {
	
	}
	
	@BeforeMethod
	public void beforeMethod(Method testMethod, ITestContext testContext) {
		String className = testMethod.getDeclaringClass().getSimpleName();
		String methodName = testMethod.getName();
		String testName = testContext.getName();
		logger.info("\n\n:::\nStarting test: " + testName + "." + className + "." + methodName);
	}
	
	
}
