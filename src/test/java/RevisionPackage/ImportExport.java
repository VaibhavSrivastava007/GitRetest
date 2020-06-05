package RevisionPackage;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImportExport {

	String url = "https://www.rahulshettyacademy.com/seleniumPractise/#/offers";
	WebDriver driver;

	
	@BeforeTest

	public void openBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	
	@Test
	public void getData() throws IOException {
	
		FileInputStream	f = new FileInputStream("C:\\Work\\SeleniumExcel.xlsx");
		XSSFWorkbook	w = new XSSFWorkbook(f);
		
		XSSFSheet	 sheet = w.getSheet("veggies");
	
List<WebElement> RowList =driver.findElements(By.xpath("//table/tbody/tr"));
System.out.println(RowList.size());

List<WebElement> coloumList =driver.findElements(By.xpath("//table/thead/tr/th"));
System.out.println(coloumList.size());

for(int i =0;i<RowList.size();i++)
{
	sheet.createRow(i);
	
for(int j=0; j<coloumList.size(); j++)
{
	
WebElement value=driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]" ));
String valueText=value.getText();

sheet.getRow(i).createCell(j).setCellValue(valueText);

} 
FileOutputStream fi=new FileOutputStream("C:\\Work\\SeleniumExcel.xlsx");
w.write(fi);


}


	
}


	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();

	}
}