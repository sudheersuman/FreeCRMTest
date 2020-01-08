package org.crm.qa.pages;

import org.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {
	
	//Page Factory==OR
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	
	WebElement contacts;
	
	//@FindBy(xpath="//td[text()='suresh sudh']//preceding-sibling::td//div[@class='ui fitted read-only checkbox']//input[@type='checkbox']")
	
	//WebElement checkbox;
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newbtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContacts() {
		return contacts.isDisplayed();
	}
	
	public void clickOnSureshCheckbox(String name)  {
		
	
	driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td//div")).click();
	}
	public void createNewContact(String firstname ,String lastname) {
		newbtn.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		save.click();
	}
	

}
