package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//step 1: convert physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/sel1.xlsx");
    
    //step 2: open workbook
		Workbook wb = WorkbookFactory.create(fis);
		
	//step 3: get control over sheet
		Sheet sheet = wb.getSheet("Sheet1");
	
    //step 4: get control over row
		Row row = sheet.getRow(3);
		
	//step 5: get control over cell
		Cell cell = row.getCell(1);
		
	//step 6: fetch data from cell
		System.out.println(cell.getStringCellValue());
		
   //step 7: close excel 
		wb.close();
	}
}
