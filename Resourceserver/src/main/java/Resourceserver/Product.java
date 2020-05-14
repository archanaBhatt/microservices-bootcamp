package Resourceserver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private Integer id;
	private String name;
	private String shortDescription;
	private String category;
	private double mrp;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer id) {
		super();
		this.id = id;
	}
	public Product(Integer id, String name, String shortDescription, String category, double mrp) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.category = category;
		this.mrp = mrp;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String  getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	
}
