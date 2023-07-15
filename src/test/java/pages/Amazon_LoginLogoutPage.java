package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.TestUtil;

public class Amazon_LoginLogoutPage {

	private WebDriver driver;

	@FindBy(xpath = "//input[@type='email']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement Continue;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement loginButton;

	@FindBy(xpath="//div[@id='nav-tools']/a[@data-nav-role='signin']")
	WebElement SignInfromNav;

	@FindBy(xpath = "//span[contains(text(),'Sign')]/parent::a")
	public WebElement logoutBtn;

	@FindBy(xpath = "//div[@id='nav-xshop']/a")
	public WebElement allShopNav;

	@FindBy(xpath = "//span[@data-nav-panelkey='TvApplElecPanel']")
	public WebElement TvApplElecPanel;
	
	@FindBy(xpath = "//a[text()=' Electronics ']")
	WebElement electronics;

	@FindBy(xpath = "//span[contains(text(),'Headphones')]/parent::a")
	public WebElement headPhonesCatLnk;

	@FindBy(xpath = "//*[@class='a-container']//a[@title='Headphones']")
	public WebElement firstHeadPhoneLnk;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	public WebElement addToCartBtn;

	@FindBy(xpath = "//a[@id='nav-cart']")
	public WebElement cartButton;

	@FindBy(xpath = "//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']")
	public List<WebElement> itemList;

	// form[@id='activeCartViewForm']/div[@data-name='Active Items' or
	// contains(@class,'sc-list-body')]//input[@value='Delete']

	@FindBy(xpath = "//div[contains(@class,'nav-search-field')]/input")
	public WebElement itemSearchField;

	@FindBy(xpath = "//div[starts-with(@class,'sg-col-4')]/div[@class='sg-col-inner']/div/h5/a")
	public WebElement secondMacbookItem;

	@FindBy(xpath = "//select[@id='quantity' or @name='quantity']")
	public List<WebElement> qtyField;
	
	@FindBy(xpath= "//span[@class='a-list-item']//span[contains(text(),'Headphones, Earbuds & Accessories')]")
	WebElement headPhones;
	
	
	
	TestUtil testUtil;

	public Amazon_LoginLogoutPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
			testUtil = new TestUtil(driver);
			//waitHelper.WaitForElement(userName, 60);
		}

	public void enterUserName(String userName) {
		this.userName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void enterSearchItemandAddToCart(String item) {
		String mainWindow = driver.getWindowHandle();
		this.itemSearchField.sendKeys(item);
		this.itemSearchField.submit();
		secondMacbookItem.click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				if (qtyField.size() >= 1) {

					Select sel = new Select(qtyField.get(0));
					sel.selectByValue("2");
				}

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
				js.executeScript("arguments[0].click();", addToCartBtn);
				if (driver.findElements(By.xpath("//div[@class='a-popover-inner']//button[contains(text(),'Skip')]"))
						.size() >= 1) {

					driver.findElements(By.xpath("//div[@class='a-popover-inner']//button[contains(text(),'Skip')]"))
							.get(0).click();
				}
				// addToCartBtn.click();
				// driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}

	public void clickSignInButton() {
		Actions builder = new Actions(driver);
		builder.moveToElement(SignInfromNav).build().perform();
		SignInfromNav.click();
	}

	public void clearCartItemifExist() {
		cartButton.click();
		int i = itemList.size();
		if (i >= 1) {
			itemList.get(0).click();
			i = itemList.size();
		}
	}

	public void clickHeadphonesLnk() {
		Actions builder = new Actions(driver);
		builder.moveToElement(electronics).click().build().perform();
		builder.moveToElement(headPhones).click().build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", headPhonesCatLnk);

	}

	public void AddHeadphoneToCart() {

		
		firstHeadPhoneLnk.click();
		String parentWindow=driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		set.remove(parentWindow);
		for(String win:set)
			driver.switchTo().window(win);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addToCartBtn);
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	public void clickContinueButton() {
		Continue.click();
	}

	public void clickLogoutButton() {
		Actions builder = new Actions(driver);
		builder.moveToElement(SignInfromNav).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logoutBtn);
		
	}
}
