import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondExcelTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

			
				// TODO Auto-generated method stub

				 System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"\\chromedriver.exe")	;
				WebDriver driver=new ChromeDriver();
				driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
				
				
				FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\SeleniumExcel.xlsx");
				
				XSSFWorkbook workbook = new XSSFWorkbook(f);
	
					XSSFSheet sheet3=	workbook.getSheet("Third");
			
		String freetext=	driver.getTitle();
	//		
		WebElement table=driver.findElement(By.id("product"));
		
		String heading=table.findElement(By.xpath("//tbody/tr/th[2]")).getText();
		System.out.println(heading);
		sheet3.createRow(0).createCell(0).setCellValue(heading);
		
		
				List<WebElement> courseList =table.findElements(By.xpath("//tbody/tr/td[2]"));
		System.out.println(courseList.size());
		for (int i=0;i<courseList.size()-1;i++)
		{
			String listText=courseList.get(i).getText();
						
			
			sheet3.createRow(i+1).createCell(0).setCellValue(listText);
			
						
		}
		
		
		
		FileOutputStream fs =new   FileOutputStream (System.getProperty("user.dir")+"\\SeleniumExcel.xlsx");
		workbook.write(fs);
		
		driver.close();
		
		
		
		
		
		
		
		/*
	
		Row r=sheet3.createRow(0);
		Cell c=r.createCell(0);
		c.setCellValue(freetext);
		
		
		
		FileOutputStream fo=new	FileOutputStream("C:\\Work\\SeleniumExcel.xlsx");
		Thread.sleep(3000);
		workbook.write(fo);
		
		driver.close();*/
		
			}
	
		
	}

