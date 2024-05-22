package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.order.Order;
import entity.shipping.DeliveryInfo;
import views.screen.BaseScreen;

public class PlaceOrderController extends BaseController{
	public void placeOrder(BaseScreen screen, Cart cart) {
		//cart.checkProductAvai();
		//call shipping screen
	}
	
	public void validateDeliveryInfo(DeliveryInfo info) {
		//info.validateInfo()
	}
	
	public void validateRushShipping(String province, List<CartMedia> cartMediaList) throws Exception{
		
    }
	
	public int calculateShippingFee(String province, List<CartMedia> cartMediaList, boolean isRush) {
		return 0;
	}
	
	public void requestInvoice(Order order) {
		//call invoice screen
	}
	
	public void payOrder() {
		//call payment screen
	}
}
