package com.project.Durgasoft8AMBatch;

import org.apache.log4j.Logger;

public class TC_001 extends BasePage
{
	private static final Logger log=Logger.getLogger(TC_001.class.getName());
	

	public static void main(String[] args) throws Exception 
	{
		openBrowser("chromebrowser");
		log.info("Opened the browser of type :- " + loadData("chromebrowser"));
		
		
		navigate("amazonurl");
		log.info("Navigated to url :- " + loadData("amazonurl"));
		
		
		type("amazonsearchtextbox_name","textvalue");
		log.info("Entered the Search text :- " + loadData("textvalue")  + "by using locator :- "+ loadData("amazonsearchtextbox_name"));
		
		
		click("amazonsearchbutton_xpath");
		log.info("Clicked on Amazon Search button  by using locator :- " + loadData("amazonsearchbutton_xpath"));

	}

}
