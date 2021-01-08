package com.jou.dsdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jou.dsdelivery.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query("seLECT distinct obj from Order obj join fetch obj.products "
			+ "	where obj.status = 0 order by obj.moment asc")
	List<Order> findOrdersWithProducts();

}
