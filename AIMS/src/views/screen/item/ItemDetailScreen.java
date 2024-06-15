package views.screen.item;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.HomeController;
import controller.ItemController;
import entity.cart.Cart;
import entity.media.Media;
import exception.MediaUnavailableException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Config;
import utils.CurrencyFormatter;
import views.screen.BaseScreen;
import views.screen.home.HomeScreen;
import views.screen.popup.PopupScreen;

public class ItemDetailScreen extends BaseScreen{

	private Media media;
	private Cart cart;
	@FXML
	protected Label numMediaInCart;
	@FXML
    protected ImageView mediaImage;

    @FXML
    protected Label title;

    @FXML
    protected Label price;
    
    @FXML
    protected Label category;

    @FXML
    protected Label avail;

    @FXML
    protected Button addToCartBtn;
	@FXML
	private Button backBtn;
	
	public ItemDetailScreen(String screenPath, Media media, Cart cart) throws IOException {
		super(screenPath);
		this.media = media;
		this.cart = cart;
		// TODO Auto-generated constructor stub
		setController(new ItemController());
		//set number in cart
		setMediaNumberInCart();
		
		//add item to cart
		addToCartBtn.setOnMouseClicked(event -> {
            try {
            	ItemController itemController = (ItemController)super.getController();
            	if (media.getQuantity() <= 0) throw new MediaUnavailableException("Not enough " + media.getTitle());
                
            	//add media to cart
            	itemController.addMediaToCart(cart, media);
            	//set number of media in cart
            	setMediaNumberInCart();
            	//update quantity remaining of media in store
            	//updateRemainingQuantity(media);
            	System.out.println(cart.getMediaList().size());
                avail.setText(String.valueOf(media.getQuantity()));
                PopupScreen.success("The media " + media.getTitle() + " added to Cart");
            } catch (MediaUnavailableException e) {
                try {
					PopupScreen.error(e.getMessage());
				} catch (IOException e1) {
					e1.printStackTrace();
				}                
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
		setMediaInfo();
	}
	
	private void setMediaInfo(){
		System.out.println("AIMS/"+media.getImageURL());
		
		//if any error, refactor parameter of file for correct link to image.
        File file = new File("AIMS/"+media.getImageURL());
        Image image = new Image(file.toURI().toString());
        mediaImage.setFitHeight(500);
        mediaImage.setFitWidth(400);
        mediaImage.setImage(image);
        
        
        title.setText(media.getTitle());
        price.setText(CurrencyFormatter.format(media.getPrice()));
        category.setText(media.getCategory());
        avail.setText(String.valueOf(media.getQuantity()));
    }
	
	private void setMediaNumberInCart() {
		System.out.println("add to cart");
		numMediaInCart.setText(String.valueOf(cart.getMediaList().size()) + " media");
	}
	
	@FXML
	private void handleBackToHome() {
		homeScreen.show();
	}

}
