package entity.order;

import java.util.List;

import entity.cart.CartMedia;
import entity.shipping.DeliveryInfo;

public class Order {
	private List<CartMedia> mediaList;
	private int shippingFee;
	private int costNoVAT;
	private int costVAT;
	private int totalCost;
	private DeliveryInfo info;
	public Order(List<CartMedia> mediaList, int costNoVAT, int costVAT) {
		this.mediaList = mediaList;
		this.costNoVAT = costNoVAT;
		this.costVAT = costVAT;
	}
	public List<CartMedia> getMediaList() {
		return mediaList;
	}
	public void setCartMediaList(List<CartMedia> mediaList) {
		this.mediaList = mediaList;
	}
	public int getShippingFee() {
		return shippingFee;
	}
	public int getCostNoVAT() {
		return costNoVAT;
	}
	public int getCostVAT() {
		return costVAT;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public DeliveryInfo getInfo() {
		return info;
	}
	public void setInfo(DeliveryInfo info) {
		this.info = info;
		if (info.isRush()) shippingFee = calculateRushShippingFee(info.getProvince());
		else shippingFee = calculateNormalShippingFee(info.getProvince());
		totalCost = calculateTotal(shippingFee);
	}
	
	@Override
	public String toString() {
		return "Order [mediaList=" + mediaList + ", shippingFee=" + shippingFee + ", costNoVAT=" + costNoVAT
				+ ", costVAT=" + costVAT + ", totalCost=" + totalCost + ", info=" + info.toString() + "]";
	}
	public int calculateNormalShippingFee(String province) {
		if (province == null) return 0;
		else if (province.toLowerCase().contains("hà nội") || province.toLowerCase().contains("hồ chí minh")) {
			return 30;
		}
		else return 20;
	}
	
	public int calculateRushShippingFee(String province) {
		if (province == null) return 0;
		return 50;
	}
	
	public int calculateTotal(int shippingFee) {
		return costVAT + shippingFee;
	}
	
	public static int getNumberOfRushShippingProduct(List<CartMedia> cartMediaList){
        int count = 0;
        for(CartMedia cm : cartMediaList){
            if(cm.getMedia().isSupportRushShipping()) count++;
        }
        return count;
    }
	
}
