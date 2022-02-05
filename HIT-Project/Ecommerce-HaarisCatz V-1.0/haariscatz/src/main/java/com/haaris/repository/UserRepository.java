package com.haaris.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.haaris.model.HaariUser;


@Repository
public interface UserRepository extends JpaRepository<HaariUser,Long> {
	
	 @Query(value = "SELECT a FROM HaariUser a WHERE a.email=?1 AND a.password = ?2")
	 Optional<HaariUser> findByEmailAndPassword(String email , String password);
	 
	 @Query(value = "SELECT a FROM HaariUser a WHERE a.mobNo=?1 ")
	 Optional<HaariUser> findByMobNo(long mobileNumber);

}
