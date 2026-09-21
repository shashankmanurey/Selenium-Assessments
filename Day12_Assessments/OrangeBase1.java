package selenium.advance.BaseClassUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class OrangeBase1 {
    protected WebDriver d;
    @BeforeSuite
    public void Bs() {
        System.out.println("open DataBase connectivity");
    }

    @AfterSuite
    public void As() {
        System.out.println("close Database connectivity");
    }

    @BeforeTest
    public void Bt() {
        System.out.println("pre-conditions");
    }

    @AfterTest
    public void At() {
        System.out.println("post-conditions");
    }

    @BeforeClass
    public void Bc() {
        System.out.println("Launch the browser");
    }

    @AfterClass
    public void Ac() {
        System.out.println("close the browser");
    }

    @BeforeMethod 
    public void Bm() throws Exception
    {
        FileInputStream f = new FileInputStream("src/main/resources/DDT/data1.properties");
        Properties p = new Properties();
        p.load(f);
        f.close();

        String browser = p.getProperty("browser");
        String url = p.getProperty("url");

        if(browser == null || url == null)
        {
            throw new RuntimeErrorException(null, "Browser or Url is invalid");
        }

        else if(browser.equalsIgnoreCase("chrome"))
        {
            d = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            d = new EdgeDriver();
        }
        else 
        {
            throw new IllegalArgumentException("Unsupported Browser: " + browser);
        }
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        d.get(url);
    }
    @AfterMethod 
        public void Am() throws Exception
        {
            System.out.println("Quit browser");
            if(d!=null)
            {
                Thread.sleep(3000);
                d.quit();
                d = null;
            }
        
        }
}
