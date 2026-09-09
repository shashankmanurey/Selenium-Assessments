package com.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day2_TC1 {
	public static void main(String[] args) {
		//create a  driver object
		WebDriver driver= new ChromeDriver();
		//maximize the window
		driver.manage().window().maximize();
		//Use implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//navigate to facebook application 
		driver.get("https://www.facebook.com/");
		//click on create account button 
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		
		//locate 1st name and Surname 
		WebElement fn = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
		WebElement sn = driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));
		
       // check same horizontal line?
		
		int f = fn.getLocation().getY();
		int s = sn.getLocation().getY();
		if(s==f) {
			System.out.println("Aligned in same line");
		}
		else
			System.out.println(" Not Aligned in same line");
	}

}