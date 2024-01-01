package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rdriver) {
	
	ldriver=rdriver;
	
	PageFactory.initElements(rdriver, this);
}
	// Get here Web Elements from Web Page
	
	@FindBy(id="SearchEmail")
	WebElement searchmail;
	
	@FindBy(id="search-customers")
	WebElement searchBtn;
	
	//@FindBy(xpath="//table[@id='customers-grid']/tbody/tr[1]/td[2]")
	//WebElement searchedmail;
	
	// Action methods implementation
	
	public void SearchEmail(String Email) {
		searchmail.sendKeys(Email);
	}
	
	public void Searchbutton() {
		searchBtn.click();
	}
	
	
	}

