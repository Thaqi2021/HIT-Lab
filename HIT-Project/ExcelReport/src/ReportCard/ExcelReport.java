package ReportCard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReport {

	public static void main(String[] args) throws InterruptedException, AddressException, MessagingException, IOException {

		CreateReport cr = new CreateReport();
		cr.processdata();
		
	}
	Object Data[][];
	
	void ReadExcel() throws IOException {
		System.out.println("hi excel started...");
		String path ="E:\\HIT\\ExcelReport\\src\\ReportData1.xlsx";
		File file = new File(path);
		FileInputStream Xfile = new FileInputStream(path);
		boolean check =file.exists();
		System.out.println(check);
		
		XSSFWorkbook workbook = new XSSFWorkbook(Xfile);	
		XSSFSheet sheet = workbook.getSheetAt(0); //XSSFSheet sheet = workbook.getSheet("Sheet1");
		System.out.println("No of Rows present :"+ sheet.getLastRowNum());
		System.out.println("No of columns present :"+ sheet.getRow(0).getLastCellNum());

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Data = new Object[rows+1][cols];

		for(int r =0;r<=rows;r++) {
			XSSFRow row =sheet.getRow(r);
			for(int c =0;c<cols ;c++) {
				XSSFCell cell = row.getCell(c);
				
				switch(cell.getCellType()) {
				case STRING:Data[r][c] = (cell.getStringCellValue());break;
				case NUMERIC:Data[r][c] = (cell.getNumericCellValue());break;
				case BOOLEAN:Data[r][c] = (cell.getBooleanCellValue());break;
				case FORMULA:Data[r][c] = (cell.getNumericCellValue());break;
				default:
					break;
				}
				
			}
			

		}
		
	}
}
	
