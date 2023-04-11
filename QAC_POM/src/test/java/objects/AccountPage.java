package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	//initialize driver
	private WebDriver driver;
	public AccountPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	//Account elements
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']")
	WebElement myAccountDashboard;
	
	//Account functions
	public boolean isDisplayedMyAccountDashboard() {
		return myAccountDashboard.isDisplayed();
	}

}
