package ReportCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateReport {
	void processdata() throws Exception {
		ExcelReport er = new ExcelReport();
		SendReport sr = new SendReport();
		GenCertificate gcs = new GenCertificate();
		SendSMS sms = new SendSMS();
		String message="";
		try {
			er.ReadExcel();
			Object[][] data = er.Data;
			int datalen =er.Data.length;
			String Emailid[] = new String[datalen];
			System.out.println(datalen);
			String name[] = new String[datalen];
			String PName[] = new String[datalen];
			String SName[] = new String[datalen];
			double RNum[]= new double[datalen];
			String heading [] = new String[datalen];
			double Number[]=new double[datalen];
			String Cpath ="";
			String filepath="";

			for(int r=0;r<datalen;r++) {
				for(int j =0;j<data[r].length;j++) {
					if(r!=0){
//						System.out.print(er.Data[r][j]+"\t "+r+","+j+" ");

						if(j==0) {
							RNum[r] =(double) er.Data[r][j];							
						}
						else if(j==data[r].length-1) {
							Emailid[r]=(String) er.Data[r][j];
							name=Emailid[r].split("@");
							PName[r]=name[0];
						}
						else if(j==data[r].length-2) {
							Number[r] =(double) er.Data[r][j];
						}
						else if(j==1) {
							SName[r] = (String) er.Data[r][j];
						}
					   else {
							continue;
						}
					}
					
				}
//				System.out.println((long)Number[r]+"-------");//Progress Details Sending through SMS.

				XSSFWorkbook work = new XSSFWorkbook();
				XSSFSheet sheet = work.createSheet();
								
				int rows = datalen;
				int cols =data[r].length;
				String resultWhole = "Pass";
				for(int c =0;c<cols;c++) {
					XSSFRow row = sheet.createRow(c);
					XSSFCell cell=row.createCell(1); 
					XSSFCell head=row.createCell(0);
					XSSFCell result=row.createCell(2);

					Object copyData =data[r][c];
					Object value=copyData;
					heading[r]=(String) data[0][c];
										

					if(r!=0&&c!=data[r].length-1&&c!=data[r].length-2) {
					message += heading[r]+" :";
					
					}
					
                   if(c!=data[r].length-1&& heading[r].length() !=data[r].length-1&&c!=data[r].length-2) {
   					head.setCellValue(heading[r]);

					if(value instanceof String) {
						cell.setCellValue((String)value);
						if(r!=0)
						message+=value+" "+"\n";
					}
						
					else if(value instanceof Number) {
						cell.setCellValue((double)value);
						double check = (double)value;
							if(c!=0) {
							if(check>=60 && check <= 100) {
								String r1 ="Pass";
								resultWhole = resultWhole.equals("Fail")? "Fail":"Pass";
								result.setCellValue(r1);
								message+=value+" "+r1+"\n";
							}
							else if(check<60) {
								String r2 ="Fail";
								resultWhole="Fail";
								result.setCellValue(r2);
								message+=value+" "+r2+"\n";


							}else {result.setCellValue(resultWhole);
							message+=value+" "+resultWhole+"\n";
							}
							}else {result.setCellValue("Result");
							message+=value+" "+"\n";
							}
						}
					
					else if(value instanceof Boolean) {
						cell.setCellValue((Boolean)value);}	
					else {
						continue;
					}
					
                   }
				}
				
				
//				System.out.println(message);
				
				try {
					
					if(r!=0) {
						filepath ="E:\\HIT\\ExcelReport\\src\\Data\\"+(int)RNum[r]+"-"+SName[r]+"Report.xlsx";
						if(resultWhole.equals("Pass")) {
							Cpath ="E:\\HIT\\ExcelReport\\src\\Data\\Certificate\\"+(int)RNum[r]+"-"+SName[r]+".pdf";
							gcs.certify(Cpath,SName[r] );
						}
						else {
							Cpath=filepath;
						}				
												
						System.out.println(filepath);
						FileOutputStream fos = new FileOutputStream(filepath);
						work.write(fos);
						fos.close();
//						-----------------Set password in  Excel file--------------------
//						try(POIFSFileSystem fs = new POIFSFileSystem() ){
//							
//							int min = 100000;  
//							int max = 1000000;  
//							int otp = (int) (Math.random()*(max-min+1)+min);  
//							String ootp = otp+"";
//							System.out.println(SName[r]+" : "+ootp);
//							message="";
//							message ="\nTo Open Your Result in Email Use this Password :"+ootp;
//							EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
//							org.apache.poi.poifs.crypt.Encryptor enc =info.getEncryptor();		
//							enc.confirmPassword(ootp);
//							try(OPCPackage opc =OPCPackage.open(new File(filepath),PackageAccess.READ_WRITE );
//									OutputStream os = enc.getDataStream(fs)){
//									opc.save(os);
//							}
//							try (
//								FileOutputStream fosi = new FileOutputStream(filepath) ){
//									fs.writeFilesystem(fosi);
//								}
//							}
//						catch(Exception e) {
//							e.printStackTrace();
//						}
//						Optional way------------------------------
						
						System.out.println(SName[r]+"Excel is created..........");
						if(Emailid[r].contains(PName[r])) {
						sr.setupServerProperties();
						sr.draftEmail(PName[r], Emailid[r], filepath,SName[r],Cpath);
						sr.sendEmail();}
						sms.sendSms(message,((long)Number[r]));  //Optional way of sending Result in SMS 
						message = "";

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
