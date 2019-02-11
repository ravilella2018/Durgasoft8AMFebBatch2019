package com.project.Durgasoft8AMBatch;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_006 extends BasePage
{
	PageUI page;
	
  @BeforeMethod
  public void startProcess() throws Exception 
  {
	  openBrowser("chromebrowser");
	  navigate("automationurl");
  }
  
  
  @Test(enabled=false)
  public void automationLogin() 
  {
	  page=new PageUI(driver);
	  page.login();
	  assertEquals(page.verifyError(), "Authentication failed.");  
  }
  
  
  @Test
  public void automationRegistration() throws InterruptedException, IOException
  {
	  page=new PageUI(driver);
	  page.customerRegistration();
  }

  @AfterMethod
  public void endProcess() 
  {
	  
  }

}
