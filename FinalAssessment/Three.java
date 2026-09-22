package selenium.advance.FinalAssessment.Assessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Three {
    public static void main(String[] args) throws Exception {

        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        d.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=2");
        Actions a = new Actions(d);

        // Mobile Charger - Mobile Accessories
        WebElement mobileAccessories = d.findElement(By.xpath("//div[text()='Mobile Accessories']"));

        WebElement mobileCharger = d.findElement(By.xpath("//div[contains(text(),'Mobile Charger')]"));
        a.dragAndDrop(mobileCharger, mobileAccessories).perform();


        // Mobile Cover - Mobile Accessories
        WebElement mobileCover = d.findElement(By.xpath("//div[contains(text(),'Mobile Cover')]"));
        a.dragAndDrop(mobileCover, mobileAccessories).perform();


        // Laptop Charger - Laptop Accessories
        WebElement laptopAccessories = d.findElement(By.xpath("//div[text()='Laptop Accessories']"));

        WebElement laptopCharger = d.findElement(By.xpath("//div[contains(text(),'Laptop Charger')]"));
        a.dragAndDrop(laptopCharger, laptopAccessories).perform();


        // Laptop Cover - Laptop Accessories
        WebElement laptopCover = d.findElement(By.xpath("//div[contains(text(),'Laptop Cover')]"));
        a.dragAndDrop(laptopCover, laptopAccessories).perform();

        System.out.println("Drag and dropped");

        Thread.sleep(2000);
        d.quit();
    }
}
