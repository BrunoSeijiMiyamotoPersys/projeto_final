package com.vendas.vendas.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vendas.vendas.domain.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long>{

	Optional<Sales> findBySellerName(String sellerName);

	@Query("SELECT obj FROM Sales obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	List<Sales> findByRangeDate(LocalDate min, LocalDate max);

}
