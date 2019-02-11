package com.project.Durgasoft8AMBatch;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUI extends BasePage
{
	//login Page
	@FindBy(linkText="Sign in") public WebElement signIn;
	@FindBy(id="email") WebElement customerEmail;
	@FindBy(id="passwd") WebElement customerPassword;
	@FindBy(id="SubmitLogin") WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]") WebElement getErrorMessage;

	//Registration Page Properties
			@FindBy(id="email_create") public WebElement custEmail;
			@FindBy(id="SubmitCreate") public WebElement Submit;
			@FindBy(xpath=".//*[@id='create_account_error']/ol/li") public WebElement error;
			@FindBy(id="id_gender1") public WebElement Title_gen1;
			@FindBy(id="id_gender2") public WebElement Title_gen2;
			@FindBy(id="customer_firstname") public WebElement FirstName;
			@FindBy(id="customer_lastname") public WebElement LastName;
			@FindBy(id="days") public WebElement DOB_day;
			@FindBy(id="months") public WebElement DOB_month;
			@FindBy(id="years") public WebElement DOB_year;
			@FindBy(id="firstname") public WebElement FirtName_address;
			@FindBy(id="lastname") public WebElement LastName_address;
			@FindBy(id="company") public WebElement Company;
			@FindBy(id="address1") public WebElement Address_1;
			@FindBy(id="address2") public WebElement Address_2;
			@FindBy(id="city") public WebElement City;
			@FindBy(id="id_state") public WebElement State;
			@FindBy(id="postcode") public WebElement Postcode;
			@FindBy(id="id_country") public WebElement Country;
			@FindBy(id="other") public WebElement TextArea;
			@FindBy(id="phone") public WebElement Phone;
			@FindBy(id="phone_mobile") public WebElement Mobile_Phone;
			@FindBy(id="alias") public WebElement Alias_address;
			@FindBy(id="submitAccount") WebElement submitAccount;
	
	
	
	
	
	
	public PageUI(WebDriver driver) 
	{
		//PageFactory.initElements(driver, PageUI.class.getName());
		PageFactory.initElements(driver, this);
	}

	public void login()
	{
		signIn.click();
		customerEmail.sendKeys("qatest8788@gmail.com");
		customerPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public String verifyError()
	{
		return getErrorMessage.getText();
	}
	
	public void customerRegistration() throws InterruptedException, IOException
	{
		signIn.click();
		custEmail.sendKeys(loadData("fname")+loadData("lname")+ranNumber()+loadData("domain"));
		System.out.println(custEmail.getAttribute("value"));
		Submit.click();
		
		//Thread.sleep(4000);
		
		waitForElement(60, Title_gen1);
		
		Title_gen1.click();
		FirstName.sendKeys("qa");
		LastName.sendKeys("test");
		customerPassword.sendKeys("password");	
		
		selectItem(DOB_day, 1);
		selectItem(DOB_month, 1);
		selectItem(DOB_year, 3);
		
		Address_1.sendKeys("hyderabad");
		City.sendKeys("hyderabad");
		State.sendKeys("California");
		Postcode.sendKeys("12345");
		Country.sendKeys("United States");
		Mobile_Phone.sendKeys("1234567890");
		//submitAccount.click();
		
	}

	
	
}
