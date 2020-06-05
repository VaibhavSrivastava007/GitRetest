package ExtentReports;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsTest {

	WebDriver driver;
	String url="https://www.google.co.in/";
	String path1=System.getProperty("user.dir")+"\\Screenshot\\img1.png";
	String path2=System.getProperty("user.dir")+"\\Screenshot\\img2.png";
	ExtentSparkReporter spark;
    ExtentReports report;
    ExtentTest test;
	 
	@BeforeTest
	public void config() 
	{
		System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(url);	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		//reporter
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\Reports\\thirdtitle.html");
        spark.config().setDocumentTitle("SparkReportTitle");
        spark.config().setReportName("SparkReportname");        
		
        report = new ExtentReports();
        
        report.attachReporter(spark);
        report.setSystemInfo("testsysRepo", "JackRyan");
	}
	
	
	
	
	@Test
	public void getTitleNegative() throws InterruptedException, IOException
	{
		 test = report.createTest("TitleTestOne");
		 
		String actual=driver.getTitle();
		String expected="GoogleVoogle";
		SoftAssert s=new SoftAssert();
		s.assertEquals(actual, expected);		
		test.log(Status.INFO, "Test browser title for negative scene")	;
		test.log(Status.FAIL, "log for fail statement");
		test.log(Status.FAIL, "throw check");
		test.fail("failed");
		
		File snap=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snap, new File(path1));
		
		 test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(path1).build());
		 test.addScreenCaptureFromPath(path1);
		s.assertAll();
		Thread.sleep(5000);	
	}
	
	@Test
	public void getTitlePositive() throws InterruptedException, IOException
	{  
		 test = report.createTest("TitleTestTwo");
		
		String actual=driver.getTitle();
		String expected=driver.getTitle();
		Assert.assertEquals(actual, expected);
		File snap=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snap, new File(path2));
		test.pass("passed", MediaEntityBuilder.createScreenCaptureFromPath(path2, "Passtitle").build());
		test.log(Status.INFO, "Test browser title for positive scene")	;
		Thread.sleep(5000);		
	}
	
	
	
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{Thread.sleep(3000);	
	
		report.flush();	
		driver.close();
		
	}
	
}
