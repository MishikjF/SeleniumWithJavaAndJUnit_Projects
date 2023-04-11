package objects;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Common {
	
	//initialize driver
	private WebDriver driver;
	
	public Common(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void testSetUp() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver.get("https://qacourse.churlinoski.mk/");	
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class=\"woocommerce-store-notice__dismiss-link\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	

	public void testTearDown()  {
		driver.quit();
	}

	public int generateRndForReg() {
		Random randomGenerator = new Random();
        return randomGenerator.nextInt(100000);
	}
	
}
