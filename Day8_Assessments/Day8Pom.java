package selenium.PomUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day7Pom {

    WebDriver driver;

    public Day7Pom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitment;

    @FindBy(xpath = "//a[normalize-space()='Candidates']")
    private WebElement candidates;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    private WebElement addCandidate;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//label[normalize-space()='Vacancy']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
    private WebElement vacancy;

    @FindBy(xpath = "//label[normalize-space()='Email']/../following-sibling::div//input")
    private WebElement email;

    @FindBy(xpath = "//label[normalize-space()='Contact Number']/../following-sibling::div//input")
    private WebElement mobileNumber;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;

    @FindBy(xpath = "//label[normalize-space()='Date of Application']/../following-sibling::div//input")
    private WebElement applicationDate;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement save;

    @FindBy(xpath = "//label[normalize-space()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
    private WebElement jobTitle;

    @FindBy(xpath = "//label[normalize-space()='Vacancy']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
    private WebElement jobVacancy;

    @FindBy(xpath = "//label[normalize-space()='Hiring Manager']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
    private WebElement hiringManager;

    @FindBy(xpath = "//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
    private WebElement status;

    @FindBy(xpath = "//label[normalize-space()='Candidate Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement candidateName;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement dateFrom;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement dateTo;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement search;

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logout;


    public void getUsername(String usernameData) {
        username.sendKeys(usernameData);
    }

    public void getPassword(String passwordData) {
        password.sendKeys(passwordData);
    }

    public void getLogin() {
        login.click();
    }

    public void getRecruitment() {
        recruitment.click();
    }

    public void getCandidates() {
        candidates.click();
    }

    public void getAddCandidate() {
        addCandidate.click();
    }

    public void getFirstName(String firstNameData) {
        firstName.sendKeys(firstNameData);
    }

    public void getMiddleName(String middleNameData) {
        middleName.sendKeys(middleNameData);
    }

    public void getLastName(String lastNameData) {
        lastName.sendKeys(lastNameData);
    }

    public void getVacancy(String vacancyData) {
        vacancy.click();

        driver.findElement(
            By.xpath("//div[@role='option']//span[normalize-space()='" + vacancyData + "']")
        ).click();
    }

    public void getEmail(String emailData) {
        email.sendKeys(emailData);
    }

    public void getMobileNumber(String mobileData) {
        mobileNumber.sendKeys(mobileData);
    }

    public void getResume(String resumePath) {
        resume.sendKeys(resumePath);
    }

    public void getApplicationDate(String dateData) {
		applicationDate.click();
		applicationDate.clear();
		applicationDate.sendKeys(dateData);
		applicationDate.sendKeys(org.openqa.selenium.Keys.TAB);
	}

    public void getSave() {
    org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", save);
	}

    public void getJobTitle(String jobTitleData) {
        jobTitle.click();

        driver.findElement(
            By.xpath("//div[@role='option']//span[normalize-space()='" + jobTitleData + "']")
        ).click();
    }

    public void getJobVacancy(String vacancyData) {
        jobVacancy.click();

        driver.findElement(
            By.xpath("//div[@role='option']//span[normalize-space()='" + vacancyData + "']")
        ).click();
    }

    public void getHiringManager(String hiringManagerData) {
        hiringManager.click();

        driver.findElement(
            By.xpath("//div[@role='option']//span[normalize-space()='" + hiringManagerData + "']")
        ).click();
    }

    public void getStatus(String statusData) {
        status.click();

        driver.findElement(
            By.xpath("//div[@role='option']//span[normalize-space()='" + statusData + "']")
        ).click();
    }

    public void getCandidateName(String candidateNameData) {
        candidateName.sendKeys(candidateNameData);
    }

    public void getDateFrom(String dateData) {
        dateFrom.click();
        dateFrom.clear();
        dateFrom.sendKeys(dateData);
    }

    public void getDateTo(String dateData) {
        dateTo.click();
        dateTo.clear();
        dateTo.sendKeys(dateData);

        dateTo.click();
    }

    public void getSearch() {
        search.click();
    }

    public void getUserDropdown() {
        userDropdown.click();
    }

    public void getLogout() {
        logout.click();
    }
}