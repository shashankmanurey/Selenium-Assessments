
package selenium.PomUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class OrangeVac {

    WebDriver d;
    WebDriverWait wait;

    // Constructor
    public OrangeVac(WebDriver d) {
        this.d = d;

        wait = new WebDriverWait(d, Duration.ofSeconds(15));
        PageFactory.initElements(d, this);
    }

    // Vacancy Name
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement vacancy;

    // Job Title dropdown
    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement job;

    // Description
    @FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    private WebElement desc;

    // Hiring Manager
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement hm;

    // Number of Positions
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    private WebElement numPos;

    // Save button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement save;

    // Enter Vacancy Name
    public void enterVacancy(String vacancyName) 
    {
        vacancy.sendKeys(vacancyName);
    }

    // Select Job Title from dropdown
    public void selectJob(String jobTitle) 
    {
        // Open the dropdown
        job.click();
        // Locate the required job title
        By jobOption = By.xpath("//div[@role='listbox']//span[normalize-space()='"+ jobTitle + "']");
        // Wait and select the option
        wait.until(ExpectedConditions.elementToBeClickable(jobOption)).click();
    }

    // Enter Description
    public void enterDesc(String description) 
    {
        wait.until(ExpectedConditions.visibilityOf(desc)).sendKeys(description);
    }

    // Select Hiring Manager from autocomplete
    public void selectHM(String manager) throws InterruptedException, AWTException 
    {
        hm.sendKeys(manager);
		Thread.sleep(2000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_DOWN);
        r1.keyRelease(KeyEvent.VK_DOWN);

        r1.keyPress(KeyEvent.VK_ENTER);
        r1.keyRelease(KeyEvent.VK_ENTER);
    }

    // Enter Number of Positions
    public void enterNumPos(String number) 
    {
        numPos.sendKeys(number);
    }

    // Click Save
    public void clickSave() {
        save.click();
    }
}