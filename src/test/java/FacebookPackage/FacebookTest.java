package FacebookPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookTest {
	
	WebDriver driver;
	String url = "https://www.facebook.com/";
	@BeforeTest
	public void openBrowser()
	
	{
		System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\chromedriver.exe");
		
		    driver = new ChromeDriver();
			driver.get(url);	
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			
	}
	
	
	@Test
	
	public void login() throws InterruptedException
	{
		
		WebElement username= driver.findElement(By.xpath("//input[@id='email']"));
		WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
		WebElement Loginbutton= driver.findElement(By.xpath("//input[@type='submit']"));
		
		
		username.sendKeys("Shrvstvshobhana072@yahoo.co.in");
		password.sendKeys("Anipriya@9");
		Thread.sleep(3000);
		Loginbutton.click();
		Thread.sleep(3000);
		
WebElement notify=driver.findElement(By.xpath("//div[@class='n7fi1qx3 hv4rvrfc b3onmgus poy2od1o kr520xx4 ehxjyohh']/div/div[4]/span/div"));
		
notify.click();

Thread.sleep(5000);

/*WebElement notifyClick= driver.findElement(By.xpath("//a[@href='https://www.facebook.com/login_alerts/start/?fbid=2950846491636724&s=j&notif_id=1590429187364236&notif_t=login_alerts_new_device&ref=notif']")); 
notifyClick.click();
Thread.sleep(9000); */

driver.findElement(By.xpath("//div[@aria-label='Notifications']/div/div[4]")).click();
Thread.sleep(9000);	}
	

	@AfterTest
	
	public void tearDown() {driver.close();}
	
	
}
