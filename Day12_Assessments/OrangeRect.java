package selenium.PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeRect {
    WebDriver d;
    public OrangeRect(WebDriver d)
    {
        this.d = d;
        PageFactory.initElements(d, this);
    }

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitment;
    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vac;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private  WebElement add;

    public void clickRecruitment()
    {
        recruitment.click();
    }
    public void clickvac()
    {
        vac.click();
    }
    public void clickadd()
    {
        add.click();
    }
}
