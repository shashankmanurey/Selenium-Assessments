package selenium.PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLogin {
    WebDriver d;
    public OrangeLogin(WebDriver d)
    {
        this.d = d;
        PageFactory.initElements(d, this);
    }

    @FindBy(name = "username")
    private WebElement un;
    @FindBy(name = "password")
    private WebElement pass;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement lgbt;
    @FindBy (xpath = "//h6[text()='Dashboard']")
	private WebElement dash;

    public void getun(String value)
    {
        un.sendKeys(value);
    }
    public void getPass(String value)
    {
        pass.sendKeys(value);
    }
    public void getLgbt()
    {
        lgbt.click();
    }
    public boolean verify()
    {
       return dash.isDisplayed();
    }

}
