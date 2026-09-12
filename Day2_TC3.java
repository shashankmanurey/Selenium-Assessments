package com.selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Day2_TC3 {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demowebshop.tricentis.com/");
		
		WebElement laptop = driver.findElement(By.linkText("14.1-inch Laptop"));
		WebElement addcart = driver.findElement(By.xpath("//input[@value='Add to cart']"));
		System.out.println(addcart.getSize());
		System.out.println(addcart.getSize().getHeight());
		System.out.println(addcart.getSize().getWidth());
		
		laptop.click();
		driver.findElement(By.id("add-to-cart-button-31")).click();
		
		WebElement Shoppingcart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		Shoppingcart.click();
		
		WebElement removeCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		if (removeCheckBox.isSelected()) {
		    System.out.println("Remove checkbox is selected.");
		} else {
		    System.out.println("Remove checkbox is NOT selected.");
		}
		System.out.println(removeCheckBox.getRect());
		System.out.println(removeCheckBox.getRect().getHeight());
		System.out.println(removeCheckBox.getRect().getWidth());
		System.out.println(removeCheckBox.getRect().getX());
		System.out.println(removeCheckBox.getRect().getY());
		WebElement applyCoupon = driver.findElement(By.xpath("//input[@value='Apply coupon']"));
		applyCoupon.click();
		WebElement message = driver.findElement(By.className("message"));
		if(message.isDisplayed()) {
			System.out.println("Message displayed  Apply Coupon");
		}else {
			System.out.println("Message not displayed  Apply Coupon");
		}
		Thread.sleep(2000);
		TakesScreenshot tks=(TakesScreenshot) driver;
		File src=tks.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Srn/Loptop.png");
		FileHandler.copy(src, dest); 
	}

}
