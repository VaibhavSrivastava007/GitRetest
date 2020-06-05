import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class dummy {
	ExtentHtmlReporter repo;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void dumy1()
	{
		repo=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\index.html");
		 extent = new ExtentReports();
	     extent.attachReporter(repo);
	     // creates a toggle for the given test, adds all log events under it    
	     test = extent.createTest("MyFirstTest", "Sample description");
	  // log(Status, details)
	     test.log(Status.INFO, "This step shows before test method");

	}
	
	
	@Test
	public void dumy2()
	{
		 // creates a toggle for the given test, adds all log events under it    
	    test = extent.createTest("dummy test case 1", "dummy description 1");
	 // log(Status, details)
	    test.log(Status.INFO, "This step shows dummy method");

	}
	
	
	
	@Test
	public void dumy3() throws IOException
	{
		 // creates a toggle for the given test, adds all log events under it    
	    test = extent.createTest("dummy test case 2", "dummy description 2");
	 // log with snapshot
	    test.fail("failed description", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Work\\screenshot.png").build());
	     

	}
	
	
	
	@AfterTest
	public void test2()
	{
		
		 // calling flush writes everything to the log file
        extent.flush();
        
	}
}
