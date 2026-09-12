<<<<<<< HEAD
package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Day3_TC1 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.easemytrip.com/");
        // Handle notification
        driver.findElement(By.className("srchBtnSe")).click();
        // Select One Way
        driver.findElement(By.className("cont-rdo")).click();
        Thread.sleep(2000);
        // From field
        driver.findElements(By.cssSelector(".inptBx.autoFlll")).get(0).click();
        driver.findElement(By.xpath("//p[text()=' Chhatrapati Shivaji International Airport ']")).click();
        Thread.sleep(2000);
        // To field
        driver.findElements(By.cssSelector(".inptBx.autoFlll")).get(1).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()=' Rajiv Gandhi International Airport ']")).click();
        Thread.sleep(2000);
        // Departure date
        driver.findElement(By.className("inptBx2")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='16']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".flTrv.inp-b5")).click();
        WebElement ele = driver.findElement(By.id("optadult"));
        ele.click();
        Select select = new Select(ele);
        select.selectByIndex(1);
        driver.findElement(By.id("trvMDone")).click();
        Thread.sleep(2000);
        WebElement ele2 = driver.findElement(By.id("optClass"));
        ele2.click();
        Select select2 = new Select(ele2);
        select2.selectByIndex(0);
        Thread.sleep(2000);
        WebElement ele3 = driver.findElement(By.id("btnSrch"));
        ele3.click();
        Thread.sleep(2000);
        if(driver.getCurrentUrl().contains("flight")) {
            System.out.println("flight-result page is displayed");
        }else {
            System.out.println("flight-result page is not displayed");
        }
        Thread.sleep(2000);
        driver.quit();
    }
=======
package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Day3_TC1 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.easemytrip.com/");
        // Handle notification
        driver.findElement(By.className("srchBtnSe")).click();
        // Select One Way
        driver.findElement(By.className("cont-rdo")).click();
        Thread.sleep(2000);
        // From field
        driver.findElements(By.cssSelector(".inptBx.autoFlll")).get(0).click();
        driver.findElement(By.xpath("//p[text()=' Chhatrapati Shivaji International Airport ']")).click();
        Thread.sleep(2000);
        // To field
        driver.findElements(By.cssSelector(".inptBx.autoFlll")).get(1).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()=' Rajiv Gandhi International Airport ']")).click();
        Thread.sleep(2000);
        // Departure date
        driver.findElement(By.className("inptBx2")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='16']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".flTrv.inp-b5")).click();
        WebElement ele = driver.findElement(By.id("optadult"));
        ele.click();
        Select select = new Select(ele);
        select.selectByIndex(1);
        driver.findElement(By.id("trvMDone")).click();
        Thread.sleep(2000);
        WebElement ele2 = driver.findElement(By.id("optClass"));
        ele2.click();
        Select select2 = new Select(ele2);
        select2.selectByIndex(0);
        Thread.sleep(2000);
        WebElement ele3 = driver.findElement(By.id("btnSrch"));
        ele3.click();
        Thread.sleep(2000);
        if(driver.getCurrentUrl().contains("flight")) {
            System.out.println("flight-result page is displayed");
        }else {
            System.out.println("flight-result page is not displayed");
        }
        Thread.sleep(2000);
        driver.quit();
    }
>>>>>>> d41f0e2ef0bb6a0e0a359b0120ef8ca4b8028748
}