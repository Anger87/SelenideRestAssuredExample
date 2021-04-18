package com.allstars;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.api.requestActions.ReguestAction;
import tests.api.requestActions.responseClasses.Location;

import java.util.List;

public class MetaWeatherTest extends BaseTest {
	ReguestAction reguestAction;
	
	@BeforeClass
	public void beforeClass() {
		reguestAction = new ReguestAction(BaseTest.URLMetaweather);
	}
	
	@Test
	public void testSearchByName() {
		String location = reguestAction.locationSearchByName("london");
		Assert.assertTrue(location.contains("London") , "testSearchByName location is not London");
	}
	
	@Test
	public void testSearchByLatlong() {
		List<Location> locationList = reguestAction.locationSearchByLatlong("36.96,-122.02");
		Assert.assertEquals(locationList.get(0).title,"Santa Cruz" , "location in list is not Santa Cruz");
	}
	
	@Test
	public void testSearchByWoeid() {
		String location = reguestAction.locationSearchByWoeid("44418");
		Assert.assertTrue(location.contains("London") , "testSearchByWoeid location is not London");
	}
}
