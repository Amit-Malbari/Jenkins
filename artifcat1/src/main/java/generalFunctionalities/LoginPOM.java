package generalFunctionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPOM {
	
	By username=By.id("Username");
	@FindBy(name="name")
	WebElement user;

	public void setUsername(By username) {
		this.username = username;
		
		
		
	
	}

	
	
	
}
