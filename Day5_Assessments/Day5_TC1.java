package com.selenium;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day5_TC1 {
    public static void main(String[] args) throws Exception{
        FileInputStream fil =new FileInputStream("src/main/Resources/DDT/data.properties");
		Properties p = new Properties();
		p.load(fil);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String email = p.getProperty("email");
		String pass = p.getProperty("pass");
		
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(email);
		System.out.println(pass);
		
		
		WebDriver d = null;
		if(BROWSER.equals("chrome"))
        {
            d = new ChromeDriver();
        }
        if(BROWSER.equals("edge"))
        {
            d = new EdgeDriver();
        }
        if(BROWSER.equals("firefox"))
        {
            d = new FirefoxDriver();
        }
		
	    d.manage().window().maximize();
	    d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get(URL);
		
		d.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
		d.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		d.findElement(By.xpath("//input[@id='Password']")).sendKeys(pass);
		d.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        
    }
}
