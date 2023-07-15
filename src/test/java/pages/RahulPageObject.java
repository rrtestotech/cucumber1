package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import steps.RahulTestBase;

public class RahulPageObject {

	private WebDriver driver;
	RahulTestBase rahulTestBase;

 

	public RahulPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		rahulTestBase = new RahulTestBase(driver);

	}

	@FindBy(xpath = "//*[@value='radio1']")
	public WebElement radioButton1;
	@FindBy(xpath = "//*[@value='radio2']")
	public WebElement radioButton2;

	@FindBy(xpath = "//button[text()='Home']")
	public WebElement home;
	
	@FindBy(id="checkBoxOption1")
	public WebElement checkBox1;
	
	@FindBy(id="dropdown-class-example")
	public WebElement dropDownExample;
	

	

	public void homeClick() throws InterruptedException {

		rahulTestBase.clickOnButton(home);
		Thread.sleep(3000);
		rahulTestBase.navigateBack();

	}

	public void launchApp(String string) {
		driver.get(string);
		driver.manage().window().maximize();
		
	}

	public void clickOnRadioButtonOne() {
		
		rahulTestBase.clickRadioButton(radioButton1);
		Assert.assertEquals(true, radioButton1.isSelected());
		
	}

	public void clickOnRadioButtonTwo() {
		
		rahulTestBase.clickRadioButton(radioButton2);
		Assert.assertEquals(false, radioButton1.isSelected());
		
	}

	public void clickOnOption1() {
		
		rahulTestBase.clickOnButton(checkBox1);
		
	}

	public void selectOption(String option) {
		
		
		rahulTestBase.selectByValue(option,dropDownExample);
		
	}



}
