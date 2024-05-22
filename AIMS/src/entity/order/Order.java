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
}
