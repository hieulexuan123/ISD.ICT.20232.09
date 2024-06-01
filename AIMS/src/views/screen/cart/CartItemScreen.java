package views.screen.cart;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Logger;

import entity.cart.Cart;
import entity.cart.CartMedia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CartItemScreen{	
	@FXML
	protected HBox hboxMedia;

	@FXML
	protected ImageView image;

	@FXML
	protected VBox description;

	@FXML
	protected Label labelOutOfStock;

	@FXML
	protected VBox spinnerFX;

	@FXML
	protected Label title;

	@FXML
	protected Label price;

	@FXML
	protected Label currency;

	@FXML
	protected Button btnDelete;
	
	private FXMLLoader loader;
	private AnchorPane root;
	private CartMedia cartMedia;
	private Spinner<Integer> spinner;
	private CartScreen cartScreen;

	public CartItemScreen(String screenPath, CartScreen cartScreen) throws IOException {
		this.loader = new FXMLLoader(getClass().getResource(screenPath));
		this.loader.setController(this);
		this.root = (AnchorPane) loader.load();
		
		this.cartScreen = cartScreen;
		hboxMedia.setAlignment(Pos.CENTER);
	}
	
	public void setCartMedia(CartMedia cartMedia) {
		this.cartMedia = cartMedia;
		setMediaInfo();
	}
	
	public AnchorPane getRoot() {
		return this.root;
	}


	private void setMediaInfo() {
		title.setText(cartMedia.getMedia().getTitle());
		price.setText(cartMedia.calculateTotal() + " VND");
		File file = new File(cartMedia.getMedia().getImageURL());
		Image im = new Image(file.toURI().toString());
		image.setImage(im);
		image.setPreserveRatio(false);
		image.setFitHeight(110);
		image.setFitWidth(92);

		// add delete button
		btnDelete.setOnMouseClicked(e -> {
			cartScreen.getCart().removeCartMedia(cartMedia); // update user cart
			cartScreen.updateCart(); // re-display user cart
		});

		initializeSpinner();
	}

	private void initializeSpinner(){
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, cartMedia.getQuantity());
		spinner = new Spinner<Integer>(valueFactory);
		spinner.setOnMouseClicked( e -> {
			int numOfProd = this.spinner.getValue();
			int remainQuantity = cartMedia.getMedia().getQuantity();
			if (numOfProd > remainQuantity){
				labelOutOfStock.setText("Sorry, Only " + remainQuantity + " remain in stock");
				spinner.getValueFactory().setValue(remainQuantity);
				numOfProd = remainQuantity;
			}

			// update quantity of cartMedia
			cartMedia.setQuantity(numOfProd);

			// update the total of mediaCart
			price.setText(cartMedia.calculateTotal() + " VND");

			// update subtotal and amount of Cart
			cartScreen.updateCartCost();
			
		});
		spinnerFX.setAlignment(Pos.CENTER);
		spinnerFX.getChildren().add(this.spinner);
	}
}

