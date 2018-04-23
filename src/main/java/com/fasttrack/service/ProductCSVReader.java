package com.fasttrack.service;

import com.fasttrack.model.Product;
import com.fasttrack.model.ProductCSV;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductCSVReader {

	public static List<Product> getProductsFromCSV(MultipartFile csv) throws IOException {
		List<Product> products = new ArrayList<Product>();
		
		File file = new File(csv.getOriginalFilename());
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(csv.getBytes());
		fos.close();
		
		List<ProductCSV> productCSVs = new CsvToBeanBuilder<ProductCSV>(new FileReader(file)).withType(ProductCSV.class).build().parse();
		
		for (ProductCSV p : productCSVs) {
			ProductCSV productCSV = p;
			Product product = new Product();
			product.setUPC(productCSV.getUPC());
			product.setThumbNail(productCSV.getThumbNail());
			product.setReturnQuantity(productCSV.getReturnQuantity());
			product.setSeller(productCSV.getSeller());
			product.setItemBrand(productCSV.getItemBrand());
			product.setItemDescription(productCSV.getItemDescription());
			product.setAmount(productCSV.getAmount());
			product.setModel(productCSV.getModel());
			product.setLoadNumber(productCSV.getLoadNumber());
			product.setWidth(productCSV.getWidth());
			product.setDepth(productCSV.getDepth());
			product.setHeight(productCSV.getHeight());
			product.setWeight(productCSV.getWeight());
			product.setAdditionalInfo(productCSV.getAdditionalInfo());
			product.setToDo(productCSV.getToDo());
			product.setImportDate(LocalDate.now());
	
			products.add(product);
		}
			
		return products;
	}
}
