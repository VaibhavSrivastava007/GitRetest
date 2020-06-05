import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IVSTEstThree {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

String filepath = "C://Users//Vaibhav Srivastava//Documents//datademo.xlsx";
FileInputStream f =new FileInputStream(filepath);	
XSSFWorkbook workbook = new XSSFWorkbook(filepath);
	
	
	int TotalSheets = workbook.getNumberOfSheets();

	// System.out.println(TotalSheets);
	
	
	
	for(int i=0 ;i<TotalSheets;i++)
	{
		if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("testdata"))
		{
			XSSFSheet Sheet= workbook.getSheetAt(i); //motea
		
			int Totalrows=Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		int	Totalcoloumns = Sheet.getRow(0).getLastCellNum();
			
			
			for (int r=0;r<=Totalrows;r++)
			{
				for(int c=0;c<Totalcoloumns;c++)
				{
				    if(Sheet.getRow(r).getCell(c).getStringCellValue().equalsIgnoreCase("Data3"))
				    {
				    	int motea = c;
				    	for(int rw=0;rw<=Totalrows;rw++)
				    	{
				    		if(Sheet.getRow(rw).getCell(motea).getStringCellValue().equalsIgnoreCase("nine"))
				    		{
				    			int mahamotea= rw;
				    			for(int cc=0; cc<Totalcoloumns;cc++) 
				    			{
				    				//System.out.println(Sheet.getRow(rw).getCell(cc));
				    				System.out.println("motea bhains:"+Sheet.getRow(mahamotea).getCell(motea).getStringCellValue());
				    			}
				    			
				    			//motea bhains aloo golgappa maida balloon
				    			
				    		}
				    		
				    	}
				    		
				    }
				
				
				    }
			}
			
			
			}
			
		
		
		}
	
	    
	
	
	}
	
	
	
	
	
	
	}


