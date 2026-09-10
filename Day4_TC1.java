package com.selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zomato {
    public static void main(String[] args) throws Exception{
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        d.get("https://www.zomato.com/bangalore/delivery");
        d.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(2000);
        WebElement e =  d.findElement(By.id("auth-login-ui"));
        d.switchTo().frame(e);
        d.findElement(By.xpath("//input[@type='number']")).sendKeys("9538103183");
        d.switchTo().defaultContent();
        String w = d.findElement(By.xpath("//div[text()='Delivery']")).getText();
        System.out.println(w);
        Thread.sleep(3000);
        d.quit();
    }
}
