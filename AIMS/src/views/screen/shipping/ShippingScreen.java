package views.screen.shipping;

import java.util.List;

import entity.cart.CartMedia;
import entity.shipping.DeliveryInfo;
import views.screen.BaseScreen;

public class ShippingScreen extends BaseScreen{
	private List<CartMedia> cartMediaList;
	private boolean isRush;
	double costNoVAT = 0;
	double costVAT = 0;
	
	public ShippingScreen(List<CartMedia> cartMediaList, double costNoVAT, double costVAT) {
		this.cartMediaList = cartMediaList;
		this.costNoVAT = costNoVAT;
		this.costVAT = costVAT;
		
	}
	
	public void placeRushOrder() {
		//triggered when choose rush order option
		//getController().validateRushShipping()
	}
	
	private void onHandleProvinceChange() {  
		//triggered when province is changed
		//if (isRush) {
		//getController().validateRushShipping()
		//getController().calculateShippingFee()
		//else
		//calculateShippingFee()
	}
	
	private void calculateShippingFee() {
		//... = getController().calculateShippingFee()
		//... 
	}
	
	public void requestInvoice() {
		//DeliveryInfo info = new DeliveryInfo();
		//getController().validateDeliveryInfo(info)
		//Order order = new Order()
		//getController().requestInvoice(order)
	}
}
