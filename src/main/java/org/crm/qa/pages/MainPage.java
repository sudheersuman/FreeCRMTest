package org.crm.qa.pages;

import org.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends TestBase {
	
	//Page Factory-OR
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
			
			WebElement Contactbtn;
	@FindBy(xpath="//span[contains(text(),'Companies')]")
	WebElement companiesbtn;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsbtn;
	
	@FindBy(xpath="//div[@class='header item']")
	
	WebElement logoImage;
	
	@FindBy(xpath="//div[contains(text(),'Contacts activity stream')]//preceding-sibling::a[2]")
	WebElement settings;
	
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String  verifyPageTitle() {
	return	driver.getTitle();
	}
	
	public boolean verifyLogo() {
		return(logoImage.isDisplayed());
		
	}
	
	public ContactsPage clickContactsLink() {
		Contactbtn.click();
		
		return new ContactsPage();
	}
	
	public CompaniesPage clickCompaniesLink() {
		companiesbtn.click();
		return new CompaniesPage();
	}

		
		
	}


