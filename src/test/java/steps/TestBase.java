package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import pages.Amazon_LoginLogoutPage;
 
 
import pages.Login;
import utilities.TestUtil;

public class TestBase 
{
	
	public static WebDriver driver;
	public static Properties prop= new Properties();
	public static String current_project_dir;
	public static Logger logger;
	
	public Login login;
	
	public Amazon_LoginLogoutPage loginPage;
	public TestUtil testUtil;
	 
	
 

	
}
