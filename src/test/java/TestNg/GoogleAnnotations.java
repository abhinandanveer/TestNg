package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAnnotations {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("1. Before Suite - Setup report / environment");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("2. Before Test - Preparing browser settings");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("3. Before Class - Launching Browser");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("4. Before Method - Opening Google");
        driver.get("https://www.google.com");
    }

    @Test
    public void searchTest() throws InterruptedException {
        System.out.println("5. Test - Searching in Google");

        driver.findElement(By.name("q")).sendKeys("TestNG Selenium Tutorial");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("6. After Method - Clearing Cookies");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("7. After Class - Closing Browser");
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("8. After Test - Test Execution Finished");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("9. After Suite - Generate Final Report");
    }
}
