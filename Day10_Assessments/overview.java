package selenium.PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class overview {

    WebDriver driver;

    public overview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "continue")
    private WebElement cont;

    @FindBy(className = "title")
    private WebElement overview;

    @FindBy(id = "finish")
    private WebElement finish;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement message;

    public void getcont() {
        cont.click();
    }

    public boolean verifyOverview() {
        return overview.isDisplayed();
    }

    public void getfinish() {
        finish.click();
    }

    public boolean verifyMessage() {
        return message.isDisplayed();
    }
}