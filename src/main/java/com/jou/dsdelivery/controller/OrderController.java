package com.jou.dsdelivery.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jou.dsdelivery.domain.Order;
import com.jou.dsdelivery.dto.OrderDTO;
import com.jou.dsdelivery.dto.ProductDTO;
import com.jou.dsdelivery.service.OrderService;
import com.jou.dsdelivery.service.ProductService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping 
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return  ResponseEntity.created(uri).body(service.insert(dto));
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){
		OrderDTO dto = service.setDelivered(id);
		return ResponseEntity.ok(dto);
	}

}
