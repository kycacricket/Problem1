package common;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.Set;

public class WindowsUtils
{
    public static void switchToWindow(WebDriver driver, String window)
    {
       Set<String> allWh=  driver.getWindowHandles();
        Reporter.log("Total number of windows:"+allWh.size(),true);
        for (String wh:allWh)
        {
            Reporter.log(wh,true);
            String title = driver.getTitle();
            Reporter.log("Title is:"+title,true);
            if(title.equals(window))
            {
                driver.switchTo().window(wh);
                Reporter.log("Title is:"+title,true);

                break;
            }
        }
    }


}
