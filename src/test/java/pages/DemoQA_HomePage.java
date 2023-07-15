package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQA_HomePage {
	
    WebDriver driver;
    
    
    public DemoQA_HomePage(WebDriver driver) {
   	 
        this.driver = driver;
 
        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(name = "txtUsername")
    WebElement userName;
 
    
    
    

}
