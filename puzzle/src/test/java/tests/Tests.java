package tests;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
	
public WebDriver driver = new ChromeDriver();
	
	@Before
	public void testSetUp() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("http://uitestingplayground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@After
	public void testTearDown() throws InterruptedException {
		//Thread.sleep(5000);
		driver.quit();
	}
	
	//1 - progress bar
	@Test
	@Ignore
	public void progressBar() {
		/*koga se ranova progressBar se priklucva implicitlyWait vo testSetUp 
		 * a se isklucva testTearDown
		 *prviot pat mnogu brzo odi i pagja, sekoj drug pat stopira na 75% */
		
		driver.findElement(By.xpath("//*[@href=\"/progressbar\"]")).click();
		driver.findElement(By.id("startButton")).click();
		while (!driver.findElement(By.xpath("//div[text()='75%']")).isDisplayed()) {
			driver.findElement(By.id("stopButton")).click();
		}
	}
	
	//2 - visibility
	 @Test
	 @Ignore
		public void visibility() {
		driver.findElement(By.xpath("//*[@href=\"/visibility\"]")).click();
		driver.findElement(By.id("hideButton")).click();
		WebElement opacity0 = driver.findElement(By.id("transparentButton"));
		assertFalse(opacity0.isDisplayed());
		boolean exists = !driver.findElements(By.id("removedButton")).isEmpty();
		assertFalse(exists);
		WebElement visibilityHidden = driver.findElement(By.id("invisibleButton"));
		assertFalse(visibilityHidden.isDisplayed());
		WebElement zeroWidth = driver.findElement(By.id("zeroWidthButton"));
		assertFalse(zeroWidth.isDisplayed());
		WebElement displayNone = driver.findElement(By.id("notdisplayedButton"));
		assertFalse(displayNone.isDisplayed());
		boolean overlapped = !driver.findElements(By.id("overlappedButton")).isEmpty();
		assertTrue(overlapped);
		WebElement offScreen = driver.findElement(By.id("offscreenButton"));
		assertFalse(offScreen.isDisplayed());
		
	   } 
	
	
	//3 - sample app	        
	   @Test
	   @Ignore
		public void sampleApp() {
		/*za sampleApp i site drugi posle nego se isklucuva implicitlyWait vo testSetUp 
		 * i priklucuva thread.sleep*/
		driver.findElement(By.xpath("//*[@href=\"/sampleapp\"]")).click();
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("user123");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("pwd");
		driver.findElement(By.id("login")).click();
	}
	
	//4 - mouse over
	   @Test
	   @Ignore
		public void mouseOver() {
		driver.findElement(By.xpath("//*[@href=\"/mouseover\"]")).click();
		driver.findElement(By.xpath("//a[@title = 'Click me']")).click();
		driver.findElement(By.xpath("//a[@title = 'Click me']")).click();
	   }   
	   
	   
	   
	//5 - non-breaking space
	   @Test
	   @Ignore
		public void nonbreakingSpace() {
		driver.findElement(By.xpath("//*[@href=\"/nbsp\"]")).click();
		driver.findElement(By.xpath("//button[normalize-space()='My Button']")).click();
		
	   }
	   
	//6 - overlapped element
	   @Test
	   @Ignore
		public void overlappedElement() {
		driver.findElement(By.xpath("//*[@href=\"/overlapped\"]")).click();
		WebElement element = driver.findElement(By.id("name"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("user");
		
	}
	   
}
