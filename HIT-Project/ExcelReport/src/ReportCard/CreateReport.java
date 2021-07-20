package ReportCard;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateReport {
	void processdata() throws AddressException, MessagingException {
		ExcelReport er = new ExcelReport();
		SendReport sr = new SendReport();
		try {
			er.ReadExcel();
			Object[][] data = er.Data;
//		
//			
//			System.out.println(er.Data.length);
			int datalen =er.Data.length;
			String Emailid[] = new String[datalen];
			System.out.println(datalen);
			String name[] = new String[datalen];
			String PName[] = new String[datalen];
			String SName[] = new String[datalen];
			double RNum[]= new double[datalen];
			String heading [] = new String[datalen];

			for(int r=0;r<datalen;r++) {
				for(int j =0;j<data[r].length;j++) {
					if(r==0) {

					}else {
//						System.out.print(er.Data[r][j]+"\t "+r+","+j+" ");

						if(j==0) {
							RNum[r] =(double) er.Data[r][j];							
						}
						else if(j==data[r].length-1) {
							Emailid[r]=(String) er.Data[r][j];
							name=Emailid[r].split("@");
							PName[r]=name[0];
						}
						else if(j==1) {
							SName[r] = (String) er.Data[r][j];
						}
					   else {
							continue;
						}
					}
					
				}
				
				XSSFWorkbook work = new XSSFWorkbook();
				XSSFSheet sheet = work.createSheet();
				
				int rows = datalen;
				int cols =data[r].length;
				for(int c =0;c<cols;c++) {
					XSSFRow row = sheet.createRow(c);
					XSSFCell cell=row.createCell(1); 
					XSSFCell head=row.createCell(0);

					Object copyData =data[r][c];
					Object value=copyData;
					heading[r]=(String) data[0][c];
					head.setCellValue(heading[r]);

//					System.out.println(value);

					if(value instanceof String) {
						cell.setCellValue((String)value);}
						
					else if(value instanceof Number) {
						cell.setCellValue((double)value);}
					else if(value instanceof Boolean) {
						cell.setCellValue((Boolean)value);}	
					else {
						continue;
					}
					
				}

				String filepath ="E:\\HIT\\ExcelReport\\src\\Data\\"+(int)RNum[r]+"-"+SName[r]+"Report.xlsx";
				System.out.println(filepath);

				try {
					FileOutputStream fos = new FileOutputStream(filepath);
					work.write(fos);
					fos.close();
					if(r==0) {}else {
						System.out.println(SName[r]+"Excel is created..........");
						if(Emailid[r].contains(PName[r])) {
						sr.setupServerProperties();
						sr.draftEmail(PName[r], Emailid[r], filepath,SName[r]);
						sr.sendEmail();}
						}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
