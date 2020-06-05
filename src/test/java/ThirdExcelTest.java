import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class ThirdExcelTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	
	

	
	//@BeforeTest
	
	//public void openBrowser() throws IOException
	{
		
	    
	    System.setProperty("webdriver.chrome.driver" , "C:\\Work\\chromedriver.exe");
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
	
		double adult =sheet3.getRow(1).getCell(2).getNumericCellValue();
		
		System.out.println(adult);
		
		double child =sheet3.getRow(1).getCell(3).getNumericCellValue();
		System.out.println(child);
	

		double infant =sheet3.getRow(1).getCell(4).getNumericCellValue();
		System.out.println(infant);
		
		double currency =sheet3.getRow(1).getCell(5).getNumericCellValue();
		System.out.println(currency);
		
	WebElement source=	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
	source.click();
	Thread.sleep(2000);
	Select s1 = new Select(source) ;
	s1.selectByValue(from);
	Thread.sleep(5000);
	
	WebElement dest=	driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
	dest.click();
    Thread.sleep(2000);
	Select s2 = new Select(dest);
	s2.selectByValue(to);
	Thread.sleep(5000);
	
	WebElement date =	driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/table/tbody/tr[5]/td[2]"));
	//date.click();
	
	WebElement passenger =	driver.findElement(By.id("divpaxinfo"));
	passenger.click();
	Thread.sleep(5000);
	
	
	WebElement adults =	driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
	adults.click();
	Thread.sleep(3000);
	String adultchange =Double.toString(adult); 
	Select s3 = new Select(adults);
	s3.selectByValue(adultchange);
	Thread.sleep(3000);
	
	WebElement children =	driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
	Thread.sleep(3000);
	String childchange =Double.toString(child); 
	Select s4 = new Select(children);
	s4.selectByValue(childchange);
	Thread.sleep(3000);
	
	WebElement infants =	driver.findElement(By.id("ctl00_mainContent_ddl_Infant"));
	infants.click();
	Thread.sleep(3000);
	String infantchange =Double.toString(infant); 
	Select s5 = new Select(infants);
	s5.selectByValue(infantchange);
	Thread.sleep(3000);
	
	WebElement currencytype =	driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	currencytype.click();
	Thread.sleep(3000);
	String currencychange =Double.toString(currency); 
	Select s6 = new Select(currencytype);
	s6.selectByIndex(0);
	Thread.sleep(3000);
	
	
	
	

	
	
	

	
	
	
	
	//29june--$x("//div[@class='ui-datepicker-group ui-datepicker-group-last']/table/tbody/tr[5]/td[2]")
	
	}
	
	
	}	
	
	
}
