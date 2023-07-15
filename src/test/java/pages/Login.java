package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtil;

public class Login
{
	WebDriver pdriver;
	
	
	@FindBy(name  = "username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement logInBtn;
	
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	@CacheLookup
	WebElement profileLink;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement logOutBtn;
	
	
	
	public Login(WebDriver driver)
	{
		pdriver = driver;
		PageFactory.initElements(pdriver, this);
	}
	
	public void sendUsername(String uname)
	{
		username.clear();
		username.sendKeys(uname);
	}
	
	public void sendPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		TestUtil.JSClick(pdriver, logInBtn);
	}
	
	public void clickProfile()
	{
		TestUtil.JSClick(pdriver, profileLink);
	}
	
	
	public void clickLogOut()
	{
		TestUtil.JSClick(pdriver, logOutBtn);
	}
	

}
