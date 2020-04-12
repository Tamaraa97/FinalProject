package FinalProjekt.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read {
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static FileInputStream fis;

	public static void findExcelSheet() {
		try {
			fis = new FileInputStream("MOCK_DATA.xlsx");
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String id(int i) {
		DataFormatter formatter = new DataFormatter(); 
		Cell cell = sheet.getRow(i).getCell(0);
		String id= formatter.formatCellValue(cell);
		return id;
	}
	
	public static String gender(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(1);
		return cell.getStringCellValue();
		
	}

	public static String FirstName(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(2);
		return cell.getStringCellValue();
	}

	public static String LastName(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(3);
		return cell.getStringCellValue();
	}

	public static String EMail(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(4);
		return cell.getStringCellValue();
	}

	public static String Password(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(5);
		return cell.getStringCellValue();
	}

	public static String Address(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(6);
		return cell.getStringCellValue();
	}

	public static String City(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(7);
		return cell.getStringCellValue();
	}

	public static String State(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(8);
		return cell.getStringCellValue();
	}

	public static String Zip(int i) {
		DataFormatter formatter = new DataFormatter();
		Cell cell = sheet.getRow(i).getCell(9);
		String postalCode = formatter.formatCellValue(cell);
		return postalCode;
	}

	public static String getCountry(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(10);
		return cell.getStringCellValue();
	}

	public static String getMobilePhone(int i) {
		DataFormatter formatter = new DataFormatter(); 
		Cell cell = sheet.getRow(i).getCell(11);
		String mobilePhone = formatter.formatCellValue(cell);
		return mobilePhone;
	}
	
	public static int getRowNumber() {
		try {
			return sheet.getLastRowNum() + 1;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error.");
			return -1;
		}
	}
	
	public static void closeFis() {
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
