package views.screen.invoice;

import entity.order.Order;
import views.screen.BaseScreen;
import javafx.event.ActionEvent;

//public class InvoiceScreen extends BaseScreen{
//	private Order order;
//	public void payOrder() {
//		//PayOrderController payOrderController = new PayOrderController()
//		//payOrderController.payOrder(screen)
//	}
//}

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InvoiceScreen {
	
	public InvoiceScreen(Order order) {
		this.order = order;
	}

    @FXML
    private Label labelAddress;

    @FXML
    private Label labelCity;

    @FXML
    private Label labelInstruction;

    @FXML
    private Label labelName;

    @FXML
    private Label labelPhone;

    @FXML
    private Label labelShippingFee;

    @FXML
    private Label labelSubTotal;

    @FXML
    private Label labelTotal;

    @FXML
    private VBox viewItems;
    
	private Order order;
	public void payOrder() {
		//PayOrderController payOrderController = new PayOrderController()
		//payOrderController.payOrder(screen)
	}
	@FXML
    private void initialize() {
		labelName.setText(order.getInfo().getName());
        labelAddress.setText(order.getInfo().getAddress());
        labelCity.setText(order.getInfo().getCity());
        labelPhone.setText(order.getInfo().getPhone());
        labelInstruction.setText(order.getInfo().getNote());
        labelSubTotal.setText(Integer.toString(order.getCostNoVAT()+order.getCostVAT()));
        labelShippingFee.setText(Integer.toString(order.getShippingFee()));
        labelTotal.setText(Integer.toString(order.getTotalCost()));
        
    }
	@FXML
    void handleConfirmOrder(ActionEvent event) {
		// go to PayOrder 
    }

}
