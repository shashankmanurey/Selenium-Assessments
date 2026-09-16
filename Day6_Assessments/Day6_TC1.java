package com.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day6_TC1 {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Reading data from properties file
		FileInputStream f = new FileInputStream("src/main/Resources/DDT/data1.properties");
		Properties p = new Properties();
		p.load(f);

		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");

		System.out.println(browser);
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);

		// Reading data from Excel file
		FileInputStream f1 = new FileInputStream("src/main/Resources/DDT/Data1.xlsx");
		Workbook w = WorkbookFactory.create(f1);

		DataFormatter formatter = new DataFormatter();

		var sheet = w.getSheet("Sheet1");
		var row = sheet.getRow(1);

		String first_name = formatter.formatCellValue(row.getCell(0));
		String middle_name = formatter.formatCellValue(row.getCell(1));
		String last_name = formatter.formatCellValue(row.getCell(2));
		String eid = formatter.formatCellValue(row.getCell(3));
		String user_name = formatter.formatCellValue(row.getCell(4));
		String password = formatter.formatCellValue(row.getCell(5));
		String employee_name = formatter.formatCellValue(row.getCell(6));

		String confirm_pw = password;

		System.out.println(first_name);
		System.out.println(middle_name);
		System.out.println(last_name);
		System.out.println(eid);
		System.out.println(user_name);
		System.out.println(password);
		System.out.println(employee_name);

		// Launching browser
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser name");
			return;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Login
		driver.get(url);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.name("username"))).sendKeys(un);

		driver.findElement(By.name("password")).sendKeys(pw);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@type='submit']"))).click();

		// Adding employee in PIM
		wait.until(ExpectedConditions.elementToBeClickable(
				By.linkText("PIM"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")))
				.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector(".oxd-form-loader")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.name("firstName"))).sendKeys(first_name);

		driver.findElement(By.name("middleName")).sendKeys(middle_name);
		driver.findElement(By.name("lastName")).sendKeys(last_name);

		WebElement empid = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]/descendant::input")));

		empid.sendKeys(Keys.CONTROL, "a");
		empid.sendKeys(Keys.BACK_SPACE);
		empid.sendKeys(eid);

		// Enabling login details
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector(".oxd-form-loader")));

		WebElement loginSwitch = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[contains(@class,'oxd-switch-input')]")));

		loginSwitch.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector(".oxd-form-loader")));

		// Entering login details
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")))
				.sendKeys(user_name);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'user-password-cell')]//input[@type='password']")))
				.sendKeys(password);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]/descendant::input")))
				.sendKeys(confirm_pw);

		// Saving employee
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector(".oxd-form-loader")));

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[text()=' Save ']"))).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector(".oxd-form-loader")));

		// Searching employee in Admin
		wait.until(ExpectedConditions.elementToBeClickable(
				By.linkText("Admin"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]/descendant::input")))
				.sendKeys(user_name);

		// Selecting Admin role
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]/descendant::div[contains(@class,'oxd-select-text')]")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@role='option']//span[text()='Admin']")))
				.click();

		// Entering employee name
		WebElement employeeName = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@placeholder='Type for hints...']")));

		employeeName.sendKeys(employee_name);

		Thread.sleep(2000);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@role='option']"))).click();
		} catch (Exception e) {
			System.out.println("Employee suggestion was not displayed.");
		}

		// Selecting Enabled status
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]/descendant::div[contains(@class,'oxd-select-text')]")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@role='option']//span[text()='Enabled']")))
				.click();

		// Searching user
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[text()=' Search ']"))).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector(".oxd-form-loader")));

		// Verifying user is present
		boolean userPresent = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[@role='row'][.//div[@role='cell' and normalize-space()='"
						+ user_name + "']]"))).size() > 0;

		if (userPresent) {
			System.out.println("PASS: User is present");
		} else {
			System.out.println("FAIL: User is not present");
		}

		// Logout
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//p[contains(@class,'oxd-userdropdown-name')]/ancestor::li[contains(@class,'oxd-userdropdown')]/descendant::span[contains(@class,'oxd-userdropdown-tab')]")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[text()='Logout']"))).click();

		// Closing browser
		driver.quit();

		w.close();
		f1.close();
		f.close();
		System.out.println("Test execution completed.");
	}
}