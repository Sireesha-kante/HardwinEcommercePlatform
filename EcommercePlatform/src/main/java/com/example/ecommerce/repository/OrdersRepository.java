package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	public List<Orders> findByUserId(long userId);

}
