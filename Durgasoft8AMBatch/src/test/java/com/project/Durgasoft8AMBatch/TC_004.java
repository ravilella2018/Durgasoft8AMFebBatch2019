package com.project.Durgasoft8AMBatch;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_004 extends BasePage
{
	

  @BeforeMethod(groups= {"regression"})
  @Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	  openBrowser(btype);
	  navigate("amazonurl");
  }
  
  
  @Test(groups= {"regression"})
  public void amazon1() throws Exception 
  {
	  System.out.println("amazon1 : " +Thread.currentThread().getName());
	  type("amazonsearchtextbox_id", "textvalue");
	  click("amazonsearchbutton_xpath");
  }

  @AfterMethod(groups= {"regression"})
  public void endProcess() 
  {
	  close();
  }

}
