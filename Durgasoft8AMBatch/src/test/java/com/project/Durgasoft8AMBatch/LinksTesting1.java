package com.project.Durgasoft8AMBatch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinksTesting1 extends BasePage
{

	
	@BeforeMethod(groups= {"regression","sanity"})
	@Parameters("browser")
	public void setup(String btype) throws Exception
	{
		openBrowser(btype);
		navigate("googleurl");
	}
	
	
	
	
	@Test(groups= {"regression","sanity"})
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Images")).click();	
		Reporter.log("Clicked on Image Link");
		String actval=driver.getTitle();
		
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod(groups= {"regression","sanity"})
	public void tearDown()
	{
		close();
	}

}
