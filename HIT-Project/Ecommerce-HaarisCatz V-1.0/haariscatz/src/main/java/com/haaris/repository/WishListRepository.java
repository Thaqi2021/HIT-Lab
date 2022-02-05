package com.haaris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haaris.model.WishList;


@Repository
public interface WishListRepository extends JpaRepository<WishList,Long>{

	 @Query(value = "SELECT a FROM WishList a WHERE a.cid=?1 and a.cflag=?2")
	 List<WishList> getByCid(int cid,int cflg);
	 
	 @Query(value = "SELECT a FROM WishList a WHERE a.cid=?1 and a.cflag=?2 and a.quno=?3")
	 List<WishList> getByInvoiceId(int cid,int cflg, String quno);
	 
	 @Query(value = "SELECT a FROM WishList a WHERE a.cid=?1 and a.productId=?2 and a.cflag=?3")
	 WishList getByproductId(int cid,long productId,int cflg);
	 

	 @Transactional
	 @Modifying
	 @Query("update WishList u set u.cflag = :cflag where u.cid = :cid and u.cflag = :flag")
	 void updatecflag(@Param(value = "cid") int cid, @Param(value = "cflag") int cflag, @Param(value = "flag") int xflag);
	 
	 @Transactional
	 @Modifying
	 @Query("update WishList u set u.quno = :quno where u.cid = :cid and u.cflag = :cflag")
	 void updateOrderId(@Param(value = "cid") int cid, @Param(value = "cflag") int cflag,@Param(value = "quno") String quno);
	
	 @Transactional
	 @Modifying
	 @Query(value="delete from WishList r where r.cid = ?1 and r.productId= ?2 and r.cflag=?3")
	 void deleteItem(int cid,long productid, int cflag);
	 
	 @Transactional
	 @Modifying
	 @Query("update WishList u set u.cflag = :cflag where u.cid = :cid and u.quno = :quno")
	 void updatecflagByOrderId(@Param(value = "cid") int cid, @Param(value = "cflag") int cflag, @Param(value = "quno") String quno);
}
