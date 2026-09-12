<<<<<<< HEAD
package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day3_TC2 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
        driver.findElement(By.xpath("//input")).click();
        driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--next')]")).click();
        driver.findElement(By.xpath("//div[text()='10']")).click();
        Thread.sleep(2000);
        if(driver.getCurrentUrl().contains("date")) {
       	 System.out.println("DateField-result page is displayed");
        }else {
       	 System.out.println("DateField-result page is not displayed");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
=======
package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day3_TC2 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
        driver.findElement(By.xpath("//input")).click();
        driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--next')]")).click();
        driver.findElement(By.xpath("//div[text()='10']")).click();
        Thread.sleep(2000);
        if(driver.getCurrentUrl().contains("date")) {
       	 System.out.println("DateField-result page is displayed");
        }else {
       	 System.out.println("DateField-result page is not displayed");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
>>>>>>> d41f0e2ef0bb6a0e0a359b0120ef8ca4b8028748
