package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import configurations.AllPath;

public class UtilityNew {
	
	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream(AllPath.ExcelPath);
	
	Sheet s = WorkbookFactory.create(file).getSheet("Sheet1");
	String value = s.getRow(0).getCell(0).getStringCellValue();
	
	return value;
	
	}
	
	public static void captureScreenshot(WebDriver driver, String tcID) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(AllPath.ScreenshotPath+tcID+"_Image.jpg");
		FileHandler.copy(src, dest);
	}
	
	public static String readPropertyFileData(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("C:\\Users\\Prerna\\eclipse-workspace\\Zerodha\\src\\main\\resources\\credentials\\login.properties");
		prop.load(input);
		String value = prop.getProperty(key);
		return value;
	}
}
