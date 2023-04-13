package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {
 public WebDriver driver;

 public BasePage(WebDriver driver)
 {
     this.driver=driver;
 }

 public void verifyTitle(String title)
 {
     WebDriverWait wait = new WebDriverWait(driver, 20);
     try
     {
         wait.until(ExpectedConditions.titleIs(title));
         Reporter.log(title+ "page is displayed",true);
     }
     catch (Exception e)
     {
         Assert.fail("Actual title:"+driver.getTitle());
     }
 }
}
