package com.haaris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haaris.model.ConfirmOrder;


@Repository
public interface ConfirmOrderRepository extends JpaRepository<ConfirmOrder,Long> {
	
	 @Query(value = "SELECT a FROM ConfirmOrder a WHERE a.ccflag=?1")
	 List<ConfirmOrder> getAllOrder(int ccflag);
	 
	 @Transactional
	 @Modifying
	 @Query("update ConfirmOrder u set u.ccflag = :ccflag where u.cid = :cid and u.invoiceId = :invoiceId")
	 void updateccflag(@Param(value = "cid") long cid,  @Param(value = "invoiceId") String invoiceId,@Param(value = "ccflag") int ccflag);
}
