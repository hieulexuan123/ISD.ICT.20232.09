package views.screen.shipping;

import java.io.File;
import java.io.IOException;

import entity.cart.CartMedia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class OrderItemScreen {

	    @FXML
	    private ImageView image;

	    @FXML
	    private Label title;

	    @FXML
	    private Label numOfProd;

	    @FXML
	    private Label price;
	    
	    @FXML
	    private Label rushEligibility;
	    
	    private CartMedia orderMedia;
	    private FXMLLoader loader;
		private AnchorPane root;
		private boolean isRush;
	    
	    public OrderItemScreen(String screenPath, CartMedia orderMedia, boolean isRush) throws IOException {
			this.loader = new FXMLLoader(getClass().getResource(screenPath));
			this.loader.setController(this);
			this.root = (AnchorPane) loader.load();
			
			this.orderMedia = orderMedia;
			this.isRush = isRush;
			setMediaInfo();
		}
	    
	    public AnchorPane getRoot() {
			return this.root;
		}
	    
	    private void setMediaInfo() {
	    	title.setText(orderMedia.getMedia().getTitle());
	        price.setText(orderMedia.getPrice() + " VND");
	        numOfProd.setText("x" + orderMedia.getQuantity());
	        
	        File file = new File(orderMedia.getMedia().getImageURL());
			Image im = new Image(file.toURI().toString());
			image.setImage(im);
			image.setPreserveRatio(false);
			image.setFitHeight(90);
			image.setFitWidth(83);
			
			rushEligibility.setVisible(isRush && orderMedia.getMedia().isSupportRushShipping());
	    }
}
