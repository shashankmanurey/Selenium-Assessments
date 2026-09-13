package com.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Day6_TC1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Loading the common configuration details from the properties file
		FileInputStream propertyFile = new FileInputStream("src/main/Resources/DDT/data1.properties");
		Properties propertiesData = new Properties();
		propertiesData.load(propertyFile);
		String browserName = propertiesData.getProperty("browser");
		String applicationUrl = propertiesData.getProperty("url");
		String loginUsername = propertiesData.getProperty("username");
		String loginPassword = propertiesData.getProperty("pass");
		
		//Getting the employee and login details from the Excel sheet
		FileInputStream excelFile = new FileInputStream("src/main/Resources/DDT/Data1.xlsx");
		Workbook workbookData = WorkbookFactory.create(excelFile);
		
		String employeeFirstName = workbookData.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String employeeLastName = workbookData.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String pimUsername = workbookData.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String employeeName = workbookData.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String pimPassword = workbookData.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		
		//Disabling the password manager warning popup
		ChromeOptions chromeSettings = new ChromeOptions();
		Map<String, Object> chromePreferences = new HashMap<>();
		chromePreferences.put("profile.password_manager_leak_detection", false);
		chromeSettings.setExperimentalOption("prefs", chromePreferences);
		
		WebDriver webDriver = null;
		if(browserName.equals("chrome")) {
			webDriver = new ChromeDriver();
		}else if(browserName.equals("edge")) {
			webDriver = new EdgeDriver();
		}else if(browserName.equals("firefox")) {
			webDriver = new FirefoxDriver();
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		webDriver.get(applicationUrl);
		Thread.sleep(2000);
		webDriver.findElement(By.cssSelector("[name='username']")).sendKeys(loginUsername);
		webDriver.findElement(By.cssSelector("[name='password']")).sendKeys(loginPassword);
		Thread.sleep(2000);
		webDriver.findElement(By.cssSelector("[type='submit']")).submit();
		
		//Opening PIM, selecting Add and providing employee information
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']/descendant::a[@href='/web/index.php/pim/viewPimModule']")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.cssSelector("[class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		Thread.sleep(8000);
		webDriver.findElement(By.cssSelector("[name='firstName']")).sendKeys(employeeFirstName);
		webDriver.findElement(By.cssSelector("[name='lastName']")).sendKeys(employeeLastName);
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::span")).click();
		
		//Entering the login credentials and saving the employee record
		Thread.sleep(3000);
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(pimPassword);
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(pimPassword);
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("((//div[@class='oxd-form-row'])[2]/descendant::div[@class='oxd-input-group oxd-input-field-bottom-space']/descendant::input)[1]")).sendKeys(pimUsername);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//button[text()=' Save ']")).submit();
		
		//Opening Admin and filtering the created user using role, employee and status
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']/descendant::a[@href='/web/index.php/admin/viewAdminModule']")).click();
		Thread.sleep(4000);
		webDriver.findElement(By.xpath("(//div[@class='oxd-table-filter-area']/descendant::div[@class='oxd-grid-item oxd-grid-item--gutters'])[1]/descendant::input")).sendKeys(pimUsername);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("(//div[@class='oxd-select-wrapper']/descendant::i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])")).click();
		WebElement userRole = webDriver.findElement(By.xpath("//span[text()='ESS']"));
		Actions roleAction = new Actions(webDriver);
		Thread.sleep(2000);
		roleAction.click(userRole).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys(employeeName);
		Thread.sleep(2000);
		WebElement employeeSuggestion = webDriver.findElement(By.xpath("//div[@role='listbox']"));
		Actions employeeAction = new Actions(webDriver);
		employeeAction.moveToElement(employeeSuggestion, 20, 10).click().perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("(//div[@class='oxd-select-wrapper']/descendant::i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")).click();
		WebElement accountStatus = webDriver.findElement(By.xpath("//span[text()='Enabled']"));
		Actions statusAction = new Actions(webDriver);
		Thread.sleep(2000);
		statusAction.click(accountStatus).perform();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("//button[text()=' Search ']")).submit();
		
		//Checking whether the newly created user record is available
		Thread.sleep(2000);
		WebElement foundRecord = webDriver.findElement(By.xpath("//span[text()='(1) Record Found']"));
		if(foundRecord.isDisplayed()) {
			System.out.println("Record Found Successfully");
		}else {
			System.out.println("Record Not found");
		}
		
		//Printing the details displayed for the matching record
		Thread.sleep(1000);
		List<WebElement> recordDetailsList = webDriver.findElements(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border'])[2]/descendant::div[@role='cell']/descendant::div[text()]"));
		System.out.println("-------------Record Details are--------------");
		for(WebElement recordElement:recordDetailsList) {
				System.out.println(recordElement.getText());
		}
	}
}
