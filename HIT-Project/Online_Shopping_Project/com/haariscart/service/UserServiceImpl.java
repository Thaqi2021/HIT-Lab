package com.haariscart.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.haariscart.model.HaariUser;
import com.haariscart.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userrep;
	public UserServiceImpl(UserRepository userrep) {
		this.userrep=userrep;
	}
	@Override
	public void saveUser(HaariUser user) {
		// TODO Auto-generated method stub
		user.setJoiningDate(LocalDate.now());
		userrep.save(user);
	}

	@Override
	public HaariUser getUserById(long UserId) {
		Optional<HaariUser> user =userrep.findById(UserId);
		if(user.isPresent()) {
		return user.get();
		}
		return null;
	}

	@Override
	public HaariUser updateUser(HaariUser user, long id) {
		HaariUser existinguser =userrep.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id)); 
		
		existinguser.setName(user.getName());
		existinguser.setPassword(user.getPassword());
		existinguser.setEmail(user.getEmail());
		existinguser.setMobNo(user.getMobNo());
		existinguser.setAddress(user.getAddress());
		existinguser.setCity(user.getCity());
		existinguser.setCountry(user.getCountry());

		// save existing employee to DB
		userrep.save(existinguser);
		return existinguser;
	
	}

	@Override
	public void deleteUser(long id) {
		userrep.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", id));
		userrep.deleteById(id);
		
	}
	@Override
	public List<HaariUser> getAllUser() {
		// TODO Auto-generated method stub
		return userrep.findAll();
	}
	@Override
	public String updateflag(HaariUser user,long UserId) {
		HaariUser existinguser1 =userrep.findById(UserId).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", UserId)); 
		if(user.getFlag()==0) {
		existinguser1.setFlag(1);
		userrep.save(existinguser1);
		return "yes";
		}
		else {
			return "already login";
		}
	
	}
	@Override
	public String checkUser(String email, String password) {
		// TODO Auto-generated method stub
		Optional<HaariUser> user =userrep.findByEmailAndPassword(email, password);;
		if(user.isPresent()) {
		updateflag(user.get(),user.get().getId());
		return user.get().getId()+"";
		}
		return "No";
	}
	@Override
	public String findUser(HaariUser finduser) {
		long mobileNumber=finduser.getMobNo();
		Optional<HaariUser> user=userrep.findByMobNo(mobileNumber);
		if(user.isPresent()) {
			return "exists";
		}
		else {
		return "new";
		}
	}
		
	

}
