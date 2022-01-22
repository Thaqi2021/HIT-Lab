package com.haariscart;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.haariscart.model.HaariUser;
import com.haariscart.repository.UserRepository;
import com.haariscart.service.UserService;
import com.haariscart.service.UserServiceImpl;

public class Tester {
	@Autowired
	UserRepository rep;
	
	void testing() {
	
	HaariUser user = new HaariUser();
	user.setName("Thaqi");
	user.setPassword("Thaqi1234");
	user.setEmail("thaqicm@gmail.com");
	user.setCity("chennai");
	user.setAddress("sundaram ln,pursai");
	user.setJoiningDate(LocalDate.now());
	user.setCountry("india");
	user.setFlag(0);
	user.setMobNo(7845014181L);
	
	UserService service =new UserServiceImpl(rep) ;

	service.saveUser(user);
	
	}
}
