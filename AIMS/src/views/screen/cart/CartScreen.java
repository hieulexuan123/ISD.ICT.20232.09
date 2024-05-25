package views.screen.cart;

import controller.PlaceOrderController;
import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.media.Media;
import views.screen.BaseScreen;
import views.screen.shipping.ShippingScreen;

public class CartScreen extends BaseScreen{
	
	public void placeOrder() {
		double costNoVAT = 0;
		double costVAT = 0;
		PlaceOrderController controller = PlaceOrderController.GetInstance();
		
		//create cart 
		//functionality test with 2 Media instances
		Media m1 = new Media(1, "Avatar CD",100, 10);
		Media m2 = new Media (2, "Harry Potter CD",120, 10);
		CartMedia cm1 = new CartMedia(m1, 1);
		CartMedia cm2 = new CartMedia(m2, 2);
		//create test cart and add CartMedia object
		Cart cartTest = new Cart();
		cartTest.addCartMedia(cm1);
		cartTest.addCartMedia(cm2);
		
		//calculate cost without VAT
		for (CartMedia item : cartTest.getListMedia()) {
			costNoVAT += item.getMedia().getPrice();
		}
		//calculate cost with VAT
		costVAT = costNoVAT * 1.1;
		
		ShippingScreen ship = new ShippingScreen(cartTest.getListMedia(), costNoVAT, costVAT);
		controller.placeOrder(ship, cartTest);
		//placeOrderController.placeOrder()
	}
}
