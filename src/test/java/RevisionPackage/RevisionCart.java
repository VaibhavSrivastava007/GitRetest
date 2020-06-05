package RevisionPackage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RevisionCart {

	
	String url ="https://www.rahulshettyacademy.com/seleniumPractise/#/";
	WebDriver driver;
	String[] itemsArray= {"Cucumber" , "Brocolli" ,"Beetroot"};
	
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
	public void addItems() throws InterruptedException
	{
	Thread.sleep(5000);
		List<WebElement> productslist=driver.findElements(By.cssSelector("h4.product-name"));
		
		int j =0;
		for(int i =0;i<productslist.size();i++)
		{
			
			String[] productName=productslist.get(i).getText().split("-");
			String productNameFormatted=productName[0].trim();
			
			System.out.println(productNameFormatted);
			
			
			List itemsAList =Arrays.asList(itemsArray);
			if(itemsAList.contains(productNameFormatted))
			{
				driver.findElements(By.cssSelector("div[class='product-action'] button:nth-child(1)")).get(i).click();
				j++;
				
				if (j==itemsArray.length)
				{
					break;
				}
				
			}
			
			
		}
		
		WebElement cartButton=driver.findElement(By.cssSelector("img[alt='Cart']"));
		cartButton.click();
		
		WebElement checkoutButton= driver.findElement(By.cssSelector("div[class='action-block'] button:nth-child(1)"));
		checkoutButton.click();
		Thread.sleep(5000);
		
		WebElement promoField = driver.findElement(By.cssSelector("input[class='promoCode']"));
		promoField.sendKeys("rahulshettyacademy");
		
		WebElement applyButton=driver.findElement(By.cssSelector("div[class='promoWrapper'] button:nth-child(2)"));
		applyButton.click();
		
		WebDriverWait w = new WebDriverWait(driver, 7);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String ActualcodeText=driver.findElement(By.cssSelector("span.promoInfo")).getText();
		String ExpectedcodeText="Code applied ..!";
		
		Assert.assertEquals(ActualcodeText, ExpectedcodeText);
		
		System.out.println("ActualcodeText :"+ActualcodeText);
		System.out.println("status passed");
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{    Thread.sleep(5000);
		driver.close();
		
	}
	
	
}