package Resourceserver;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	private Integer id;
	private String token;
	private double totalPrice;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer id) {
		super();
		this.id = id;
	}
	public Order(Integer id, String token, double totalPrice) {
		super();
		this.id = id;
		this.token = token;
		this.totalPrice = totalPrice;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
