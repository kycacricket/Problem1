package tests;

import common.BaseTest;
import common.ReRun;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class DemoTest extends BaseTest
{
    @Test(retryAnalyzer = ReRun.class)
    public void test1()
    {
        String homeWindowHandle = driver.getWindowHandle();
        WebElement clickButton = driver.findElement(By.xpath("//div[@id='Tabbed']/a"));
        clickButton.click();
        Set<String> windowHandles = driver.getWindowHandles();
        String newWindowHandle = windowHandles.iterator().next();
        driver.switchTo().window(newWindowHandle);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "1");
        driver.switchTo().window(homeWindowHandle);
        WebElement separateWindows = driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']"));
        separateWindows.click();
        WebElement separateWindowsClick = driver.findElement(By.xpath("//div[@id='Seperate']/button"));
        separateWindowsClick.click();
        driver.switchTo().window(homeWindowHandle);
        WebElement separateMultipleWindowsClick = driver.findElement(By.xpath("//a[text()='Open Seperate Multiple Windows']"));
        separateMultipleWindowsClick.click();
        WebElement separateMultipleClick = driver.findElement(By.xpath("//div[@id='Multiple']/button"));
        separateMultipleClick.click();

        int numberOfTabs = driver.getWindowHandles().size();
        Assert.assertEquals(5,numberOfTabs);
    }
}
