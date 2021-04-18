package tests.ui.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class iFramePage {
	public Logger logger = LogManager.getLogger(CheckboxPage.class);
	
	private SelenideElement inputField = $x("//body");
	
	public iFramePage setTextInput(String text) {
		logger.info("swith to iFrame");
		switchTo().frame($x("//iframe[@id='mce_0_ifr']"));
		$x("//body").click();
		inputField.clear();
		logger.info("setting the text " + text);
		inputField.setValue(text);
		return this;
	}
	
	public String getTextFromInput() {
		logger.info("getting the text ");
		return inputField.getText();
	}
	
	
}
