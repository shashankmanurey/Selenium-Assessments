package com.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zomato {
    public static void main(String[] args) throws Exception{
        // Maximize the browser window
        WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		 // Set an implicit wait to allow elements time to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Navigate to the Date Picker application
		driver.get("https://www.bigbasket.com/pb/boss/");
		
		driver.findElement(By.xpath("(//input[@placeholder=\"Search for Products...\"])[2]")).sendKeys("Apple",Keys.ENTER);
		Thread.sleep(4000);
		WebElement ref = driver.findElement(By.xpath("//h3[contains(.,\"Shimla\")]/ancestor::div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 bFjDCO']/descendant::button[text()='Add']"));
		Thread.sleep(5000);
		
		ref.click();
		if(driver.findElement(By.xpath("//p[text()=\"An item has been added to your basket successfully\"]")).getText().contains("An item has been added to your basket successfully")) 
        {
			System.out.println("Product is added to cart");
            
		}
	}
}

