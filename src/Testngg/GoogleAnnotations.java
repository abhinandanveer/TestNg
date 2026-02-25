package Testngg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleAnnotations {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("1. Before Suite - Setup environment");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("2. Before Test - Browser settings");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("3. Before Class - Launch browser");

        // No WebDriverManager
        // No System.setProperty
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("4. Before Method - Open Google");
        driver.get("https://www.google.com");
    }

    @Test
    public void searchTest() throws InterruptedException {
        System.out.println("5. Test - Searching");

        driver.findElement(By.name("q")).sendKeys("TestNG Selenium");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("6. After Method - Clear cookies");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("7. After Class - Close browser");
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("8. After Test - Finished");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("9. After Suite - Report generated");
    }
}
