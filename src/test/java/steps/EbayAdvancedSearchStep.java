package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 

public class EbayAdvancedSearchStep {

	WebDriver driver;
	
	
	public EbayAdvancedSearchStep(CommonActions commonActions) {
		driver=commonActions.getDriver();
	}
	
	@Given("^I am on ebay adavanced search page$")
	public void i_am_on_ebay_adavanced_search_page() throws Throwable {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Koush\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Advanced']")).click();;

	}

	@When("^i clicked on ebay logo$")
	public void i_clicked_on_ebay_logo() throws Throwable {
		Thread.sleep(2000);

		driver.findElement(By.id("gh-la")).click();
		
	}

	@Then("^I am navigated to Ebay home page$")
	public void i_am_navigated_to_Ebay_home_page() throws Throwable {
		
		String curUrl=driver.getCurrentUrl();
		String expUrl="https://www.ebay.com/";
		
		if(!expUrl.equalsIgnoreCase(curUrl)){
			fail("Page not navigated to ebay home page");
		}
		
	
	}
	
	

@When("^I advanced search an item$")
public void i_advanced_search_an_item(DataTable dataTable) throws Throwable {
	
	List<String> data=dataTable.row(0);
	
	driver.findElement(By.id("_nkw")).sendKeys(data.get(1));

	driver.findElement(By.id("_ex_kw")).sendKeys(data.get(1));
	driver.findElement(By.name("_udlo")).sendKeys(data.get(1));
	
	driver.findElement(By.name("_udhi")).sendKeys(data.get(1));
}


	
}
