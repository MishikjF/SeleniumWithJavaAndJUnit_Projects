package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRegisterPage {
	
	//initialize driver
	private WebDriver driver;
	
	public LoginRegisterPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	//Register elements
	@FindBy(id = "reg_username")
	WebElement registerUsernameInput;
	
	@FindBy(id = "reg_email")
	WebElement registerEmailInput;
	
	@FindBy(id = "reg_password")
	WebElement registerPasswordInput;
	
	@FindBy(name = "register")
	WebElement registerButton;
	
	@FindBy(xpath = "//*[@class='woocommerce-error']/li")
	WebElement existingEmailErrorText;
	
	@FindBy(xpath = "//ul[@role='alert']")
	WebElement invalidEmailErrorText;
	
	@FindBy(xpath = "//div[@id='content']//li[1]")
	WebElement invalidUsernameErrorText;
	
	//Login elements
	@FindBy(id="username")
	WebElement loginUsernameInput;
	
	@FindBy(id="password")
	WebElement loginPasswordInput;
	
	@FindBy(id="rememberme")
	WebElement rememberMeBox;
	
	@FindBy(xpath = "//button[@name='login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[normalize-space()='Lost your password?']")
	WebElement forgetPasswordLink;
	
	@FindBy(id="user_login")
	WebElement loginUsernameForPasswordReset;
	
	@FindBy(xpath="//button[@value=\'Reset password\']")
	WebElement resetPasswordButton;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement passwordResetEmailAlert;
	
	@FindBy(xpath = "//a[text()='Lost your password?']//parent::li")
	WebElement wrongPasswordErrorText;
	
	@FindBy(xpath = "//*[@id=\"post-9\"]/div/div[1]/ul/li/strong[1]")
	WebElement wrongUsernameErrorText;
	
	@FindBy(xpath = "//strong[contains(text(), 'Error')]")
	WebElement missingUsernameErrorText;
	
	//Register functions
	public void registerAccount(String username, String email, String password) {
		registerUsernameInput.sendKeys(username);
		registerEmailInput.sendKeys(email);
		registerPasswordInput.sendKeys(password);
		registerButton.click();
	}	
	
	public boolean  isDisplayedExistingEmailErrorText() {
		return existingEmailErrorText.isDisplayed();
	}
	
	public boolean  isDisplayedInvalidEmailErrorText() {
		return invalidEmailErrorText.isDisplayed();
	}
	
	public boolean  isDisplayedInvalidUsernameErrorText() {
		return invalidUsernameErrorText.isDisplayed();
	}
	
	//Login functions
	public void loginAccount(String username, String password) {
		loginUsernameInput.sendKeys(username);
		loginPasswordInput.sendKeys(password);
		loginButton.click();
	}	
	
	public void lostPassword(String username, String password) {
		loginUsernameInput.sendKeys(username);
		forgetPasswordLink.click();
		loginUsernameForPasswordReset.sendKeys(username);
		resetPasswordButton.click();
	}	
	
	public boolean  isDisplayedWrongPasswordErrorText() {
		return wrongPasswordErrorText.isDisplayed();
	}
	
	public boolean  isDisplayedWrongUsernameErrorText() {
		return wrongUsernameErrorText.isDisplayed();
	}
	
	public boolean  isDisplayedMissingUsernameErrorText() {
		return missingUsernameErrorText.isDisplayed();
	}
	
	public boolean  isDisplayedPasswordResetEmailAlert() {
		return passwordResetEmailAlert.isDisplayed();
	}
}
