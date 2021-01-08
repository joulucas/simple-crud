package com.jou.dsdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jou.dsdelivery.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByOrderByNameAsc();
	
}
