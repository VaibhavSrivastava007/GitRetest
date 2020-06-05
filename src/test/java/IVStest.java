import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IVStest{
	
	public static void main(String[] args) throws IOException{
	
FileInputStream fi = new FileInputStream("C://Users//Vaibhav Srivastava//Documents//IVSIS.xlsx");
XSSFWorkbook workbook=new XSSFWorkbook(fi);

int Sheets = workbook.getNumberOfSheets();
for(int i=0;i<Sheets;i++)
{
	if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("Credentials"))
	{
	XSSFSheet Sheet=workbook.getSheetAt(i);
	
	int totalrowcount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
	
	/*System.out.println(totalrowcount);
	System.out.println((Sheet.getLastRowNum()));
	System.out.println(Sheet.getFirstRowNum());
	
	System.out.println(Sheet.getRow(0).getFirstCellNum());*/
	//System.out.println(Sheet.getlastCellNum());
	
	int coloumncount = Sheet.getRow(0).getLastCellNum(); 
	System.out.println(coloumncount);
	
	for(int r=0;r<=totalrowcount;r++)
		
	{
		for(int c=1;c<coloumncount;c++)
		{
			if(Sheet.getRow(r).getCell(c).getStringCellValue().equalsIgnoreCase("Password"))
			{ 
				for(int rw=0 ;rw<=totalrowcount;rw++)
				{//System.out.println(Sheet.getRow(rw).getCell(c)) ;
					if(Sheet.getRow(rw).getCell(c).getStringCellValue().equalsIgnoreCase("CentralPerk"))
					{
						for(int cc=0; cc<coloumncount;cc++)
						{
							System.out.println(Sheet.getRow(rw).getCell(cc));
						    
						}
						
						//System.out.println("Success");
					}
				}
			}
				
			
		}
			
	}
		
	
	
	}
	
	
	
}




}

}
