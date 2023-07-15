package utilities;

import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class BrowserFactory 
{
	static WebDriver driver=null;
	static String dir;
	static String browser;
	public static WebDriver checkBrowser(WebDriver driver,String current_project_dir,String browserName)
	{
		dir=current_project_dir;
		browser=browserName;
		
		if(driver==null) {
			
	
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",current_project_dir+"/Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			if(driver==null)
			driver = new ChromeDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", current_project_dir+"/Drivers/geckodriver.exe");
			if(driver==null)
			driver = new FirefoxDriver();
				
		}
	
		}
		return driver;
		
	
		
	}
	
	public static WebDriver returnBrowser() {
		
		if(driver==null)
		driver = checkBrowser(driver,dir,browser);
		return driver;
	}
	
	
}
