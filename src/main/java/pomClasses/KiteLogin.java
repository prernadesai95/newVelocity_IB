package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin {
	
	@FindBy(xpath= "//input[@type='text']") private WebElement username;
	@FindBy(xpath= "//input[@type='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement loginbutton;
	@FindBy(xpath="//input[@id='pin']")private WebElement passcode;
	@FindBy(xpath="//span[text()='AL0737']")private WebElement getuserid;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginbutton2; 
	
	public KiteLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String UN) {
		username.sendKeys(UN);
	}
	
	public void enterPassword(String PWD) {
		password.sendKeys(PWD);
	}
	
	public void kiteLoginBtn() {
		loginbutton.click();
	}
	
	public void passCode(String pcode) {
		passcode.sendKeys(pcode);
	}
	
	public void continueBtn()
	{
		loginbutton2.click();
	}	
	public String getUserId() {
		String text = getuserid.getText();
		return text;
	}




}
