package com.haaris.service;

import java.util.List;

import com.haaris.model.HaariUser;

public interface UserService {
	public void saveUser(HaariUser user);
	List<HaariUser> getAllUser();
	
	HaariUser getUserById(long UserId);
	HaariUser updateUser(HaariUser user, long id);
    void deleteUser(long id);
    String findUser(HaariUser user);
    String checkUser(String email,String password);
    String updateflag(long UserId,String status);
	
}
