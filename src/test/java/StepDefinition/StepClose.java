package StepDefinition;

import io.cucumber.java.en.Then;

public class StepClose extends BaseClass{
	@Then("Close Browser")
	public void close_browser() 
	{
	   driver.close();
	   log.info("Browser closed....");
	}

}
