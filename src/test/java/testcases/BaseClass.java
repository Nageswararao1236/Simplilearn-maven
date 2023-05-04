package testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest Test;
	Fillo fillo;
	Connection connection;

	@BeforeTest
	public void ReportSetUp() throws FilloException {
		report = new ExtentReports("ExtentReport.html");
		fillo = new Fillo();
		connection = fillo.getConnection("DataSheet.xlsx");
			
	}

	@BeforeMethod
	public void setup(Method method) {
		WebDriverManager.chromedriver().setup();

		Test = report.startTest(method.getName());
		Test.log(LogStatus.INFO, "Test should be started","Test case started successfully");
		this.driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	}

	@AfterMethod
	public void Teardown() {
		report.endTest(Test);
		driver.quit();
	}

	@AfterTest
	public void ReportClean() {
		report.flush();
		report.close();
	}
}
