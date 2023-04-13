package pages.DemoTest;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesAndWindowPage extends BasePage
{
    @FindBy(xpath = "//div[@id='Tabbed']/a")
    private WebElement clickButton;

    @FindBy(xpath = "//a[text()='Open New Seperate Windows']")
    private WebElement openNewSeperateWindowsTab;

    public FramesAndWindowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnClickButton()
    {
        clickButton.click();
    }

    public void clickOnopenNewSeperateWindowsTab()
    {
        openNewSeperateWindowsTab.click();
    }
}
