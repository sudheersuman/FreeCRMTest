package org.crm.qa.testcases;

import org.crm.qa.base.TestBase;
import org.crm.qa.pages.CompaniesPage;
import org.crm.qa.pages.ContactsPage;
import org.crm.qa.pages.LoginPage;
import org.crm.qa.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase {
	
LoginPage page;
MainPage mainPage;
ContactsPage contactsPage;
CompaniesPage companiesPage;
	
	public MainPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		page=new LoginPage();
		
	mainPage=page.loginOperation(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@Test
	public void verifyPageTitleTest() {
		String pagetitle=mainPage.verifyPageTitle();
		
		Assert.assertEquals(pagetitle, "Cogmento CRM", "page title is different ");
	}
	@Test
	public void verifyLogoTest() {
		Assert .assertTrue(mainPage.verifyLogo());
	}
	@Test
	public void clickContactsLinkTest() {
contactsPage=mainPage.clickContactsLink();
System.out.println("contact page is opened");
	}
	@Test
	public void clickCompaniesLinkTest() {
	companiesPage=	mainPage.clickCompaniesLink();
	System.out.println("companies page is opened");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
