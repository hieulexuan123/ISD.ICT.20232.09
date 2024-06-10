package views.screen.home;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.media.Media;
import exception.MediaUnavailableException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.CurrencyFormatter;
import views.screen.FXMLScreen;
import views.screen.popup.PopupScreen;

public class HomeItemScreen extends FXMLScreen{
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
    
    private Media media;
    private HomeScreen homeScreen;
    private Cart cart;

    public HomeItemScreen(String screenPath, Media media, HomeScreen homeScreen, Cart cart) throws SQLException, IOException{
        super(screenPath);
        this.media = media;
        this.homeScreen = homeScreen;
        this.cart = cart;
        
        addToCartBtn.setOnMouseClicked(event -> {
            try {
            	if (media.getQuantity() <= 0) throw new MediaUnavailableException("Not enough " + media.getTitle());
                
            	homeScreen.getController().addMediaToCart(cart, media);
            	homeScreen.updateNumMediaInCart();
                avail.setText(String.valueOf(media.getQuantity()));
                //home.getNumMediaCartLabel().setText(String.valueOf(cart.getTotalMedia() + " media"));
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
        File file = new File(media.getImageURL());
        Image image = new Image(file.toURI().toString());
        mediaImage.setFitHeight(160);
        mediaImage.setFitWidth(152);
        mediaImage.setImage(image);
        
        System.out.println(media.toString());
        title.setText(media.getTitle());
        price.setText(CurrencyFormatter.format(media.getPrice()));
        category.setText(media.getCategory());
        avail.setText(String.valueOf(media.getQuantity()));
    }
}
