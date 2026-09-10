package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTextFields {
    public static void main(String[] args) throws Exception {

        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.facebook.com/");

        List<WebElement> textFields = d.findElements(By.tagName("input"));

        System.out.println("Text fields = " + textFields.size());

        for (WebElement field : textFields) {

            if (field.getAttribute("type").equals("text")) {
                field.click();
                field.sendKeys("shashank");
            }
        }
    }
}
