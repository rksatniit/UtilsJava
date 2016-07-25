package com.prodep.poi.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.prodep.poi.mongodb.Employee;
import com.prodep.poi.mongodb.EmployeeDataBroker;

public class ExcelWorkBookUtils {

	public static void createWorkBook(String withFileName) throws Exception{

		workBookWithData(withFileName);
	}

	private static void workBookWithData(String withFileName) throws FileNotFoundException, IOException {
		//Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		//Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet( 
				" Employee Info ");
		//Create row object
		XSSFRow row;
		//This data needs to be written (Object[])
		Map < String, Object[] > empinfo = 
				new TreeMap < String, Object[] >();
				empinfo.put( "1", new Object[] { 
						"EMP ID", "EMP NAME", "DESIGNATION" });
				empinfo.put( "2", new Object[] { 
						"tp01", "Gopal", "Technical Manager" });
				empinfo.put( "3", new Object[] { 
						"tp02", "Manisha", "Proof Reader" });
				empinfo.put( "4", new Object[] { 
						"tp03", "Masthan", "Technical Writer" });
				empinfo.put( "5", new Object[] { 
						"tp04", "Satish", "Technical Writer" });
				empinfo.put( "6", new Object[] { 
						"tp05", "Krishna", "Technical Writer" });
				//Iterate over data and write to sheet
				Set < String > keyid = empinfo.keySet();
				int rowid = 0;
				for (String key : keyid)
				{
					row = spreadsheet.createRow(rowid++);
					Object [] objectArr = empinfo.get(key);
					int cellid = 0;
					for (Object obj : objectArr)
					{
						Cell cell = row.createCell(cellid++);
						cell.setCellValue((String)obj);
					}
				}
				//Write the workbook in file system
				FileOutputStream out = new FileOutputStream( new File("C:\\ZZZZ\\"+withFileName+".xlsx"));
				workbook.write(out);
				out.close();
				System.out.println(withFileName + " written successfully" );
	}

	public static XSSFWorkbook createWorkBookWithData() {
		//Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		//Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet( 
				" Employee Info ");
		//Create row object
		XSSFRow row;
		//This data needs to be written (Object[])
		Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
		empinfo.put( "1", new Object[] {"Emp ID", "First Name", "Last Name" });
		
		// We can enable the following code in order to work with Mongo DB
		// Get the data from Mongo DB here
		/*EmployeeDataBroker broker = new EmployeeDataBroker();
		List<Employee> emps = broker.findAllEmployees();
		int insertCounter = 1;
		for(Employee emp: emps) {
			empinfo.put( String.valueOf(++insertCounter), new Object[] {String.valueOf(emp.getId()), emp.getFirstName(), emp.getLastName()});
		}*/
		empinfo.put( "2", new Object[] { 
				"tp01", "Tom", "Tome" });
		empinfo.put( "3", new Object[] { 
				"tp02", "John", "John" });
		empinfo.put( "4", new Object[] { 
				"tp03", "Varsha", "Varsha" });
		empinfo.put( "5", new Object[] { 
				"tp04", "Peter", "Peter" });
		empinfo.put( "6", new Object[] { 
				"tp05", "Karthik", "Karthik" });
		//Iterate over data and write to sheet
		Set < String > keyid = empinfo.keySet();
		int rowid = 0;
		for (String key : keyid)
		{
			row = spreadsheet.createRow(rowid++);
			Object [] objectArr = empinfo.get(key);
			int cellid = 0;
			for (Object obj : objectArr)
			{
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String)obj);
			}
		}
		return workbook;
	}

	private static void emptyWorkBook(String withFileName) throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		//Create file system using specific name
		FileOutputStream out = new FileOutputStream( new File("C:\\XXXX\\"+withFileName+".xlsx"));
		//write operation workbook using file out object 
		workbook.write(out);
		out.close();
		System.out.println(withFileName + " written successfully");
	}


}
