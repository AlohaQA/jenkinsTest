package testPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class jenkinsTest {
	
public static WebDriver driver;
	
	
	@Test
	public void myTest1() {		
		
		System.setProperty("webdriver.chrome.driver", "E:/My Automation/Drivers/ChromeDriver/chromedriver_win32/chromedriver.exe");	
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Google");
		
		System.out.println("Test Case passed.");
				
	}
	
	@Test 
	public void myTest2() {
		
		System.setProperty("webdriver.chrome.driver", "E:/My Automation/Drivers/ChromeDriver/chromedriver_win32/chromedriver.exe");	
		driver = new ChromeDriver();
		
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='brand greenLogo']"));
		
		Assert.assertTrue(ele.isDisplayed(), "Test case is passed");
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
				
		driver.close();
		
	}

}
