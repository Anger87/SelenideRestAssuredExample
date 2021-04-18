package com.allstars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import tests.ui.pageobjects.StartPage;
import tests.utils.ReadProperties;

import java.lang.reflect.Method;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.baseUrl;

public class BaseTest {
	
	public static String URLMetaweather;
	public static String URLHerokuapp;
	public Logger logger = LogManager.getLogger(BaseTest.class);
	
	StartPage startPage;
	
	@BeforeTest
	public void setup() {
		Properties property = new ReadProperties().initProperty();
		URLMetaweather = ReadProperties.getPropValue(property, "URLMetaweather");
		baseUrl = ReadProperties.getPropValue(property, "URLHerokuapp");
	}
	
	@BeforeMethod
	public void beforeMethod(Method testMethod, ITestContext testContext) {
		String className = testMethod.getDeclaringClass().getSimpleName();
		String methodName = testMethod.getName();
		String testName = testContext.getName();
		logger.info("\n\n:::\nStarting test: " + testName + "." + className + "." + methodName);
	}
	
	
}
