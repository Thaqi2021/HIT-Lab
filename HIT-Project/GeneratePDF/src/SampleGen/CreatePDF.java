package SampleGen;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDestination;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.TextField;
import java.text.DateFormat;


public class CreatePDF {

	public static void main(String[] args) throws Exception {
		System.out.println("hi Im Generating PDF......");
//		System.out.println("Enter the Name :");
//		Scanner sc = new Scanner(System.in);
//		String CertName= sc.nextLine();
		String CertName ="Cert-Name";
		String path ="E:\\HIT\\GeneratePDF\\Data\\"+CertName+".pdf";
		try {
			addContentToCertificate(path);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	private static void addContentToCertificate(String pdfName) throws Exception {
		try {
			String imgpath="E:\\HIT\\GeneratePDF\\Data\\Certificate.jpg";

			PdfReader pdfReader = new PdfReader("temp.pdf");
			PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(pdfName));
			Image image = Image.getInstance(imgpath);
			
			for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
				if (i == 1) {

					PdfContentByte content = pdfStamper.getUnderContent(i);
					image.setAbsolutePosition(0, 0);
					image.scaleToFit(PageSize.A3.getWidth(), PageSize.A3.getHeight());
					content.addImage(image);

					String headerData = "This is Certificate is Proudly Awarded to";
//				    Scanner sc = new Scanner(System.in);
//				    System.out.println("Enter the Name of Participant");
//				    String studentName = sc.nextLine();
					String studentName = "Mr.Participant Name ";
					String providerName="Mr Mohammed Shouib";

					String midData = "Project on: PDF E-CERTIFICATE CREATION USING JAVA\n\n"
							+ "Successfylly Completed the project and submitted on-time"
							+ " and his participation very good. The programming language used for this"
							+ " project is \"JAVA\" and \"iText Library\" for creating and Generating the PDF E-Certificate.\n"
							+ "\nWe wish him goo luck for his future.....";
					Date date = new Date();
				    DateFormat dateFormat;
				    dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
				    String presentby = "Conducted By\n"+providerName;
					String direc = "Director of Haaris Infotech Pvt. Ltd.";
					String seal="Best \nAward";
					
					setData(pdfStamper, headerData, BaseFont.TIMES_BOLDITALIC, 26, BaseColor.WHITE, 530, 520, 80,490);
					setData(pdfStamper, studentName, BaseFont.TIMES_BOLDITALIC, 34, BaseColor.LIGHT_GRAY, 530, 416, 80, 370);
					setData(pdfStamper, midData, BaseFont.TIMES_BOLDITALIC, 14, BaseColor.WHITE, 530, 220, 70, 340);
					setData(pdfStamper,  dateFormat.format(date), BaseFont.TIMES_BOLDITALIC, 16, BaseColor.CYAN, 200, 140, 50,100);
					setData(pdfStamper, "Acquired on", BaseFont.TIMES_BOLDITALIC, 14, BaseColor.WHITE, 200, 120, 50,95);
					setData(pdfStamper, presentby, BaseFont.TIMES_ITALIC, 18, BaseColor.WHITE, 360, 160, 575,100);
					setData(pdfStamper, direc, BaseFont.TIMES_BOLDITALIC, 14, BaseColor.WHITE, 360, 120, 575, 100);
					setData(pdfStamper, seal, BaseFont.TIMES_BOLDITALIC, 16, BaseColor.WHITE, 380, 220, 950, 100);


				}

			}

			pdfStamper.close();
			pdfReader.close();

			System.out.println("Successfully added content & created the PDF E-Certificate : " + pdfName);

		} catch (IOException e) {
			System.out.println("Exception while adding Content To Certificate");
			e.printStackTrace();
		}

	}
	private static void setData(PdfStamper pdfStamper, String data, String fontType, float fontSize,
			BaseColor fontColor, float lowerX, float lowerY, float upperX, float upperY) throws Exception {
		try {

			TextField textField = new TextField(pdfStamper.getWriter(), new Rectangle(lowerX, lowerY, upperX, upperY),"newTextField");
			textField.setOptions(TextField.MULTILINE | TextField.READ_ONLY);
			textField.setAlignment(Element.ALIGN_CENTER);
			textField.setTextColor(fontColor);
			BaseFont baseFont = BaseFont.createFont(fontType, BaseFont.WINANSI, BaseFont.EMBEDDED);
			textField.setFont(baseFont);
			textField.setFontSize(fontSize);
			textField.setText(data);
			pdfStamper.addAnnotation(textField.getTextField(), 1);

		} catch (Exception ex) {
			System.out.println("Exception while Setting Data: " + data);
			ex.printStackTrace();
		}

	}

}
