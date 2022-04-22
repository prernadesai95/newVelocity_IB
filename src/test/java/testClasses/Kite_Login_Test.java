package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import baseClasses.UtilityNew;
import pomClasses.KiteLogin;
import pomClasses.KiteZerodha;

public class Kite_Login_Test {

	
	BaseClass base;
	WebDriver driver;
	KiteLogin kite;
	UtilityNew util;
	String tcID;

	@BeforeClass
	public void launchBrowser() throws IOException {
		base = new BaseClass();
		driver = base.driverInit();
		kite = new KiteLogin(driver);
		util = new UtilityNew();
	}

	@BeforeMethod
	public void enterUrl() {
		driver.navigate().refresh();
	}
	
	@Test
	public void logInScenario1_BlankUserBlankPass() throws IOException {
		tcID = "101";
		kite.enterUserName(UtilityNew.readPropertyFileData("UNAME"));
		kite.enterPassword(UtilityNew.readPropertyFileData("PWORD"));
		kite.kiteLoginBtn();
		kite.passCode(UtilityNew.readPropertyFileData("PCODE"));
		kite.continueBtn();
		String UserId = kite.getUserId();
		Assert.assertEquals(UserId, UtilityNew.readPropertyFileData("UNAME"));
		
	}
	
	@AfterMethod
	public void takesScreenshot(ITestResult result) throws IOException {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			util.captureScreenshot(driver,tcID);
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}

	

	
	
	
