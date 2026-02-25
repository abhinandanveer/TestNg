package TestNg;



import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class DataDrivenTesting {
	
		@Test (dataProvider="loginData")
		public void loginTest(String username, String password) throws InterruptedException
		{
			WebDriver driver= new ChromeDriver();
			driver.get("https://practicetestautomation.com/practice-test-login");
			
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			System.out.println("User run : " + username);
			
			System.out.println();
			
			driver.findElement(By.id("submit")).click();
			Thread.sleep(2000);
			
			driver.quit();
		}
			@DataProvider(name="loginData")
			public Object[][] getData()
			{
				return new Object[][]
			{
					{"user1", "pass1"},	
					{" Password123", "student"},	
					{"student", "Password123"}	
	
			};	
		}		
	}
