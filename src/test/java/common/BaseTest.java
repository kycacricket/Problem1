package common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest implements AutoConstant{

    public WebDriver driver;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    @BeforeSuite
    public void init()
    {
        extentReports = new ExtentReports(reportPath);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method methodName)
    {
        extentTest = extentReports.startTest(methodName.getName());
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://demo.automationtesting.in/Windows.html");

    }

    @AfterMethod
    public void postCondition(ITestResult result)
    {
        int statusCode = result.getStatus();
        if(statusCode==1)
        {
            extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture("./screenshots/"+result.getTestName()+".jpeg"));
        }
        extentReports.endTest(extentTest);
        driver.quit();
    }

    @AfterSuite
    public void end()
    {
        extentReports.flush();
    }
}
