package com.haariscart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haariscart.model.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long>{

	 @Query(value = "SELECT a FROM WishList a WHERE a.cid=?1 and a.cflag=?2")
	 List<WishList> getByCid(int cid,int cflg);
	 
	 @Query(value = "SELECT a FROM WishList a WHERE a.cid=?1 and a.productId=?2 and a.cflag=?3")
	 WishList getByproductId(int cid,long productId,int cflg);
	 

	 @Transactional
	  @Modifying
	 @Query("update WishList u set u.cflag = :cflag where u.cid = :cid")
	 void updatecflag(@Param(value = "cid") int cid, @Param(value = "cflag") int cflag);
}
