package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Customers {

	WebDriver ldriver;
	
	public Customers(WebDriver rdriver) 
	{
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	// Use @FindBy to identify all the webElements which we need to interact in the webpage
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customers_menu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customer_item;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement addnewbtn;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtpassword;
	
	@FindBy(id="FirstName")
	WebElement txtfirstname;
	
	@FindBy(id="LastName")
	WebElement txtlastname;
	
	@FindBy(id="Gender_Male")
	WebElement gender;
	
	@FindBy(xpath="//div[@class='input-group-append input-group-required']//div[@role='listbox']")
	WebElement drpcustomerroles;
	
	
	@FindBy(id="Company")
	WebElement txtcompanyName;
	
	@FindBy(name="DateOfBirth")
	WebElement txtDOB;
	
	@FindBy(name="save")
	WebElement saveBtn;
	
	
	
	// Creating action methods 
 public String gettitle()
 {
	 return ldriver.getTitle();
	 
 }
	
	public void customermenu() {
	customers_menu.click();
	
}
	
	public void customerIteam() {
		
		customer_item.click();
	}
	
	public void AddBtn() {
		addnewbtn.click();
	}
	
	public void emailAdd(String emailadd) {
		
		txtEmail.sendKeys(emailadd);
	}
	
public void PasswordAdd(String Passwdadd) {
		
		txtEmail.sendKeys(Passwdadd);
	}
	
public void firstname(String fname) {
	
	txtfirstname.sendKeys(fname);
}

public void lastname(String lname) {
	
	txtlastname.sendKeys(lname);
}

public void gender()
{
	gender.click();	
}

/*public void Customerdrpdown(String value) 
{
	Select drp=new Select(drpcustomerroles);
	drp.selectByValue(value);
	
}*/

public void DOB(String dob) 
{
	txtDOB.sendKeys(dob);
	
	}

public void companyname(String company) {
	txtcompanyName.sendKeys(company);
}

public void saveBtn()
{

	saveBtn.click();
}


	
}

