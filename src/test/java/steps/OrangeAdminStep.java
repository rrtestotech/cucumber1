package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 

public class OrangeAdminStep {
	
	
	WebDriver driver;
		
	public OrangeAdminStep(CommonActions commonActions)
	{
		this.driver=commonActions.getDriver();

	}
	
	@Given("^I am orange HRM home page$")
	public void i_am_orange_HRM_home_page() throws Throwable {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	 
	}

	@When("^I click on Admin tab$")
	public void i_click_on_Admin_tab() throws Throwable {
	
	}

	@When("^enter username as \"([^\"]*)\" and click on search$")
	public void enter_username_as_and_click_on_search(String arg1) throws Throwable {
	  
	}

	@Then("^validate the result$")
	public void validate_the_result() throws Throwable {
	
	}

	

}
