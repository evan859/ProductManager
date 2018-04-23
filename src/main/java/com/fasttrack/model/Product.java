package com.fasttrack.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "UPC")
	private String UPC;
	
	@Column(name = "Thumbnail")
	private String thumbNail;
	
	@Column(name = "Return_Quantity")
	private int returnQuantity;
	
	@Column(name = "Seller")
	private String seller;
	
	@Column(name = "Item_Brand")
	private String itemBrand;
	
	@Column(name = "Item_Desc")
	private String itemDescription;
	
	@Column(name = "Amount")
	private double amount;
	
	@Column(name = "Model")
	private String model;
	
	@Column(name = "Load_Number")
	private int loadNumber;
	
	@Column(name = "Width")
	private Double width;
	
	@Column(name = "Depth")
	private Double depth;
	
	@Column(name = "Weight")
	private Double weight;
	
	@Column(name = "Import_Date")
	private LocalDate importDate;
	
	
	
	public LocalDate getImportDate() {
		return importDate;
	}

	public void setImportDate(LocalDate importDate) {
		this.importDate = importDate;
	}

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		UPC = uPC;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
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

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getLoadNumber() {
		return loadNumber;
	}

	public void setLoadNumber(int loadNumber) {
		this.loadNumber = loadNumber;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getDepth() {
		return depth;
	}

	public void setDepth(Double depth) {
		this.depth = depth;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	@Column(name = "Height")
	private double height;
	
	@Column(name = "Additional_Info")
	private String additionalInfo;
	
	@Column(name = "To_Do")
	private String toDo;
	
}
