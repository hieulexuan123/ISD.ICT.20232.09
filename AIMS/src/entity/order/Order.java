package entity.order;

import java.util.List;

import entity.cart.CartMedia;
import entity.shipping.DeliveryInfo;

public class Order {
	private List<CartMedia> cartMediaList;
	private double shippingFee;
	private double costNoVAT;
	private double costVAT;
	private double totalCost;
	private DeliveryInfo info;
	public Order(List<CartMedia> cartMediaList, double shippingFee, double costNoVAT, double costVAT,
			DeliveryInfo info) {
		super();
		this.cartMediaList = cartMediaList;
		this.shippingFee = shippingFee;
		this.costNoVAT = costNoVAT;
		this.costVAT = costVAT;
		this.totalCost = costVAT+shippingFee;
		this.info = info;
	}
	public List<CartMedia> getCartMediaList() {
		return cartMediaList;
	}
	public void setCartMediaList(List<CartMedia> cartMediaList) {
		this.cartMediaList = cartMediaList;
	}
	public double getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}
	public double getCostNoVAT() {
		return costNoVAT;
	}
	public void setCostNoVAT(double costNoVAT) {
		this.costNoVAT = costNoVAT;
	}
	public double getCostVAT() {
		return costVAT;
	}
	public void setCostVAT(double costVAT) {
		this.costVAT = costVAT;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public DeliveryInfo getInfo() {
		return info;
	}
	public void setInfo(DeliveryInfo info) {
		this.info = info;
	}
	
	
}
