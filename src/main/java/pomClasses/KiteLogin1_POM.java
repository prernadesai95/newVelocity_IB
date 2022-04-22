package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin1_POM {
	
		//declaration
	@FindBy(xpath="//button[@type='submit']")private WebElement loginbtn;
	@FindBy(xpath="(//span[@class='su-message'])[1]")private WebElement errorMsg1;	
	@FindBy(xpath="(//span[@class='su-message'])[2]")private WebElement errorMsg2;


		//initialization
		public KiteLogin1_POM (WebDriver ddd) {PageFactory.initElements(ddd, this);}
		
		//usage
		public void clickOnLoginBtn() {
			loginbtn.click();
		}
		
		public String getErrorMsg1() {
			String msg1 = errorMsg1.getText();
			return msg1;
		}
		
		public String getErrorMsg2() {
			String msg2 = errorMsg2.getText();
			return msg2;
		}

}
