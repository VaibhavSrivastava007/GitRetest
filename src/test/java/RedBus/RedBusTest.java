package RedBus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBusTest {

	String url="https://www.redbus.in/";
	WebDriver driver;
@BeforeTest
public void openBrowser() throws InterruptedException
{
		
		System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\chromedriver.exe");
		
	 driver = new ChromeDriver();
		driver.get(url);	
	
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}



@Test
public void searchBus() throws InterruptedException
{

WebElement source=	driver.findElement(By.cssSelector("input[id='src']"));

WebElement destination=	driver.findElement(By.cssSelector("input[id='dest']"));

WebElement startdate=driver.findElement(By.xpath("//label[text()='Onward Date']"));


//1st --

source.sendKeys("Pune" );
Thread.sleep(2000);
source.sendKeys(Keys.ENTER);
Thread.sleep(2000);
destination.sendKeys("Mumbai");
Thread.sleep(2000);
destination.sendKeys(Keys.ENTER);


startdate.click();

driver.findElement(By.xpath("//div[@class='rb-calendar']/table/tbody/tr[7]/td[7]")).click();

Thread.sleep(2000);


WebElement searchButton=driver.findElement(By.id("search_btn"));   //cssSelector("button[id='search_btn']"

searchButton.click();
System.out.println("search clicked");
Thread.sleep(3000);


WebElement modifyButton=driver.findElement(By.xpath("//div[@class='fixer']/div/div/div[2]"));    //"//div[@class='fixer']/div/div/div[2]"
modifyButton.click();

Thread.sleep(5000);

driver.findElement(By.id("onward_cal")).click();



WebElement target=driver.findElement(By.cssSelector("li.rb-next.active"));
/*Actions a = new Actions(driver);
a.moveToElement(target).click().build().perform(); */

target.click();

Thread.sleep(3000);


//((JavascriptExecutor)driver).executeScript("return document.getElementById(\"rb-next-middle\").click();" );

//WebElement dateNextButton=driver.findElement(By.cssSelector("li[id='rb-next-middle']"));
//dateNextButton.click();

WebElement changedDate=driver.findElement(By.xpath("//div[@id='rb-calmiddle']/ul[2]/li[16]"));
changedDate.click();

driver.findElement(By.xpath("//button[text()='SEARCH']")).click();  //search button again bc


String errorMessage=driver.findElement(By.xpath("//div[@class='error-view']/h3")).getText();
System.out.println("Print Error Message:" + errorMessage);

}


@AfterTest
public void tearDown() throws InterruptedException
{
	Thread.sleep(9000);
driver.close();
}









}



