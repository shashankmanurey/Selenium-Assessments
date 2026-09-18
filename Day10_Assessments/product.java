package selenium.PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product {
	WebDriver driver;
	public product(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement ad;
	@FindBy(css = ".shopping_cart_badge")
	private WebElement sb;
	@FindBy(id = "shopping_cart_container")
	private WebElement sc;
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	private WebElement cart;
	public void getad() {
		ad.click();
	}
	public String getsb() {
		return sb.getText();
	}
	public void getsc() {
		sc.click();
	}
	public boolean verifyCartPage() {
        return cart.isDisplayed();
    }
}