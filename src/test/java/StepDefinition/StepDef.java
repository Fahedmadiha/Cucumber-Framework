package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.Customers;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDef extends BaseClass {
	
	@Before("@Sanity")  // here we used set up hook @Before, this runs before test scenarios , if we specify tag value as an args they will be used with the test scenario which have same tag @Sanity in feature file
	public void setup1() throws IOException {
		//mywait = new WebDriverWait(driver,Duration.ofSeconds(10));		
		readconfig= new ReadConfig();// initialised object of ReadConfig class
		
		//initialize logger
		log=LogManager.getLogger("StepDef");
		
    	System.out.println("setup1 method Executed....");
    	
    	String browser=readconfig.getBrowser(); // calling getBrowser() method of ReadConfig class and that method in turn returns string value that is set in to String Variable "browser"
    	
		// launched browser
      switch(browser.toLowerCase()) 
      {
      case "chrome":
    	  WebDriverManager.chromedriver().setup();
    	  driver= new ChromeDriver();
    	  break;
    	  
      case "firefox":
    	  WebDriverManager.firefoxdriver().setup();
    	  driver= new FirefoxDriver();
    	  break;
    	  
      case "msedge":
    	  WebDriverManager.edgedriver().setup();
    	  driver= new EdgeDriver();
    	  break;
    	  
    	  default:
    		  driver=null;
    		  break;
    	        
      }

      log.fatal("setup1 executed...");
		
	}
	/*@Before("@regression") // here we used set up hook @Before, this runs before test scenarios
	public void setup2() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();// launched browser
	    driver.manage().window().maximize();
    	System.out.println("setup2 method Executed....");

        log.info("setup2 executed...");

	}*/
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    
	    // initialising LoginPage constructor of LoginPage.java class
	    
	    loginpg=new LoginPage(driver); // using loginpg variable initialised LoginPage constructor and passed webdriver object 
	    customer=new Customers(driver); // using customer variable initialised Customers constructor and passed webdriver object 
	    searchcust=new SearchCustomerPage(driver);
	    //driver.manage().window().maximize();
	     // log.info("browser launched.");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	 try {
		driver.get(url);// url is passed here from feature file 
	      
	   log.info("entered url...");
	 }
	 catch(Exception e)
	 {}
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailaddress, String Password)// emailaddress and password are passed here from feature file
	{
	   
		loginpg.enterEmail(emailaddress);// using LoginPage variable loginpg called Action method enterEmail and passed emailadress to the method
	    loginpg.enterPassword(Password);
	    
	      log.info("User enterted email and password");

	}

	@When("Click on Login")
	public void click_on_login() {
	    loginpg.clickonLogin();
	    
	      log.info("user logged in...");

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String ExpTitle) {
	 
		String ActTitle=driver.getTitle();
		if(ActTitle.equals(ExpTitle)) {
		 
			log.warn("page title matched..");
			
			Assert.assertTrue(true);// pass
		}
		else {
			Assert.assertFalse(false);// Fail
		      log.warn("Page Title did not match...");

		}

	}
 
	//////////////////////Add new customer///////////////////////////
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    
		String actTitle=customer.gettitle();
		
		String ExpTitle="Dashboard / nopcommerce administration";
		
		if(actTitle.equals(ExpTitle)) {
			
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
	}

	@When("User clicks on Customers menu")
	public void user_clicks_on_customers_menu() {
	    customer.customermenu();
	}

	@When("Click on customers menu item")
	public void click_on_customers_menu_item() {
	    customer.customerIteam();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
	   customer.AddBtn();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    String actcustpagetitle=customer.gettitle();
	    
	    String expcustpagetitle="Add a new customer / nopCommerce administration";
if(actcustpagetitle.equals(expcustpagetitle)) {
			
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
	    
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	    //customer.emailAdd("test199@gmail.com");
		customer.emailAdd(generateEmailId() + "@gmail.com");// this is called method generateEmailId() method is base base to generate new email id every time
	    customer.PasswordAdd("test1");
	    customer.companyname("F_force");
	    customer.DOB("05/08/1993");
	    customer.firstname("Shaik");
	    customer.lastname("Fahed");
	    customer.gender();
	    //customer.Customerdrpdown("Registered");
	}

	@When("Click on save button")
	public void click_on_save_button() {
	    customer.saveBtn();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedconfirmationmsg) {
	    
		String bodyTag = driver.findElement(By.tagName("Body")).getText();
		
		if(bodyTag.contains(expectedconfirmationmsg))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
			
		}
			
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() 
	{
	    loginpg.clickonLogout();
	    
	    log.info("User logged out.....");

	}

	/*@Then("Close Browser")
	public void close_browser() 
	{
	   driver.close();
	}*/



///////////////Search email////////////////
@When("Enter customer Email")
public void enter_customer_email() {
	searchcust.SearchEmail("jayaprawa289@gmail.com");// here we are passing email address to the SearchEmail method in page object class
    
}

@When("Click on Search button")
public void click_on_search_button() {
   searchcust.Searchbutton();
}

@Then("User should find Email in the Search table")
public void user_should_find_email_in_the_search_table() {
	
		
		String resultmail=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[1]/td[2]")).getText();
		
		if(resultmail.equals("jayaprawa289@gmail.com"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
		}
		
	}
   

   // We will use this @After hook to get screenshot of failed testcases
    //@After // here we used set up hook @After, this runs after test scenarios
 public void teardown(Scenario sc) throws IOException // created object of Scenario class as "sc"
    
    {
    	
        if(sc.isFailed()==true) 
        {
        	// here we use Take Screenshot interface to take screenshot. here driver to TakesScreenshot typecasting should be done
        	String screenshot="C:\\Users\\FAHED\\eclipse-workspace\\CucumberFramework\\Screenshots\\screenshot1.png";
        	TakesScreenshot ts= (TakesScreenshot)driver;
        	
        	//call getScreenshotAs method to create image file
        	File src=ts.getScreenshotAs(OutputType.FILE);
        	
        	// Move image file to new destination
        	File trg=new File(screenshot);
        	try {
        	//copy file to destination
        	FileUtils.copyFile(src, trg);
        	
        }
    	
    	catch(Exception e) {
    		
    	}
    	
    	
    	
    	System.out.println("Tear down method Executed....");
    	
		driver.quit();
    	}
    	
    	}
	
	@AfterStep
	public  void addScreenshot(Scenario scenario){

	if(scenario.isFailed()){
	final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	//attach image file report(data, media type, name of the attachment)
	scenario.attach(screenshot, "image/png", scenario.getName());
	}

}
}  
   /* @BeforeStep
    public void beforestepmethod() {
    	
    	System.out.println("executes before scenario's teststeps...");
    }
     @AfterStep
    public void afterstepmethod() {
    	
    	System.out.println("executes after scenario's teststeps...");
    }*/
     
	

