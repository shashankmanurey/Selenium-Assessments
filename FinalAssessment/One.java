package selenium.advance.FinalAssessment.Assessment1;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class One {
    public static void main(String[] args) throws Exception {
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        d.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");

        JavascriptExecutor j = (JavascriptExecutor) d;

        //clicking on disabled elements
        WebElement w = d.findElement(By.xpath("(//input[@class='w-0 h-0 opacity-0 absolute'])[1]"));
        j.executeScript("arguments[0].click()",w);

        WebElement w1 = d.findElement(By.xpath("(//input[@class='w-0 h-0 opacity-0 absolute'])[2]"));
        j.executeScript("arguments[0].click()",w1);

        WebElement w2 = d.findElement(By.xpath("(//input[@class='w-0 h-0 opacity-0 absolute'])[3]"));
        j.executeScript("arguments[0].click()",w2);

        WebElement w3 = d.findElement(By.xpath("(//input[@class='w-0 h-0 opacity-0 absolute'])[4]"));
        j.executeScript("arguments[0].click()",w3);

        Thread.sleep(2000);
        d.findElement(By.xpath("//button[@id='togglers']")).click();

        //verification
        WebElement wb = d.findElement(By.xpath("//p[text()='ORDER PLACED']"));
        String actual = wb.getText();
        Assert.assertEquals(actual, "ORDER PLACED");
        boolean result = actual.equals("ORDER PLACED");
        System.out.println(result + " - " + " Order was placed");

    }
}
