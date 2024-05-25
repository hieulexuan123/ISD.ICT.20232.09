package entity.order;

import java.util.List;

import entity.cart.CartMedia;
import entity.shipping.DeliveryInfo;

public class Order {
	private List<CartMedia> cartMediaList;
	private int shippingFee;
	private int costNoVAT;
	private int costVAT;
	private int totalCost;
	private DeliveryInfo info;
	public Order(List<CartMedia> cartMediaList, int shippingFee, int costNoVAT, int costVAT, int totalCost,
			DeliveryInfo info) {
		super();
		this.cartMediaList = cartMediaList;
		this.shippingFee = shippingFee;
		this.costNoVAT = costNoVAT;
		this.costVAT = costVAT;
		this.totalCost = totalCost;
		this.info = info;
	}
	public List<CartMedia> getCartMediaList() {
		return cartMediaList;
	}
	public void setCartMediaList(List<CartMedia> cartMediaList) {
		this.cartMediaList = cartMediaList;
	}
	public int getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}
	public int getCostNoVAT() {
		return costNoVAT;
	}
	public void setCostNoVAT(int costNoVAT) {
		this.costNoVAT = costNoVAT;
	}
	public int getCostVAT() {
		return costVAT;
	}
	public void setCostVAT(int costVAT) {
		this.costVAT = costVAT;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public DeliveryInfo getInfo() {
		return info;
	}
	public void setInfo(DeliveryInfo info) {
		this.info = info;
	}
	
	
}
