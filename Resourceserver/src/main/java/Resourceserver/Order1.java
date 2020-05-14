package Resourceserver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order1 {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderid;
	private String usertoken;
	private double orderprice;
	
	
	
	public Order1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order1(String usertoken, double orderprice) {
		super();
		//this.orderid = orderId;
		this.usertoken = usertoken;
		this.orderprice = orderprice;
	}
	public Order1(Integer orderId, String usertoken, double orderprice) {
		super();
		this.orderid = orderId;
		this.usertoken = usertoken;
		this.orderprice = orderprice;
	}
	public Integer getOrderId() {
		return orderid;
	}
	public void setOrderId(Integer orderId) {
		this.orderid = orderId;
	}
	public String getUsertoken() {
		return usertoken;
	}
	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	

}
