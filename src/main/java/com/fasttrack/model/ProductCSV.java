package com.fasttrack.model;

import com.opencsv.bean.CsvBindByName;


public class ProductCSV {
	
	@CsvBindByName(column = "UPC", required = true)
	private String UPC;
	
	@CsvBindByName(column = "Thumbnail")
	private String thumbNail;
		
	@CsvBindByName(column = "Return Quantity")
	private int returnQuantity;
		
	@CsvBindByName(column = "Seller")
	private String seller;
		
	@CsvBindByName(column = "Item Brand")
	private String itemBrand;
		
	@CsvBindByName(column = "Item Desc")
	private String itemDescription;
		
	@CsvBindByName(column = "Amount")
	private double amount;
		
	@CsvBindByName(column = "Model")
	private String model;
	
	@CsvBindByName(column = "Load #")
	private int loadNumber;
		
	@CsvBindByName(column = "Width")
	private Double width;
		
	@CsvBindByName(column = "Depth")
	private Double depth;
		
	@CsvBindByName(column = "Height")
	private double height;
	
	@CsvBindByName(column = "Weight")
	private double weight;
		
	@CsvBindByName(column = "Additional Info")
	private String additionalInfo;
		
	@CsvBindByName(column = "To Do:")
	private String toDo;

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

	public double getAmount() {
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

	public void setHeight(double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
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
}
