package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.order.Order;
import entity.shipping.DeliveryInfo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.screen.BaseScreen;
import views.screen.invoice.InvoiceScreen;

public class PlaceOrderController extends BaseController{
	private static PlaceOrderController controllerInstance;
	public static PlaceOrderController GetInstance() {
		if (controllerInstance == null) {
			controllerInstance = new PlaceOrderController();
		}
		return controllerInstance;
		
	}
	public void placeOrder(BaseScreen screen, Cart cart) {
		//cart.checkProductAvai();
		try {
			cart.checkProductAvai();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//call shipping screen
	}
	
	public boolean validateDeliveryInfo(DeliveryInfo info) throws Exception {
		if (info.validateInfo()) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public void validateRushShipping(String city, List<CartMedia> cartMediaList) throws Exception{
		
    }
	
	public int calculateShippingFee(String city, List<CartMedia> cartMediaList, boolean isRush) {
		if (isRush) {
			return 200;
		}
		else {
			return 100;		}
	}
	
	public void requestInvoice(Order order) {
        try {
            // Load the InvoiceScreen.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("views/fxml/invoice_screen.fxml"));
            Parent root = loader.load();
            
            // Get the controller instance
            InvoiceScreen invoiceController = loader.getController();

            // Set up the stage and scene
            Stage invoiceStage = new Stage();
            invoiceStage.setTitle("Invoice");
            invoiceStage.setScene(new Scene(root));

            // Show the invoice screen
            invoiceStage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
        }
    }
	
	public void payOrder() {
		//call payment screen
	}
}
