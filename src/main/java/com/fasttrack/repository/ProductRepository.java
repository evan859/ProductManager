package com.fasttrack.repository;

import com.fasttrack.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	@Query("select p from Product p where p.UPC = :UPC")
	Product findByUPC(@Param(value="UPC") String UPC);
	
	List<Product> findAll();
	
	@Query("select count(p) from Product p")
	Long getRecordCount();
	
	Product findTop1ByOrderByImportDateDesc();
	
}
