package com.fasttrack.service;

import java.util.List;
import com.fasttrack.model.ProductSearchHistory;

public class ProductSearchHistoryCSVWriter {

	public static String WriteProductSearchHistoryCSV(List<ProductSearchHistory> pshList) {
		
		StringBuffer sb = new StringBuffer();
		
		
		sb.append("UPC" + "," + "Return Quantity"  + "," +  "Seller" + "," +  "Item Brand" + ","
				+ "To Do" + "," +  "Search Date");
		sb.append(System.getProperty("line.separator"));
		
		for (ProductSearchHistory psh : pshList) {
			sb.append(psh.getUPC() + "," + String.valueOf(psh.getReturnQuantity()) + ","
					+ psh.getSeller() + "," + psh.getItemBrand() + "," + psh.getToDo() + ","
					+ psh.getSearchDate().toString());
			sb.append(System.getProperty("line.separator"));
		}
		
		return sb.toString();
	}
}
