package tests.ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckboxPage {
	public Logger logger = LogManager.getLogger(CheckboxPage.class);
	
	private final SelenideElement checkbox1 = $(By.xpath("//input[@type='checkbox'][1]"));
	private final SelenideElement checkbox2 = $(By.xpath("//input[@type='checkbox'][2]"));
	
	public CheckboxPage clickCheckbox1() {
		logger.info("Checkbox1 click");
		checkbox1.should(Condition.visible).click();
		return this;
	}
	
	public CheckboxPage clickCheckbox2() {
		logger.info("Checkbox2 click");
		checkbox2.should(Condition.visible).click();
		return this;
	}
	
	private boolean isChecked(SelenideElement element) {
		return element.isSelected();
	}
	
	public Boolean isCheckedChBox1() {
		logger.info("is ChBox1 checked");
		return isChecked(checkbox1);
	}
	
	public Boolean isCheckedChBox2() {
		logger.info("is ChBox2 checked");
		return isChecked(checkbox2);
	}
}
