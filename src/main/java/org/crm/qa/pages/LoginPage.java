package org.crm.qa.pages;

import org.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	//Factory-Repository---OR
	
	@FindBy(name="email")
	WebElement Name;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//div[contains(@class,'ui fluid large blue submit button')]")
	WebElement signbtn;
	
	@FindBy(linkText="Classic CRM")
	
	WebElement classicCRM;
	
	public   LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitelOfThePage() {
		 return driver.getTitle();
	}
	public Boolean checkLinkIsEnabled() {
		return classicCRM.isEnabled();
	
	}
	public MainPage loginOperation(String un, String pass) {
		Name.sendKeys(un);
		Password.sendKeys(pass);
		signbtn.click();
		return new MainPage();
	}
}