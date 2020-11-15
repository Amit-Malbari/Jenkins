package loginTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	String UserName;
	String Password;
	public LoginTest(String UserName,String Password) {
		this.UserName=UserName;
		this.Password=Password;
		System.out.println("Inside Constructior");
		System.out.println(this.UserName);
		System.out.println(this.Password);

	}
	

	@BeforeClass
	public void webdriverinitialize() 
	{
		System.out.println("Inside BeforeTest 1");
		String chromePath="C:\\Users\\amalbari\\Documents\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		this.driver= new ChromeDriver();
		System.out.println("Inside BeforeTest 2");
	}
	
	@Test(priority=0)
	public void login1() throws InterruptedException 
	{	
		try {
			System.out.println("Inside login test methiod");
			String Welcome=Login.loginmethod(driver,UserName,Password);
			Assert.assertEquals(Welcome, "Welcome To Manager's Page of Guru99 Bank");
			System.out.println("Inside Login Test yeyeyey");
		}
		catch (Exception e) {
			// TODO: handle exception
			Assert.fail("Incorrect Username and Password wirh username as "+this.UserName+" and password as "+this.Password);
		}
		
	}
	
	@Test(dependsOnMethods ={"login1"})
	public void logout() throws InterruptedException 
	{	
		
			System.out.println(UserName +"asfasfksdjhfsdjkfhsdjkfhsdfjk "+ Password);
			System.out.println("logout");
			Login.logout(driver);
	}
	
	@AfterClass
	public void DriverClose() 
	{
		System.out.println("asdasdasdas");
		driver.close();
		System.out.println("asdasdasdas");
	}
	

}
