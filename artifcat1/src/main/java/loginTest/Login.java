package loginTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import generalFunctionalities.General_Func;
import generalFunctionalities.LoginPOM;

public class Login {
	public static String loginmethod(WebDriver driver, String UserName, String Password) throws InterruptedException 
	{
		String Welcome;
		try {
			driver.get("http://demo.guru99.com/V4/");
			Thread.sleep(7000);
			General_Func.entertext(driver, "UserID", UserName);
			General_Func.entertext(driver, "Password", Password);
			driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(5000);
			Welcome=driver.findElement(By.tagName("marquee")).getText();
		}
		catch (Exception e) {
			// TODO: handle exception
			Welcome="a";
			driver.switchTo().alert().accept();
		}
		return Welcome;
		
	}
	
	
	public static void logout(WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,7000)");
		 System.out.println("just before");
		 
		 WebDriverWait wait= new WebDriverWait(driver, 10000);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Log out"))));
		driver.findElement(By.linkText("Log out")).click();
		Alert alert= driver.switchTo().alert();
		alert.accept();	
		System.out.println("Pass");
	}

}
