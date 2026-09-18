package selenium.advance.BaseClassUtility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass1 {

    protected WebDriver driver = null;

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

        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void Bm() throws Exception {

        FileInputStream fis = new FileInputStream(
                "src/main/resources/DDT/commondata.properties");

        Properties p = new Properties();

        p.load(fis);

        String BROWSER = p.getProperty("browser");

        String URL = p.getProperty("url");

        if (BROWSER.equals("chrome")) {
        	ChromeOptions options = new ChromeOptions();

            options.addArguments("--incognito");

            driver = new ChromeDriver(options);
        }

        if (BROWSER.equals("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(URL);

        fis.close();
    }

    @AfterMethod
    public void Am() {
        System.out.println("logout method");
    }
}