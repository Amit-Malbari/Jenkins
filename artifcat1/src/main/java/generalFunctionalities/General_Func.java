package generalFunctionalities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General_Func {
	
	public static void entertext(WebDriver driver, String key, String value) throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
   
        //entering first name
//		System.out.println("Hi");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("uid"))));
//        System.out.println("Hey");
		driver.findElement(By.xpath("//td[text()='"+key+"']/following-sibling::td/input")).sendKeys(value);	
		
	}
	
	public String takesScreenshotat(WebDriver driver) {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(file, destFile);
		
		return null;
		
	}
	
	
	
	
	
}