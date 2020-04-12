package FinalProjekt.pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataPage {
	public static void main(String[] args) throws IOException {
		File file = new File("MOCK_DATA.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
       while(rowIterator.hasNext()) {
    	   Row row = rowIterator.next();
    	   
    	   Iterator<Cell> cellIterator = row.cellIterator();
    	   while(cellIterator.hasNext()) {
    		   Cell cell = cellIterator.next();
    		   System.out.println(cell.toString() + ";");
    	   }
    	   System.out.println();
       }
       wb.close();
       fis.close();
        
	
	}
}
