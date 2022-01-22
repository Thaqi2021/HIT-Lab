package com.haariscart.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;

import com.haariscart.model.HaariUser;
import com.haariscart.model.WishList;
public class invoice {
  PDDocument invc;
  int n; 
  double total = 0;
  double price;
  String CustName;
  String CustPh;
  String address;
  	List<WishList > list=new ArrayList<WishList>();
  String InvoiceTitle = new String("HaarisCart");
  String quote = new String ("WE THE QUALITY,WE INTEGERATE QUALITY,WE THINK FOR COUSTOMERS");
  String SubTitle = new String("Invoice");
  HaariUser user =new HaariUser();
  UserServiceImpl userservice;
  //Using the constructor to create a PDF with a blank page
  public invoice() {
    //Create Document
    invc = new PDDocument();
    //Create Blank Page
    PDPage newpage = new PDPage();
    //Add the blank page
    invc.addPage(newpage);
  }
  
  void WriteInvoice() {
    //get the page
    PDPage mypage = invc.getPage(0);
    try {
      //Prepare Content Stream
      PDPageContentStream cs = new PDPageContentStream(invc, mypage);
      
      //Writing Single Line text
      //Writing the Invoice title
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 20);
      cs.newLineAtOffset(140, 750);
      cs.showText(InvoiceTitle);
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 20);
      cs.newLineAtOffset(140, 780);
      cs.showText(quote);
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 18);
      cs.newLineAtOffset(270, 690);
      cs.showText(SubTitle);
      cs.endText();
      
      //Writing Multiple Lines
      //writing the customer details
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.setLeading(20f);
      cs.newLineAtOffset(60, 610);
      cs.showText("Customer Name: ");
      cs.newLine();
      cs.showText("Phone Number: ");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.setLeading(20f);
      cs.newLineAtOffset(170, 610);
      cs.showText(CustName);
      cs.newLine();
      cs.showText(CustPh);
      cs.endText();
      
      cs.moveTo(0, 10);
      cs.lineTo(0, 10);
      cs.stroke();  
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(80, 540);
      cs.showText("Product Name");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(200, 540);
      cs.showText("Unit Price");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(310, 540);
      cs.showText("Quantity");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(410, 540);
      cs.showText("Price");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(80, 520);
      for(int i=0;i<n;i++) {
        cs.showText(""+list.get(i).getProductName());
        cs.newLine();
      }
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(200, 520);
      for(int i=0;i<n;i++) {
        cs.showText((list.get(i).getAmount()/list.get(i).getQty())+"");
        cs.newLine();
      }
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(310, 520);
      for(int i=0;i<n;i++) {
        cs.showText(list.get(i).getQty()+"");
        cs.newLine();
      }
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(410, 520);
      for(int i=0;i<n;i++) {
        price = list.get(i).getAmount();
        System.out.println(price+"...........");
        total+=list.get(i).getAmount();
        cs.showText(price+"");
        cs.newLine();

      }

      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(310, (500-(20*n)));
      cs.showText("Total: ");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      //Calculating where total is to be written using number of products
      cs.newLineAtOffset(410, (500-(20*n)));
      cs.showText(total+"");
      cs.endText();
      
      //Close the content stream
      cs.close();
      //Save the PDF
      String cpath="E:\\HIT-Spring\\HaarisCart\\src\\Invoice"+SubTitle+".pdf";
      invc.save(cpath);
      EmailSenderImpl email = new EmailSenderImpl();
     try {
		email.sendInvoice(cpath);
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  
  public void mainer(List<WishList> wishList ,String invoiceNo, UserServiceImpl userservice) {
	  list=wishList;
	  SubTitle=invoiceNo;
	  	n=list.size();
		System.out.println(wishList.size()+".....");

		user =userservice.getUserById(list.get(1).getCid());
		CustName=user.getName();
		CustPh=user.getMobNo()+"";
		address=user.getAddress();
    WriteInvoice();
    System.out.println("Invoice Generated!"+list.size());

  }
}