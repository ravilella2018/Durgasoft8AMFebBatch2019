package com.project.Durgasoft8AMBatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RadioButton1 extends BasePage
{

	@BeforeMethod(groups= {"regression","smoke"})
	@Parameters("browser")
	  public void beforeMethod(String btype) throws Exception 
	  {
		openBrowser(btype);
		navigate("radiourl");	
	  }
	
	
	@Test(groups= {"regression","smoke"})
	public void radioButton()
	{
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod(groups= {"regression","smoke"})
  public void afterMethod() 
  {
	  close();
  }
	
}
