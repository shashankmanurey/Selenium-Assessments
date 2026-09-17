package selenium.advance.KeywordsDemoTwo;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordsImpl {
    WebDriver d;
    public void openbrowser()
    {
        d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void openurl()
    {
        d.get("https://www.saucedemo.com/");
    }
    public void credsenter()
    {
        d.findElement(By.id("user-name")).sendKeys("standard_user");
        d.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    public void loginclick()
    {
        d.findElement(By.id("login-button")).click();
    }
    public void close() throws Exception
    {
        Thread.sleep(3000);
        d.quit();
    }
}
