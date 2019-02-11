package com.project.Durgasoft8AMBatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	
	private static final Logger log=Logger.getLogger(BasePage.class.getName());
	public static WebDriver driver;
	static String path="./data.properties";
	
	public static String loadData(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(path);
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	public static void launch(String browser, String url)
	{
		if(browser.equalsIgnoreCase("CHROME"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FF")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,System.getProperty("user.dir")+"//drivers//IEDriverServer.exe" );
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("EDGE"))
		{
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY,System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe" );
			driver=new EdgeDriver();
		}
		
		//driver.get(url);
		
		driver.navigate().to(url);
		
	}
	
	
	public static boolean isElementPresent(String locatorKey) throws IOException 
	{
		List<WebElement> element=null;
		if(locatorKey.endsWith("_id"))
			element=driver.findElements(By.id(loadData(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			element=driver.findElements(By.name(loadData(locatorKey)));
		else if(locatorKey.endsWith("_xpath"))
			element=driver.findElements(By.xpath(loadData(locatorKey)));
		else if(locatorKey.endsWith("_linktext"))
			element=driver.findElements(By.linkText(loadData(locatorKey)));
		
		if(element.size()==0)
			return false;
		else
			return true;
		
	}
	
	public static boolean verifyText(String locatorKey, String expectedValue) throws Exception 
	{
		String actualValue = getElement(locatorKey).getText().trim();
		System.out.println("Actual value : "+ actualValue);
		System.out.println("Expected value : "+ loadData(expectedValue));
		if(actualValue.equalsIgnoreCase(loadData(expectedValue)))
			return true;
		else
			return false;
		
	}
	
	
	public static void click(String locatorKey) throws IOException 
	{
		driver.findElement(By.xpath(loadData(locatorKey))).click();
		
	}

	public static void type(String locatorKey, String valueKeys) throws Exception 
	{
		//driver.findElement(By.name(loadData(locatorKey))).sendKeys(loadData(valueKeys));
		 getElement(locatorKey).sendKeys(loadData(valueKeys));
	}
	
	

	public static WebElement getElement(String locatorKey) throws Exception 
	{
		WebElement e=null;
		if(locatorKey.endsWith("_id"))
			e=driver.findElement(By.id(loadData(locatorKey)));
		else if(locatorKey.endsWith("_name"))
			e=driver.findElement(By.name(loadData(locatorKey)));
		else if(locatorKey.endsWith("_xpath"))
			e=driver.findElement(By.xpath(loadData(locatorKey)));
		else if(locatorKey.endsWith("_linktext"))
			e=driver.findElement(By.linkText(loadData(locatorKey)));
		else
			//System.out.println("No locator is matching..");
			reportFailure("No locator is matched ... " + loadData("locatorKey"));
		return e;
					
	}

	public static void reportFailure(String msg) throws IOException 
	{
		takeScreenShot();
		log.info(msg);
		
	}

	public static void takeScreenShot() throws IOException 
	{
		Date dt=new Date();
		String fileName = dt.toString().replace(":", "_").replace(" ", "_")+".jpeg";
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile,new File("C:\\Users\\DELL\\Desktop\\"+rep+".png"));
		FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"//failure//"+fileName));
		
	}

	public static void navigate(String urlKey) throws Exception 
	{
		driver.get(loadData(urlKey));		
	}
	

	
	public static void openBrowser(String browserKey) throws IOException 
	{
		if(loadData(browserKey).equalsIgnoreCase("CHROME"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(loadData(browserKey).equalsIgnoreCase("FF")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(loadData(browserKey).equalsIgnoreCase("IE"))
		{
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,System.getProperty("user.dir")+"//drivers//IEDriverServer.exe" );
			driver=new InternetExplorerDriver();
		}
		else if(loadData(browserKey).equalsIgnoreCase("EDGE"))
		{
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY,System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe" );
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		String path="./log4j.properties";
		PropertyConfigurator.configure(path);
		
	}

	
	public static void close() 
	{
		driver.quit();
	}
	
	
	public void waitForElement(int timeInSeconds,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void selectItem(WebElement element,int value )
	{
		Select s=new Select(element);
		s.selectByIndex(value);
	}
	
	
	public int ranNumber() 
	{
		Random r=new Random();
		int rnum = r.nextInt(999999);
		return rnum;
	}
	

}
