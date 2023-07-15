package steps;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.RahulPageObject;

public class RahulStep  {

	WebDriver driver;
	RahulPageObject rahulPageObject;

	@Before
	public void Steup() {

		if(driver==null) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		} 
		rahulPageObject = new RahulPageObject(driver);
 
	}

	@Given("I am on {string} url")
	public void i_am_on_url(String string) {

		rahulPageObject.launchApp(string);
	}

	@When("click on home page")
	public void click_on_home_page() throws InterruptedException {
		rahulPageObject.homeClick();
	}
	
	@And("click on RadioButton one")
	public void click_on_radio_button_one() {
		rahulPageObject.clickOnRadioButtonOne();
	}
	
	
	@And("click on RadioButton two")
	public void click_on_radio_button_two() {
		rahulPageObject.clickOnRadioButtonTwo();
	}
	
	
	@And("click on option1")
	public void click_on_option1() {
		rahulPageObject.clickOnOption1(); 
		
	}
	
	
	 

	@Given("select {string} from dropDown example")
	public void select_from_drop_down_example(String option) {
		rahulPageObject.selectOption(option);
	}



	
	

}
