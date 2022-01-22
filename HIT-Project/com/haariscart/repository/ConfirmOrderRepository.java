package com.haariscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haariscart.model.ConfirmOrder;

@Repository
public interface ConfirmOrderRepository extends JpaRepository<ConfirmOrder,Long> {

}
