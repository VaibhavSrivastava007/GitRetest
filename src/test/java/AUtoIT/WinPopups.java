package AUtoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WinPopups {
	
	
	
	String url = "http://admin:admin@the-internet.herokuapp.com/";
	WebDriver driver;
	
	@BeforeTest

	public void openBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		driver = new ChromeDriver();

	}
	
	
	@Test
	public void authenticate() throws InterruptedException 
	{
		driver.get(url);
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Basic Auth")).click();
		Thread.sleep(3000);
	//System.out.println(	driver.findElement(By.xpath("//p[text()='Congratulations! You must have the proper credentials.']")).getText());
		String successText=driver.findElement(By.tagName("p")).getText();
		
		Assert.assertFalse(driver.findElement(By.tagName("p")).isDisplayed(), "failed");
		
		Actions a = new Actions(driver);
        a.doubleClick(driver.findElement(By.tagName("p"))).build().perform();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		
		
		
	}
	







}