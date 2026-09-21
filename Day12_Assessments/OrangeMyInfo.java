
package selenium.PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeMyInfo {

    private WebDriver d;
    private WebDriverWait wait;

    private final By loader = By.className("oxd-form-loader");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");

    private final By employeeId = By.xpath(
        "//label[normalize-space()='Employee Id']" +
        "/parent::div/following-sibling::div/child::input"
    );

    public OrangeMyInfo(WebDriver d) {
        this.d = d;
        this.wait = new WebDriverWait(d, Duration.ofSeconds(8));
        PageFactory.initElements(d, this);
    }

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    private WebElement myinfo;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement save;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement profile;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement Lout;


    // Wait for the loading overlay to disappear
    private void waitForLoader() {
        wait.until(
            ExpectedConditions.invisibilityOfElementLocated(loader)
        );
    }


    // Fast clear and type
    private void clearAndType(By locator, String value) {

        WebElement element = d.findElement(locator);

        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(value);
    }


    // Navigate to My Info
    public void myinfo() {

        wait.until(
            ExpectedConditions.elementToBeClickable(myinfo)
        ).click();

        waitForLoader();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(firstName)
        );
    }


    // Enter first name
    public void fname(String fname) {
        clearAndType(firstName, fname);
    }


    // Enter last name
    public void lname(String lname) {
        clearAndType(lastName, lname);
    }


    // Enter employee ID
    public void emp(String empidValue) {
        clearAndType(employeeId, empidValue);
        System.out.println("Employee ID entered: " + empidValue);
    }


    // Save changes
    public void s() {
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
        waitForLoader();
    }


    // Open profile dropdown
    public void getProfile() {

        wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
    }

    // Logout
    public void getLout() {

        wait.until(ExpectedConditions.elementToBeClickable(Lout)).click();
    }

    // Get first name
    public String getFirstName() {

        return d.findElement(firstName).getAttribute("value");
    }

    // Get last name
    public String getLastName() {

        return d.findElement(lastName).getAttribute("value");
    }

    // Get employee ID
    public String getEmployeeId() {
        return d.findElement(employeeId).getAttribute("value");
    }
}