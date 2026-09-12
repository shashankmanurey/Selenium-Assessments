package com.selenium;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day5_TC3 {

    public static void main(String[] args)
            throws IOException, ParseException,
            org.json.simple.parser.ParseException {

        FileReader fir = new FileReader("src/main/Resources/DDT/data.json");

        JSONParser jsonparser = new JSONParser();
        Object obj = jsonparser.parse(fir);

        JSONObject j = (JSONObject) obj;

        String b = j.get("browser").toString();
        String u = j.get("url").toString();
        String e = j.get("username").toString();
        String p = j.get("password").toString();

        System.out.println(b);
        System.out.println(u);
        System.out.println(e);
        System.out.println(p);

        WebDriver driver = null;

        if (b.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (b.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (b.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(30));

        driver.get(u);

        driver.findElement(By.id("email")).sendKeys(e);
        driver.findElement(By.id("password")).sendKeys(p);
        driver.findElement(
            By.xpath("//button[normalize-space()='Login']")
        ).click();
    }
}
