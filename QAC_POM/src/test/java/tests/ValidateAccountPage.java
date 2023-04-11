package tests;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objects.AccountPage;
import objects.Common;
import objects.Header;
import objects.LoginRegisterPage;


public class ValidateAccountPage {
	
	//initialize driver
	public WebDriver driver = new ChromeDriver();
	public Header headerObj = new Header(driver);
	public LoginRegisterPage loginRegisterObj = new LoginRegisterPage(driver);
	public AccountPage accObj = new AccountPage(driver);
	public Common commonFunctions = new Common(driver);
	
	@Before
	public void testSetUp() {
		commonFunctions.testSetUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	
	@After
	public void testTearDown()  {
		commonFunctions.testTearDown();
	}
	
	//Register test cases
	@Test
	public void registerUserWithValidData() {
		headerObj.clickRegisterLoginIcon();
		int rnd = commonFunctions.generateRndForReg();
		loginRegisterObj.registerAccount("frosina.m"+rnd, "frosina.m"+rnd+"@localhost.com", "CyMm7@7f2nXt");
		assertTrue(accObj.isDisplayedMyAccountDashboard());
	}
	
	@Test
	public void registerUserWithExistingEmail() {
		headerObj.clickRegisterLoginIcon();
		int rnd = commonFunctions.generateRndForReg();
		loginRegisterObj.registerAccount("frosina.m"+rnd, "frosina.m@localhost.com", "CyMm7@7f2nXt");
		assertTrue(loginRegisterObj.isDisplayedExistingEmailErrorText());
	}
	
	@Test
	public void registerWithUsernameOnly() {
		headerObj.clickRegisterLoginIcon();
		int rnd = commonFunctions.generateRndForReg();
		loginRegisterObj.registerAccount("frosina.m"+rnd, "", "");
		assertTrue(loginRegisterObj.isDisplayedInvalidEmailErrorText());
	}
	
	@Test
	public void registerWithEmailOnly() {
		headerObj.clickRegisterLoginIcon();
		int rnd = commonFunctions.generateRndForReg();
		loginRegisterObj.registerAccount("", "frosina.m"+rnd+"@localhost.com", "");
		assertTrue(loginRegisterObj.isDisplayedInvalidEmailErrorText());
	}
	
	@Test
	public void registerWithPasswordOnly() {
		headerObj.clickRegisterLoginIcon();
		loginRegisterObj.registerAccount("", "", "CyMm7@7f2nXt");
		assertTrue(loginRegisterObj.isDisplayedInvalidEmailErrorText());
	}
	
	//Login test cases
	@Test
	public void loginUserWithValidData() {
		headerObj.clickRegisterLoginIcon();
		loginRegisterObj.loginAccount("frosina.m123","CyMm7@7f2nXt");
		assertTrue(accObj.isDisplayedMyAccountDashboard());
	}
	
	@Test
	public void loginUserWithInvalidPassword() {
		headerObj.clickRegisterLoginIcon();
		loginRegisterObj.loginAccount("frosina.m123","CyMm7@7f2nX1");
		assertTrue(loginRegisterObj.isDisplayedWrongPasswordErrorText());
	}
	
	@Test
	public void loginUserWithInvalidUsername() {
		headerObj.clickRegisterLoginIcon();
		loginRegisterObj.loginAccount("frosina.m128","CyMm7@7f2nXt");
		assertTrue(loginRegisterObj.isDisplayedWrongUsernameErrorText());
	}
	
	@Test
	public void loginUserWithInvalidData() {
		headerObj.clickRegisterLoginIcon();
		loginRegisterObj.loginAccount("frosina.m128","CyMm7@7f2nX1");
		assertTrue(loginRegisterObj.isDisplayedWrongUsernameErrorText());
	}
	
	@Test
	public void loginUserWithNoData() {
		headerObj.clickRegisterLoginIcon();
		loginRegisterObj.loginAccount("","");
		assertTrue(loginRegisterObj.isDisplayedMissingUsernameErrorText());
	}
	
	@Test
	public void lostPasswordBtnFunctionality() {
		headerObj.clickRegisterLoginIcon();
		loginRegisterObj.lostPassword("frosina.m123","frosina.m123");
		assertTrue(loginRegisterObj.isDisplayedPasswordResetEmailAlert());
	}

}
