package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;// Created a localdriver variable "ldriver" for WebDriver
	
	// Create a parameterised constructor and assign remote Webdriver object"rdriver" to  localdriver object "ldriver"
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this);// Used pagefactory class and initelements method to initialize the driver
				
	}
	
	
	// Use @FindBy to identify all the webElements which we need to interact in the webpage
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement passwd;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement LoginBtn;
	
	@FindBy(linkText="Logout")
	WebElement LogoutBtn;
	
	// Creating action methods 
	
	public void enterEmail(String emailAdd) 
	{
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String Password) 
	{
		passwd.clear();
		passwd.sendKeys(Password);
	}
   public void clickonLogin() 
   {
	
	LoginBtn.click();
}
   public void clickonLogout() 
   {
	
	   LogoutBtn.click();
   }

}

