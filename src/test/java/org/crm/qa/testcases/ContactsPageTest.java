package org.crm.qa.testcases;

import org.crm.qa.base.TestBase;
import org.crm.qa.pages.ContactsPage;
import org.crm.qa.pages.LoginPage;
import org.crm.qa.pages.MainPage;
import org.crm.qa.utils.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
	MainPage mainPage;
	ContactsPage contactsPage;
	LoginPage loginPage;
	TestUtil testUtil;
	String sheetName ="Contacts";
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
	testUtil=new TestUtil();
		loginPage=new LoginPage();
	mainPage=loginPage.loginOperation(prop.getProperty("username"), prop.getProperty("password"));
	contactsPage=mainPage.clickContactsLink();
	}
	
	//@Test(priority=2, enabled=false)
	
	//public void verifyContactsTest() {
		//Assert.assertTrue(contactsPage.verifyContacts());
	//}
	
	//@Test(priority=2, enabled=false)
	//public void clickOnSureshCheckboxTest()  {
		
		
		//contactsPage.clickOnSureshCheckbox("suresh sudh"); 
		//contactsPage.clickOnSureshCheckbox("parimala suman");
	//} 
	
	
	@DataProvider
	
	public Object[][] getCRMTestData() {
	Object data[][] =TestUtil.getTestData(sheetName);
	return data;
	}
	
@Test(dataProvider="getCRMTestData")
public void createNewContactTest(String FirstName, String LastName) {
contactsPage.createNewContact(FirstName, LastName);	
}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
