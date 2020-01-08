package org.crm.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sum {
	static WebDriver driver;
	
	@BeforeMethod
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/sudt1216/sudheerMT/COLTNetcracker/lib/chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
	}
@Test
public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}
}
