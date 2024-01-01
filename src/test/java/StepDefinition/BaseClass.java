package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.*;

import PageObject.Customers;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

// parent class
public class BaseClass {

	// we need to create objects of WebDriver and PageOject class i.e, LoginPage.java
	
		public static WebDriver driver;
		public LoginPage loginpg;// created object variable of Login page
		public Customers customer;// created object variable of Customer page
		public SearchCustomerPage searchcust;// created object variable of SearchCustomerPage
	    public static Logger log; // Created object of Logger class in BaseClass
	    public ReadConfig readconfig; // Create object reference of ReadConfig class
	    //public WebDriverWait mywait;
		//To generate random email id every time we use this method 
		public String generateEmailId() 
		{
			return(RandomStringUtils.randomAlphabetic(5));
			
		}
		
        

}
