package tests;

import common.BaseTest;
import common.WindowsUtils;
import org.testng.annotations.Test;
import pages.DemoTest.FramesAndWindowPage;

public class WindowTest extends BaseTest
{
    @Test
    public void testWindow() throws Exception {
        FramesAndWindowPage framesAndWindowPage = new FramesAndWindowPage(driver);
        framesAndWindowPage.verifyTitle("Frames & windows");
        String wh = driver.getWindowHandle();
        framesAndWindowPage.clickOnClickButton();
        Thread.sleep(5000);

        WindowsUtils.switchToWindow(driver, "Selenium");
        Thread.sleep(5000);
        framesAndWindowPage.verifyTitle("Selenium");
        driver.switchTo().window(wh);
        framesAndWindowPage.verifyTitle("Frames & windows");
        framesAndWindowPage.clickOnopenNewSeperateWindowsTab();
    }
}
