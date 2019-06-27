package com.lrfNetwork.Info;

public class Goods {
	public Goods(Integer id, String name, String type, Integer save, double price, String size, String date,
			String manufacture, Integer period) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.save = save;
		this.price = price;
		this.size = size;
		this.date = date;
		this.manufacture = manufacture;
		this.period = period;
	}
	private Integer id;
	private String name;
	private String type;
	private Integer save;
	private double price;
	private String size;
	private String date;
	private String manufacture;
	private Integer period;
	
	
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public Integer getSave() {
		return save;
	}
	public double getPrice() {
		return price;
	}
	public String getSize() {
		return size;
	}
	public String getDate() {
		return date;
	}
	public String getManufacture() {
		return manufacture;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSave(Integer save) {
		this.save = save;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
}
