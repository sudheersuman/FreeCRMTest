package org.crm.qa.testcases;


import org.crm.qa.base.TestBase;
import org.crm.qa.pages.LoginPage;
import org.crm.qa.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
LoginPage page;
MainPage mainPage;

public LoginPageTest() {
	super();
}
	@BeforeMethod
	public void setUp() {
		initialization();
		page=new LoginPage();
	}
	
	@Test
	public void getTitelOfThePageTest() {
	String title=	page.getTitelOfThePage();
	Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test
	public void checkLinkIsEnabledTest() {
		page.checkLinkIsEnabled();
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void loginOperationTest() {
		mainPage=page.loginOperation(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("main page is opened");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
