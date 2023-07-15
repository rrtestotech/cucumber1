package steps;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RahulTestBase {

	public static WebDriver driver;

	public RahulTestBase(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRadioButton(WebElement ele) {

		ele.click();

	}

	public void clickOnButton(WebElement ele) {

		ele.click();

	}

	public void scrollDown(int points) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = "window.scrollBy(0," + points + ")";
		js.executeScript(value, "");
	}

	public void scrollUp(int points) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = "window.scrollBy(0,-" + points + ")";
		js.executeScript(value, "");
	}
	
	public void scrollDownUntilElementVisible(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	
	public void scrollDownToBottomOfTheWebpage() {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollHorizontallyOnWebPageToSpecificWebElement(WebElement element){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		
	}

	public void selectByValue(String option, WebElement dropDownExample) {
		
		Select options=new Select(dropDownExample);
		options.selectByValue(option);
		
	}
	
	
	
	
	
}
