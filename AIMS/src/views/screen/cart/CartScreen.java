package views.screen.cart;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.PlaceOrderController;
import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.media.Media;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.screen.BaseScreen;
import views.screen.shipping.ShippingScreen;

public class CartScreen implements Initializable{
	
	@FXML 
	ListView<HBox> titleListView;
	@FXML
	private Label mediaLabel;
	
	Cart cartTest;
	List<HBox> cartItem;
	List<Double> cartItemPrice;
	List<String> mediaTitle;
	
	@FXML 
	Label priceNoVAT;
	@FXML 
	Label VATcost;
	@FXML 
	Label totalPrice;
	
	double costNoVAT = 0;
	double costVAT = 0;
	public void placeOrder() {
		System.out.println("place order");
		
		PlaceOrderController controller = PlaceOrderController.GetInstance();
		
		//create cart 
		
		//functionality test with 2 Media instances
		Media m1 = new Media(1, "Avatar CD",100, 10);
		Media m2 = new Media (2, "Harry Potter CD",120, 10);
		CartMedia cm1 = new CartMedia(m1, 1);
		CartMedia cm2 = new CartMedia(m2, 2);
		
		//create test cart and add CartMedia object
		cartTest = new Cart();
		cartTest.addCartMedia(cm1);
		cartTest.addCartMedia(cm2);
		cartTest.addCartMedia(cm1);
		cartTest.addCartMedia(cm2);
		cartItem = new ArrayList<HBox>();
		
		//add components to list view
		List<CartMedia> itemList = cartTest.getListMedia(); 
		for (int i = 0; i < itemList.size(); i++) {
			CartMedia tmpItem = itemList.get(i);
			HBox hBoxTmp = new HBox();
			TextField tmp = new TextField(tmpItem.getMedia().getTitle());
			TextField quantityLabel = new TextField(Integer.toString(tmpItem.getQuantity()));
			Button deleteBtn = new Button();
			deleteBtn.setOnAction(e -> deleteItem(tmpItem, hBoxTmp));
			deleteBtn.setText("Remove");
			hBoxTmp.getChildren().add(tmp);
			hBoxTmp.getChildren().add(quantityLabel);
			hBoxTmp.getChildren().add(deleteBtn);
			//Update price
			System.out.println(tmpItem.getMedia().getPrice());
			costNoVAT += tmpItem.getMedia().getPrice();
			cartItem.add(hBoxTmp);
		}
		
		//calculate VAT cost
		costVAT = costNoVAT * 0.1;
		
		//create shipping form
		ShippingScreen ship = new ShippingScreen(cartTest.getListMedia(), costNoVAT, costVAT);
		controller.placeOrder(ship, cartTest);
//		placeOrderController.placeOrder()
	}
	
	void deleteItem(CartMedia cartItem, HBox cartItemBox) {
		costNoVAT -= cartItem.getMedia().getPrice();
		costVAT = costNoVAT * 0.1;
		titleListView.getItems().remove(cartItemBox);
		priceNoVAT.setText(Double.toString(costNoVAT));
		VATcost.setText(Double.toString(costVAT));
		totalPrice.setText(Double.toString( costVAT));
		
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		placeOrder();
		titleListView.getItems().addAll(cartItem);
		
		priceNoVAT.setText(Double.toString(costNoVAT));
		VATcost.setText(Double.toString(costVAT));
		totalPrice.setText(Double.toString(costVAT));
	}
	
}
