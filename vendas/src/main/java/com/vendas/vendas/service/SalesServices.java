package com.vendas.vendas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.vendas.domain.Sales;
import com.vendas.vendas.repository.SalesRepository;

@Service
public class SalesServices {
	
	@Autowired
	private SalesRepository salesRepository;
	
	public List<Sales> findAll(){
		return salesRepository.findAll();
	}
	
	public Optional<Sales> findBySellerName(String sellerName){
		return salesRepository.findBySellerName(sellerName);
	}
	
	public List<Sales> findByDate(String minDate, String maxDate){
		LocalDate min = LocalDate.parse(minDate);
		LocalDate max = LocalDate.parse(maxDate);
		
		return salesRepository.findByRangeDate(min, max);
	}

}
