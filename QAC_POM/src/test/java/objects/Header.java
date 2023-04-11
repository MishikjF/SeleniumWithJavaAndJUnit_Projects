package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
	
	//initialize driver
	private WebDriver driver;
	
	public Header(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	//Header elements
	@FindBy(xpath = "//ul[@id='menu-main']//li[@id='menu-item-103']//a")
	WebElement homeLink;
	
	@FindBy(xpath = "//span[text()='Products']/parent::a)[1]")
	WebElement productsMenu;
	
	@FindBy(xpath = "//span[text()='Clothing']/parent::a)[1]")
	WebElement clothingSubMenu;
	
	@FindBy(xpath = "//ul[@id='menu-main']//li[@id='menu-item-160']//a")
	WebElement tshirtsLink;
	
	@FindBy(xpath = "//*[@id=\"menu-item-159\"]/a/span")
	WebElement hoodiesLink;
	
	@FindBy(xpath = "//*[@id=\"menu-item-158\"]/a/span")
	WebElement accessoriesLink;
	
	@FindBy(xpath = "//*[@id=\"menu-item-156\"]/a/span")
	WebElement decorLink;
	
	@FindBy(xpath = "//*[@id=\"menu-item-155\"]/a/span")
	WebElement musicLink;
	
	@FindBy(xpath = "//span[text()='About']/parent::a)[1]")
	WebElement aboutUsLink;
	
	@FindBy(xpath = "//*[@id=\"menu-item-140\"]/a/span")
	WebElement contactLink;
	
	@FindBy(xpath = "//span[@class='tools-icon header-search-icon']//span[@class='woostify-svg-icon icon-search']//*[name()='svg']")
	WebElement searchIcon;
	
	@FindBy(xpath = "//a[@class=\"tools-icon my-account-icon \"]")
	WebElement registerLoginIcon;
	
	@FindBy(xpath = "//*[@id=\"svg50\"]")
	WebElement shoppingCartIcon;
	
	@FindBy(xpath = "//*[@class=\"woocommerce-store-notice__dismiss-link\"]")
	WebElement dismissNotice;
	
	//Header functions
	public Header clickHomeLink() {
		homeLink.click();
		return this;
	}
	
	public Header clickProductsMenu() {
		productsMenu.click();
		return this;
	}
	
	public Header clickClothingSubMenu() {
		clothingSubMenu.click();
		return this;
	}
	
	public Header clickTshirtsLink() {
		tshirtsLink.click();
		return this;
	}
	
	public Header clickHoodiesLink() {
		hoodiesLink.click();
		return this;
	}
	
	public Header clickAccessoriesLink() {
		accessoriesLink.click();
		return this;
	}
	
	public Header clickDecorLink() {
		decorLink.click();
		return this;
	}
	
	public Header clickMusicLink() {
		musicLink.click();
		return this;
	}
	
	public Header clickAboutUsLink() {
		aboutUsLink.click();
		return this;
	}
	
	public Header clickContactLink() {
		contactLink.click();
		return this;
	}
	
	public Header clicksearchIcon() {
		searchIcon.click();
		return this;
	}
	
	public Header clickRegisterLoginIcon() {
		registerLoginIcon.click();
		return this;
	}
	
	public Header clickShoppingCartIcon() {
		shoppingCartIcon.click();
		return this;
	}
	
	public Header clickDismissNotice() {
		dismissNotice.click();
		return this;
	}
	
}
