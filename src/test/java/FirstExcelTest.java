import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstExcelTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

			
				// TODO Auto-generated method stub

				 System.setProperty("webdriver.chrome.driver" , "C:\\Work\\chromedriver.exe")	;
				WebDriver driver=new ChromeDriver();
				driver.get("https://courses.rahulshettyacademy.com/");   //yahan se maine exel file uda thi t=jab eclipse se tbse err aa rha 
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[@class='theme-btn']")).click();
				
				FileInputStream f = new FileInputStream("C:\\Work\\SeleniumExcel.xlsx");
				
				XSSFWorkbook workbook = new XSSFWorkbook(f);
	
			XSSFSheet sheetname=	workbook.getSheet("First");
			XSSFSheet sheet2=	workbook.getSheet("Second");
			
		String username=	sheetname.getRow(1).getCell(0).getStringCellValue();
		

				driver.findElement(By.id("user_email")).sendKeys(username);
				
			String password = sheetname.getRow(1).getCell(1).getStringCellValue();	
				
			driver.findElement(By.id("user_password")).sendKeys(password);
			
			driver.findElement(By.name("commit")).click();
			
			Thread.sleep(7000);
		String freetext=	driver.getTitle();
			
		Thread.sleep(3000);
		Row r=sheet2.createRow(0);
		Cell c=r.createCell(0);
		c.setCellValue(freetext);
		FileOutputStream fo=new	FileOutputStream("C:\\Work\\SeleniumExcel.xlsx");
		Thread.sleep(3000);
		workbook.write(fo);
		
		driver.close();
		
			}
	
		
	}

