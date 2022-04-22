package baseClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configurations.AllPath;

public class BaseClass {
	      
	    public WebDriver driverInit() throws IOException {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prerna\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    	WebDriver driver = new ChromeDriver();
	    	driver.get(UtilityNew.readPropertyFileData("URL"));
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	
	    	return driver;
	    }
	    
	    
}
