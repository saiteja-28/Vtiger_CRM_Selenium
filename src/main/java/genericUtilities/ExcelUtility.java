package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class contains reusable method to perform read and write operations on Excel
 */
public class ExcelUtility {
	Workbook wb;
	Sheet sheet;

	/**
	 * this method initializes excel
	 * @param excelpath
	 * @param sheetName
	 */
	public void ExcelInit(String excelpath, String sheetName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);
	}
/**
 * this method is used to read the data from excel
 * @param expectedTestName
 * @return Map<String, String>
 */
	public Map<String, String> readFromExcel(String expectedTestName) {
		Map<String, String> map = new HashMap<String, String>();
		DataFormatter df = new DataFormatter();
		int requiredRow = 0;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			requiredRow = i;
			if (df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTestName))
				break;
		}

		for (int j = requiredRow; j <= sheet.getLastRowNum(); j++) {
			String key = df.formatCellValue(sheet.getRow(j).getCell(2));
			String value = df.formatCellValue(sheet.getRow(j).getCell(3));
			if (key.equals("####"))
				break;
			map.put(key, value);
		}
		return map;
	}
/**
 * this method is used to update test status to excel
 * @param expectedTestName
 * @param status
 */
	public void updatestatus(String expectedTestName, String status) {
		DataFormatter df = new DataFormatter();
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTestName)) {
				sheet.getRow(i).createCell(4).setCellValue(status);
				break;
			}
		}
	}
	
/**
 * this method is used to save excel
 * @param excelPath
 */
	public void saveExcel(String excelPath) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * this method closes excel workbook
 */
	public void closeExcel() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}