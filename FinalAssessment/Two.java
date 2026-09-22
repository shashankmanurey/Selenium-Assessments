package selenium.advance.FinalAssessment.Assessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Two {

    public static void main(String[] args) throws Exception {

        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        d.get("https://demoapps.qspiders.com/ui/slider?sublist=0");

        WebElement slider = d.findElement(By.id("slide"));

        Actions actions = new Actions(d);

        actions.clickAndHold(slider).moveByOffset(100, 0).release().perform();

        Thread.sleep(2000);

        d.quit();
    }
}
