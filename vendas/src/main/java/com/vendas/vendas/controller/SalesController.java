package com.vendas.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.vendas.domain.Sales;
import com.vendas.vendas.service.SalesServices;

@RestController
public class SalesController {

	@Autowired
	private SalesServices services;
	
	@GetMapping(path = "sales")
	public ResponseEntity<List<Sales>> sales() {
		return ResponseEntity.status(HttpStatus.OK).body(services.findAll()); 
	}
	
	@GetMapping(path = "sales/{sellerName}")
	public ResponseEntity<Sales> salesFindBySellerName(@PathVariable String sellerName) {
		return ResponseEntity.status(HttpStatus.OK).body(services.findBySellerName(sellerName).get()); 
	}
	
	@GetMapping(path = "sales")
	public ResponseEntity<Sales> salesFindByDate(@PathVariable String sellerName) {
		return ResponseEntity.status(HttpStatus.OK).body(services.findBySellerName(sellerName).get()); 
	}
}
