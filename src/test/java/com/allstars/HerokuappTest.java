package com.allstars;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.ui.pageobjects.CheckboxPage;
import tests.ui.pageobjects.StartPage;
import tests.ui.pageobjects.iFramePage;

import static com.codeborne.selenide.Configuration.baseUrl;

public class HerokuappTest extends BaseTest {
	
	@BeforeMethod
	public void openPage() {
		logger.info("opening page " + URLHerokuapp);
		Selenide.open(baseUrl);
		startPage = new StartPage();
	}
	
	@Test
	public void checkboxTest() {
		CheckboxPage checkboxPage = startPage.openCheckBoxPage();
		checkboxPage.clickCheckbox1()
				.clickCheckbox2();
		Assert.assertTrue(checkboxPage.isCheckedChBox1(), "ChBox1 is not checked");
		Assert.assertFalse(checkboxPage.isCheckedChBox2(), "ChBox2 is checked");
	}
	
	@Test
	public void checkiFrameTest() {
		String name = "Kostiantyn";
		iFramePage iframePage = startPage.openIFramePage();
		iframePage.setTextInput(name);
		Assert.assertEquals(iframePage.getTextFromInput(),name,"input doest contains name");
	}
}
