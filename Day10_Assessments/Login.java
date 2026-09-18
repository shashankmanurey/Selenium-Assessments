package selenium.PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	 WebDriver driver;
		public Login(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(id = "user-name")
		private WebElement us;
		@FindBy(id="password")
		private WebElement pd;
		@FindBy(id = "login-button")
		private WebElement login;
		@FindBy(xpath = "//span[text()='Products']")
	    private WebElement products;
		public void getus(String value) {
			us.sendKeys(value);
		}
		public void getpd(String value) {
			pd.sendKeys(value);
		}
		public void getlogin() {
			login.click();
		}
		public boolean verifyProductsPage() {
	        return products.isDisplayed();
	    }
}