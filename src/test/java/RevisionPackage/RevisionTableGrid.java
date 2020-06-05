package RevisionPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RevisionTableGrid {

	String url ="https://www.cricbuzz.com/live-cricket-scorecard/22773/nz-vs-ind-1st-t20i-india-tour-of-new-zealand-2020";
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
	public void getData()
	{   int sum=0;

	//	int rowcount =table.findElements(By.xpath("//div[@id='innings_1']/div/div[3]/div[3]")).size();
		//int rowcount=driver.findElements(By.xpath("//div[@id='innings_1']/div[1]/div")).size();
				//xpath --$x("//div[@id='innings_1']/div/div[3]/div[3]");  try this
		
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		List<WebElement> runsList=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"));
		
		int rowcount = runsList.size();
			
		System.out.println(rowcount);
		
		
		for(int i=0;i<rowcount-2;i++)
		{
		//System.out.println((runsList).get(i).getText());
			
		String Runstext =runsList.get(i).getText();
		
		int RunsInt = Integer.parseInt(Runstext);
		sum=sum+RunsInt;
		
		}System.out.println("Runs :"+ sum);
		
	WebElement extrarun=	table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]"));
	String extrarunText= extrarun.getText();
	int ExtrasSum=sum+Integer.parseInt(extrarunText);
	System.out.println("ExtrasSum :" + ExtrasSum);
	
//	System.out.println(extrarun.getText());
		
	WebElement totalRuns=	table.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]"));
	String ActualTotalText=totalRuns.getText();
	int ActualTotalSum=Integer.parseInt(ActualTotalText);
	System.out.println("ActualTotalSum :"+ ActualTotalSum);
	
	//System.out.println(totalRuns.getText());
	
	
	if(ExtrasSum==ActualTotalSum)
	{
		System.out.println("total runs matched");
		
	}
		
	else
	{
		System.out.println("total match failed");
	}
	
	
	}
	
	
	
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{    Thread.sleep(5000);
		driver.close();
		
	}
	
	
}
