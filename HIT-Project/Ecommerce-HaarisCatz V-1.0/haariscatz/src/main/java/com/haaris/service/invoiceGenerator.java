package com.haaris.service;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.haaris.model.HaariUser;
import com.haaris.model.WishList;
import com.haaris.repository.WishListRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class invoiceGenerator {
	 
	  @Autowired 
	  UserServiceImpl userrepo;
	  
	
	  public ResponseEntity<byte[]> downloadInvoice(List<WishList> list,String invoiceNo,int cid ) throws JRException, IOException {
		  HaariUser user =userrepo.getUserById(cid);
		  JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("invoice_No", invoiceNo);
		parameters.put("toName", user.getName());
		parameters.put("toAddress", user.getAddress());
		parameters.put("toCity", user.getCity());
		parameters.put("toMobileNo", user.getMobNo()+"");



		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("src/main/resources/invoice_1.jrxml"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

		 JasperExportManager.exportReportToPdfFile(jasperPrint,"src\\main\\Data\\"+invoiceNo+".pdf");

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
		
		EmailSenderImpl emailsender= new EmailSenderImpl();
		
			emailsender.sendInvoice(user.getEmail(), "src\\main\\Data\\"+invoiceNo+".pdf");
		

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}


}
