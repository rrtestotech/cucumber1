package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 
public class Ebay_Home_Steps {



	WebDriver driver;
	
	public Ebay_Home_Steps(CommonActions commonActions) {
		driver=commonActions.getDriver();
	}

	@Given("I am on Ebay Home page")
	public void i_am_on_ebay_hoome_page() {
		
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\Koush\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	//	driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
	}

	@When("I click on Advanced link")
	public void i_click_on_advanced_link() {
	    
		driver.findElement(By.linkText("Advanced")).click();
	}

	@Then("I navigate to Advance search page")
	public void i_navigate_to_advance_search_page() throws InterruptedException {
	 
		String expUrl="https://www.ebay.com/sch/ebayadvsearch";
		String actUrl=driver.getCurrentUrl();
		
		if(!expUrl.equalsIgnoreCase(actUrl)){
			fail("Page not navigated to home page");
		}
		
		Thread.sleep(2000);
		//driver.quit();
		
		//assertEquals("failure - strings are not equal", expUrl, actUrl);
		//System.out.println(actUrl);
	}
	
	@When("^i search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		
		driver.findElement(By.id("gh-ac")).sendKeys(arg1);
		driver.findElement(By.id("gh-btn")).click();
	
	}

	@Then("i validate atleast (.*) search items present")
	public void i_validate_atleast_search_items_present(int value) throws Throwable {
		
		String count=driver.findElement(By.xpath("(//div[@id='mainContent']//h1//span[@class='BOLD'])[1]")).getText().replace(",", "");
		
	
		int countInt=Integer.parseInt(count);
		
		/*if(countInt<=value) {
			fail("Less than "+value+" results shown");
		}*/
		
		Assert.assertFalse("Lesser values",countInt<=value);
	  
	}

	
	

@When("^i search for \"([^\"]*)\" in \"([^\"]*)\" category$")
public void i_search_for_in_category(String arg1, String arg2) throws Throwable {
	
	Select option=new Select(driver.findElement(By.id("gh-cat")));
	option.selectByValue(arg2);
	
	driver.findElement(By.id("gh-ac")).sendKeys(arg1);
	driver.findElement(By.id("gh-btn")).click();
	

}



@When("^I click on \"([^\"]*)\"$")
public void i_click_on(String link) throws Throwable {
	
	String xpathOfEle="(//div[@id='mainContent']//div[@class='hl-cat-nav']//a[text()='%placeHolder'])[1]".replace("%placeHolder", link);
	driver.findElement(By.xpath(xpathOfEle)).click();

}

@Then("^validate that the page navigate to \"([^\"]*)\" and titile contains \"([^\"]*)\"$")
public void validate_that_the_page_navigate_to_and_titile_contains(String url, String title) throws Throwable {

	String curUrl=driver.getCurrentUrl();
	if(!(curUrl.equalsIgnoreCase(url))){
		fail("Url not matched");
	}
	
	String actTitle=driver.getTitle();
	if(!(actTitle.contains(title))){
		fail("Title not matched");
	}
	
	
}

}
