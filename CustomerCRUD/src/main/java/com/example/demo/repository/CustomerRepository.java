package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByMob(String mob);
//	JpaRepository means = Ready-made database methods
	
	List<Customer> findByName(String name);
	
	List<Customer> findByAddress(String address);

	boolean existsByMob(String mob);

	
}
