package com.fasttrack.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_search_history")
public class ProductSearchHistory {
	
	@Id
	@Column(name = "UPC")
	private String UPC;
	
	@Column(name = "Return_Quantity")
	private int returnQuantity;
	
	@Column(name = "Seller")
	private String seller;
	
	@Column(name = "Item_Brand")
	private String itemBrand;
	
	@Column(name = "To_Do")
	private String toDo;
	
	@Column(name = "Search_Date")
	private LocalDate searchDate;

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		UPC = uPC;
	}

	public int getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public LocalDate getSearchDate() {
		return searchDate;
	}

	public void setSearchDate() {
		this.searchDate = LocalDate.now();
	}

}
