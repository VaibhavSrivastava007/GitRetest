package RevisionPackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RevisionSwitchtabs {
	String url ="https://www.rahulshettyacademy.com/AutomationPractice/";
	WebDriver driver;
	
	@BeforeTest
	
	public void openBrowser()
	{
		
		 System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\chromedriver.exe");
		   
		    driver =new ChromeDriver();
		   	driver.get(url);
		   	
		   	driver.manage().window().maximize();
		   	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}



@Test
public void pageLinksCOunt() throws InterruptedException
{
	
System.out.println("pageLinks:"+driver.findElements(By.tagName("a")).size());

WebElement footerdriver=driver.findElement(By.cssSelector("div[id='gf-BIG']"));
System.out.println("footer links:"+footerdriver.findElements(By.tagName("a")).size());

WebElement coloumndriver=driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
System.out.println("coloumnOne LInks :"+coloumndriver.findElements(By.tagName("a")).size());

for(int i =0; i<coloumndriver.findElements(By.tagName("a")).size();i++)
	
{
	
	coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL , Keys.ENTER);
	
	Thread.sleep(5000);
	
}

Set<String>win= driver.getWindowHandles();
Iterator<String> it=win.iterator();
	while(it.hasNext())
	{
		
		driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());
		
	}
	
	
	

}





@AfterTest
public void tearDown() throws InterruptedException
{    Thread.sleep(5000);
	driver.close();
	
}


}
