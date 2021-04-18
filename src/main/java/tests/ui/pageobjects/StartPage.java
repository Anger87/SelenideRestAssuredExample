package tests.ui.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
	public Logger logger = LogManager.getLogger(StartPage.class);
	private SelenideElement checkBoxes = $(byText("Checkboxes"));
	
	public CheckboxPage openCheckBoxPage() {
		logger.info("open CheckBoxPage");
		checkBoxes.click();
		return new CheckboxPage();
	}
	
	public iFramePage openIFramePage() {
		logger.info("open IFramePage");
		$(byText("Frames")).click();
		$(byText("iFrame")).click();
		return new iFramePage();
	}
}
