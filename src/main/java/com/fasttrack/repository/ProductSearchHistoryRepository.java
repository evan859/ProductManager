package com.fasttrack.repository;

import com.fasttrack.model.ProductSearchHistory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductSearchHistoryRepository extends CrudRepository<ProductSearchHistory, Long>{
	
	@Query("select psh from ProductSearchHistory psh where psh.searchDate = :Search_Date")
	List<ProductSearchHistory> findBySearchDate(@Param(value="Search_Date") LocalDate searchDate);
	
	ProductSearchHistory findTop1ByOrderBySearchDateDesc();
	
	List<ProductSearchHistory> findAll();	
}
