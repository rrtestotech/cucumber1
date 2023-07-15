package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		 
	    WebDriver driver;
	
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	 	        // This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @FindBy(id = "welcome")
	    WebElement homePageUserName;
	 
	 
	    // Get the User name from Home Page
	    public String getHomePageText() {
	        return homePageUserName.getText();
	 
	    }
	}
	

