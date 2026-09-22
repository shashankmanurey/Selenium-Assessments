package selenium.PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeBuzz {
    WebDriver d;
    public OrangeBuzz(WebDriver d)
    {
        this.d = d;
        PageFactory.initElements(d, this);
    }
 
    @FindBy(xpath = "//span[text()='Buzz']")
    private WebElement bz;

    @FindBy (xpath = "//textarea[@class='oxd-buzz-post-input']")
    private WebElement tx;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement post;

    public void getBuzz()
    {
        bz.click();
    }
    public void gettx(String value)
    {
        tx.sendKeys(value);
    }
    public void getPost()
    {
        post.click();
    }
    public boolean verifyPost(String value) {

        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));
        WebElement postedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'orangehrm-buzz-post-body-text')]")));
        return postedText.isDisplayed();
    }

}
