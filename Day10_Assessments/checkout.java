package selenium.PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkout {
    WebDriver driver;
    public checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    private WebElement checkout;

    @FindBy(id = "first-name")
    private WebElement fn;

    @FindBy(id = "last-name")
    private WebElement ln;

    @FindBy(id = "postal-code")
    private WebElement pc;
    

    public void getcheckout() {
        checkout.click();
    }

    public void getfn(String value) {
        fn.sendKeys(value);
    }

    public void getln(String value) {
        ln.sendKeys(value);
    }

    public void getpc(String value) {
        pc.sendKeys(value);
    }
 
}