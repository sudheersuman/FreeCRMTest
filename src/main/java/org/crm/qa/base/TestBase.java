package org.crm.qa.base; 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.crm.qa.utils.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {
	public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

public	TestBase(){
		 prop=new Properties();
		 try {
			FileInputStream ip=new FileInputStream("C:\\Users\\sudt1216\\sudheerMTabc\\FreeCRMTest\\src\\main\\java\\org\\crm" + "\\qa\\config\\config.properties");
			 prop.load(ip);
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void initialization() {
		
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/sudt1216/sudheerMT/COLTNetcracker/lib/chromedriver.exe");
			 driver = new ChromeDriver(); //launch chrome
		}
			 else if(browser.equals("FF")) {
				 System.setProperty("webdriver.gecko.driver", "C:/Users/sudt1216/sudheerMT/COLTNetcracker/lib/geckodriver.exe");
				 driver = new FirefoxDriver();
				 
				 
			 }
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
			e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all the cookies
		
//		dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://ui.freecrm.com/"); 
		}
	}

