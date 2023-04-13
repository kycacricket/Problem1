package pages.DemoTest;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPage extends BasePage
{

    public SeleniumPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


}
