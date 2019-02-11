package com.project.Durgasoft8AMBatch;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_005 
{
	
  @Test(priority=1)
  public void orange() 
  {
	  System.out.println("orange");
  }
  
  @Test(priority=2,dependsOnMethods= {"orange"})
  public void white() 
  {
	  System.out.println("white");
  }
  
  
  @Test(priority=3,dependsOnMethods= {"white"})
  public void blue() 
  {
	  System.out.println("blue");
	  Assert.assertTrue(false);
  }
  
  
  @Test(priority=4,dependsOnMethods= {"blue"})
  public void green() 
  {
	  System.out.println("green");
  }
  
}
