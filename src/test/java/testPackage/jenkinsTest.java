package testPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class jenkinsTest {

	public static WebDriver driver;

	ExtentReports extent;

	@BeforeTest
	public void config() {

		SimpleDateFormat formater = new SimpleDateFormat("MM_dd_yyyy");
		String path = "./Report/Jenkins_Automation_Test_Report_" + formater.format(new Date()) + ".html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Jenkin end to end test results.");

		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Automation QA : ", "Charudatt Batte");

	}

	@Test
	public void myTest1() {

		extent.createTest("Verify the first test case is working or not");

		System.setProperty("webdriver.chrome.driver",
				"E:/My Automation/Drivers/ChromeDriver/chromedriver_win32/chromedriver.exe");
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

		extent.createTest("Verify the second test case is working or not");

		System.setProperty("webdriver.chrome.driver",
				"E:/My Automation/Drivers/ChromeDriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");

		WebElement ele = driver.findElement(By.xpath("//div[@class='brand greenLogo']"));

		Assert.assertTrue(ele.isDisplayed(), "Test case is passed");

	}

	@Test
	public void myTest3() {

		extent.createTest("Verify the third test case is working or not");

		System.setProperty("webdriver.chrome.driver",
				"E:/My Automation/Drivers/ChromeDriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		String title = driver.getTitle();

		Assert.assertTrue(title.equalsIgnoreCase("ProtoCommerce"), "Third test also passed.");

	}

	@AfterMethod
	public void tearDown() {

		driver.close();

	}

	@AfterTest
	public void afterSuite() {
		extent.flush();
	}

}
