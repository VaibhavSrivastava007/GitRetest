 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	//identify testcase coulmn by scanning entire row

	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		ArrayList<String> a=new ArrayList<String>();
		
		FileInputStream fis= new FileInputStream("C://Users//Vaibhav Srivastava//Documents//datademo.xlsx");	
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
	   int	sheets= workbook.getNumberOfSheets();
	         
	   for(int i=0;i<sheets;i++)
		   
	   {
		   if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
	        {
			   XSSFSheet sheet=workbook.getSheetAt(i); 
			 
			   Iterator<Row> Rows=sheet.iterator();
			   Row firstrow= Rows.next();
			   
			  Iterator <Cell> ce= firstrow.cellIterator();
			  int k = 0;
			  int coloumn = 0;
			 while (ce.hasNext()) //next ecll ispresent or not //
			 {
				 if(ce.next().getStringCellValue().equalsIgnoreCase("Testcases")) //next cell has value as Testcases or not
				 {
					 k=coloumn;
					 //now grab coloumn index
				 }
					
					k++; 
			 }
				 
				 System.out.println(coloumn);
			   
				 while(Rows.hasNext())
				 {
					 Row r = Rows.next();
					 if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("testcaseName"))
					 {
						 Iterator<Cell> cr=r.cellIterator();
						 while(cr.hasNext())
				 a.add(cr.next().getStringCellValue());
					
					 }
				 
				 }
				 
				 
				 
		    }
		   
		  
		 
		   
	   }
	return a;
			
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	
	{
		
		
	}
	
		}

} 


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*working code-
 
FileInputStream fis= new FileInputStream("C://Users//Vaibhav Srivastava//Documents//datademo.xlsx");	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
   int	sheets= workbook.getNumberOfSheets();
         
   for(int i=0;i<sheets;i++)
	   
   {
	   if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
        {
		   XSSFSheet sheet=workbook.getSheetAt(i); 
		 
		   Iterator<Row> Rows=sheet.iterator();
		   Row firstrow= Rows.next();
		   
		  Iterator <Cell> ce= firstrow.cellIterator();
		  int k = 0;
		  int coloumn = 0;
		 while (ce.hasNext()) //next ecll ispresent or not //
		 {
			 if(ce.next().getStringCellValue().equalsIgnoreCase("Testcases")) //next cell has value as Testcases or not
			 {
				 k=coloumn;
				 //now grab coloumn index
			 }
				
				k++; 
		 }
			 
			 System.out.println(coloumn);
		   
			 while(Rows.hasNext())
			 {
				 Row r = Rows.next();
				 if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Purchase"))
				 {
					 Iterator<Cell> cr=r.cellIterator();
					 while(cr.hasNext())
			 System.out.println	 (cr.next().getStringCellValue());
				
				 }
			  
 		
 		
 		
 		
 		
 		
 		  
 		
 		
 		
 		
 */
		






/*FileInputStream fis = new FileInputStream("C://Users//Vaibhav Srivastava//Documents//datademo.xlsx);
XSSFworkbook workbook =new XSSFworkbook(fis); 

int sheets = workbook.getnumberofsheets(); //no of sheets present in excel
for(i=0,i<sheets;i++)

if(workbook.getsheetname(i).equals("Testdata");
XSSFSheet sheet = workbook.getsheetat(i); //access to testdata sheet

//Scan 1st row to  identify test case column//
 Iterator<Row> rows=sheet.Iterator(); //sheet is collection of rows
 rows.next();  //access to 1st row //
 Row firstrow=rows.next();         
 
 <Iterator<Cell> ce=firstrow.celliterator();//go to next column in frst row
 while(ce.hasnext()) // row is collection of cells
 int k =0;
 int coloumn=0;
 
 { Cell value=ce.next(); //moves to 1st cell
 if(value.getStringValue().eqaulsignrcase("TEstCases")//extract string prsnt in that cell

{
    coloumn =k;
    }
  k++;
 }
sys.out.prntln(Coloumn);   // coloumn testcase identified



 
 
 
 */





