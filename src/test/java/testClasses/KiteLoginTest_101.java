package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import configurations.PathConfigure;
import pomClasses.KiteLogin1_POM;

public class KiteLoginTest_101 {
		WebDriver driver;
		KiteLogin1_POM page1 ;
		BaseClass base;
		
		@BeforeClass
		public void launchBrowser() throws IOException {
	    base = new BaseClass();
	    page1  = new KiteLogin1_POM(driver);
		driver = base.driverInit();
		}
		
		@BeforeMethod
		public void enterUrl() {
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		}
		
		@Test
		public void TC()  {
			
			page1.clickOnLoginBtn();
		
		Assert.assertEquals(page1.getErrorMsg1(),"User ID should be minimum 6 characters.");
		
		Assert.assertEquals(page1.getErrorMsg2(),"Password should be minimum 6 characters.");
		
		}
		
		@AfterMethod
		public void logout() {
			driver.navigate().refresh();
			
		}
		
		@AfterClass
		public void closeBrowser() {
			driver.close();
		}

}
