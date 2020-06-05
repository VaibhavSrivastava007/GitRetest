



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ADdition {

	String url = "https://www.rahulshettyacademy.com/seleniumPractise/#/offers";
	WebDriver driver;
	XSSFWorkbook w;
	XSSFSheet sheettwo;
	
	@BeforeTest

	public void openBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		FileInputStream f =new FileInputStream("C:\\Work\\SeleniumExcel.xlsx");
		 w= new XSSFWorkbook(f);
		
		 sheettwo=	w.getSheet("discount");
	
		
	}
	
	
	@Test
	public void discountPriceTotal() throws IOException
	{
		WebElement coloumns=driver.findElement(By.xpath("//table/thead/tr/th[4]"));
			
	System.out.println(coloumns.getText());
		
	String headertext=coloumns.getText();
	sheettwo.createRow(0).createCell(0).setCellValue(headertext);
	
	List<WebElement> priceList=driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
		//System.out.println(priceList.size());	
	
		int sum=0;
		int expected=356;
		
		
		for(int i=0;i<priceList.size();i++)
		{
			
			System.out.println(priceList.get(i).getText());
			
			String text =priceList.get(i).getText();
			int textINT=Integer.parseInt(text);
			
			sum=sum+textINT;
			
			sheettwo.createRow(i+1).createCell(0).setCellValue(text);
		//	sheettwo.getRow(0).createCell(i+1).setCellValue(text);
			
		}
		
		System.out.println("TotalSUm:" + sum);
		
		
		int lastRow=sheettwo.getLastRowNum();
		sheettwo.createRow(lastRow+1).createCell(0).setCellValue(sum);
		
	/*	int lastcol=sheettwo.getRow(0).getLastCellNum();
		sheettwo.getRow(0).createCell(lastcol).setCellValue(sum);*/
		
		Assert.assertEquals(sum,expected );
	
	FileOutputStream fi= new FileOutputStream("C:\\Work\\SeleniumExcel.xlsx");
	w.write(fi);
	
	}
	
	

	
	@AfterTest
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.close();

	}
	
	
	
}
