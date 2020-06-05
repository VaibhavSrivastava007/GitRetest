import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Spicejet_DataDriven {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub


		 System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\chromedriver.exe");
	   
	   	WebDriver driver=new ChromeDriver();
		
		String url ="https://www.spicejet.com/";
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		
		FileInputStream f = new FileInputStream("C:\\Work\\SeleniumExcel.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(f);
		int SheetCOunt=book.getNumberOfSheets();
		System.out.println(SheetCOunt);
		XSSFSheet sheet3 =book.getSheet("TestExcel");
		
		int rowcount = sheet3.getLastRowNum()-sheet3.getFirstRowNum();
		System.out.println(rowcount);
		
		String from =sheet3.getRow(1).getCell(0).getStringCellValue();
		System.out.println(from);
		
		String to =sheet3.getRow(1).getCell(1).getStringCellValue();
		System.out.println(to);
	
		int adult =(int)sheet3.getRow(1).getCell(2).getNumericCellValue();
				
		System.out.println(adult);
		
		int child =(int)sheet3.getRow(1).getCell(3).getNumericCellValue();
		
		System.out.println(child);
	

		int infant =(int)sheet3.getRow(1).getCell(4).getNumericCellValue();
		System.out.println(infant);
		
		int currency =(int)sheet3.getRow(1).getCell(5).getNumericCellValue();
		System.out.println(currency);
	
	WebElement source=	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
	source.click();
	Thread.sleep(2000);
	
	source.sendKeys(from);
	Thread.sleep(5000); 
	
/*	Select s1 = new Select(source) ;	//dear, ye static dropdown nahi hai 
	//(html code mai parent tag 'Select' hota hai jab, sirf tabhi static dropdown hota hai), select class wala dropdown nahi hai ye..therefore error
	s1.selectByValue(from);*/
	                //phn krta hoo han hoo ha
									//ok, krna..
	
	WebElement dest=	driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
//	dest.click();
  
    dest.sendKeys(to);
    Thread.sleep(5000);
/*	Select s2 = new Select(dest);
	s2.selectByValue(to); */
	
	
	WebElement date =	driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/table/tbody/tr[5]/td[2]"));
	date.click();
	  Thread.sleep(5000);
	
	WebElement passenger =	driver.findElement(By.id("divpaxinfo"));
	passenger.click();
	Thread.sleep(1000);
	
	
	WebElement adults =	driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
	//adults.click();
	String adultchange =Integer.toString(adult); 
	Select s3 = new Select(adults);
	s3.selectByValue(adultchange);
	Thread.sleep(1000);
	
	WebElement children =	driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
	String childchange =Integer.toString(child); 
	Select s4 = new Select(children);
	s4.selectByValue(childchange);
	Thread.sleep(1000);
	
	WebElement infants =	driver.findElement(By.id("ctl00_mainContent_ddl_Infant"));
	//infants.click();
	String infantchange =Integer.toString(infant); 
	Select s5 = new Select(infants);
	s5.selectByValue(infantchange);
	Thread.sleep(1000);
	
	passenger.click();
	
	WebElement currencytype =	driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//	currencytype.click();
	String currencychange =Integer.toString(currency); 
	Select s6 = new Select(currencytype);
	s6.selectByIndex(1);
	Thread.sleep(1000);
	
	WebElement searchBtn=driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
	searchBtn.click();
	
	
	WebElement Text=driver.findElement(By.xpath("//div[@class='no_flights padding-left-15']"));
	boolean flightext=Text.isDisplayed();
	
	
	if(flightext)
	{
		
	System.out.println(	Text.getText());
		
	}
	
	else
		
	{
		System.out.println("failed");
		
	}
	
//	driver.close();
		
	}

}
