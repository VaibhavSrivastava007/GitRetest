package AUtoIT;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload {

	String url = "https://altoconvertpdftojpg.com/";
	String filePath = System.getProperty("user.dir");
	WebDriver driver;

	ChromeOptions c = new ChromeOptions();
	
	
	@BeforeTest

	public void openBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory",filePath );

		c.setExperimentalOption("prefs", chromePrefs);
		

		driver = new ChromeDriver(c);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
	}

	@Test
	public void autoItupload() throws InterruptedException, IOException {
		driver.get(url);
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\Vaibhav Srivastava\\Documents\\BasicAuto\\uploadfile.exe");

		Thread.sleep(7000);

		WebDriverWait w = new WebDriverWait(driver, 11);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));

		driver.findElement(By.cssSelector("button[class*='medium']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		driver.findElement(By.linkText("Download Now")).click();

		Thread.sleep(7000);
		
		File f = new File(filePath + "/converted.zip");

		if (f.exists()) {
			System.out.println("file found");
		} else {
			System.out.println("file not found");
		}

	}

}
