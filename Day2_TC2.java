package com.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_TC2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		WebElement loc = driver.findElement(By.xpath("//span[text()='Create new account']"));
		System.out.println(loc.getLocation());
		System.out.println(loc.getLocation().getX());
		System.out.println(loc.getLocation().getY());
		WebElement DOM = driver.findElement(By.id("_R_1h6kqsqppb6amH1_"));
		System.out.println(DOM.getDomAttribute("value"));
		System.out.println(DOM.getDomProperty("value"));
		DOM.sendKeys("test@gmail.com");
		System.out.println(DOM.getDomAttribute("value"));
		System.out.println(DOM.getDomProperty("value"));
		loc.click();
		WebElement size = driver.findElement(By.xpath("//span[text()='Submit']"));
		System.out.println(size.getSize());
		System.out.println(size.getSize().getHeight());
		System.out.println(size.getSize().getWidth());
		
		System.out.println(size.getCssValue("background-color"));
		System.out.println(size.getCssValue("font-size"));
		System.out.println(size.getCssValue("font-weight"));
	}

}
