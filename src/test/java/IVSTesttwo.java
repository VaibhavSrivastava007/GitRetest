import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IVSTesttwo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 
		String filepath="C://Users//Vaibhav Srivastava//Documents//IVSIS.xlsx";
		FileInputStream f=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(f);
		
		 int sheets= workbook.getNumberOfSheets();
		 System.out.println(sheets);
		for (int i=0;i<sheets;i++)
		{
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("Credentials"))
			{	XSSFSheet sheet	= workbook.getSheetAt(i);
			
			
		int totalrows=	(sheet.getLastRowNum()-sheet.getFirstRowNum());
		int totalcoloumns = sheet.getRow(0).getLastCellNum();
		System.out.println("gobar0");
		for(int r=0;r<=totalrows;r++)
		
		for (int c=1;c<totalcoloumns;c++)
		{
			if(sheet.getRow(r).getCell(c).getStringCellValue().equalsIgnoreCase("Password"))
				System.out.println("gobar1");
			{
				for(int rw=0;rw<=totalrows;rw++)
				{
					System.out.println("gobar2");
					
				
					if(sheet.getRow(rw).getCell(c).getStringCellValue().equalsIgnoreCase("CentralPerk"))
					{
						
						
								
						for(int cc=0;cc<totalcoloumns;cc++)
							
						{
							sheet.getRow(rw).getCell(cc);}
						}
							
					}
				}
				
				}
			}
		
		
		
		
		}
			
			}
			
			
			
		}
		
	
	

