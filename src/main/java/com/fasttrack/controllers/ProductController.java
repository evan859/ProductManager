package com.fasttrack.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasttrack.model.Product;
import com.fasttrack.model.ProductSearchHistory;
import com.fasttrack.repository.ProductRepository;
import com.fasttrack.repository.ProductSearchHistoryRepository;
import com.fasttrack.service.ProductCSVReader;
import com.fasttrack.service.ProductSearchHistoryCSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository repo;
	
	@Autowired
	ProductSearchHistoryRepository pshRepo;
	
	
	@RequestMapping(value = "/UPC", method = RequestMethod.POST)
	public ModelAndView findProductByUPC(@RequestParam(value = "upcsearch") String UPC, ModelAndView mav) {
		Product product = repo.findByUPC(UPC);	
		
		mav.addObject("SKUCount", repo.findAll().size());
		mav.addObject("lastImport", pshRepo.findTop1ByOrderBySearchDateDesc().getSearchDate());
		
		if (product != null) {
			ProductSearchHistory psh = new ProductSearchHistory();
			psh.setUPC(product.getUPC());
			psh.setReturnQuantity(product.getReturnQuantity());
			psh.setSeller(product.getSeller());
			psh.setItemBrand(product.getItemBrand());
			psh.setToDo(product.getToDo());
			psh.setSearchDate();
			
			pshRepo.save(psh);
		}
		
		List<ProductSearchHistory> searchHistory = pshRepo.findBySearchDate(LocalDate.now());

		mav.addObject("SearchHistory", searchHistory);
		mav.setViewName("product");
		
		return mav;
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView product(ModelAndView mav) {
		
		mav.setViewName("product");
		long numProductRecords = repo.findAll().size();
		mav.addObject("SKUCount", numProductRecords);
		if (numProductRecords > 0) {
			mav.addObject("lastImport", repo.findTop1ByOrderByImportDateDesc().getImportDate());
		}
		else {
			mav.addObject("lastImport", "No data available");
		}

		
		return mav;
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public ModelAndView processUpload(@RequestParam("file") MultipartFile csv, ModelAndView mav) throws IOException {
	    String message;    
	    
	    List<Product> products = new ArrayList<Product>();
		
		if (!csv.isEmpty()) {
			products = ProductCSVReader.getProductsFromCSV(csv);
			
			repo.save(products);
	        	
	        message = "CSV Uploaded";
	    }
	        
	    else {
	        message = "No Data Found";
	    }
		
	    mav.addObject("SKUCount", repo.findAll().size());
	    mav.addObject("lastImport", repo.findTop1ByOrderByImportDateDesc().getImportDate());
	    mav.addObject("message", message);
	    mav.setViewName("product");
	        
	    return mav;     	        
	}
	
	
	@RequestMapping(value="/downloadCSV", method=RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFile() throws IOException  {

	    List<ProductSearchHistory> pshList = pshRepo.findBySearchDate(LocalDate.now());
	    
	    String exportName = "ProductSearchHistory" + LocalDate.now().toString() + ".csv";
	    
	    String csv = ProductSearchHistoryCSVWriter.WriteProductSearchHistoryCSV(pshList); 

	    byte[] file = csv.getBytes();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("text/plain"));
	    headers.setContentDispositionFormData(exportName, exportName);
	    ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(file, headers, HttpStatus.OK);
	    
	    return re;
	}
	
}
