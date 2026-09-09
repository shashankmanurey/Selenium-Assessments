//Day 1 TC1 
package Assessment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class testcase1_SauceDemo {
public static void main(String[] args) throws InterruptedException, IOException { 
	//create a  driver object
	WebDriver driver= new ChromeDriver();
	//maximize the window
	driver.manage().window().maximize();
	//Use implicit wait 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	//navigate to the webpage  and enter the  login and password 
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	Thread.sleep(2000);
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(2000);
	
	// need to perform 2 takes scroll and take ScreenShot
	
	// Create and type cast obj for javascriptexecutor
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	//scroll to bottom of the page 
	js.executeScript("window.scrollTo(0,500)");
	
	//Create an type cast obj for TakeScreenshot Interface
	TakesScreenshot tks= (TakesScreenshot)driver;
	
		
	Thread.sleep(2000);
	//take Screenshot and store it in a FILE .png or .jpeg
	File scr=tks.getScreenshotAs(OutputType.FILE);
	File dest= new File("./ScreenShot/Products-page.jpeg");
	FileHandler.copy(scr, dest);
	
}
}