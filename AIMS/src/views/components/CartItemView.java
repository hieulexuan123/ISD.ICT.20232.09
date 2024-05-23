package views.components;

import entity.cart.CartMedia;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import views.fxml.CartItemController;

public class CartItemView {
    private HBox view;
    private final CartItemController controller;



    public CartItemView(CartMedia media){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("views/fxml/cart_item.fxml"));
            this.controller = new CartItemController();
            loader.setController(controller);
            this.controller.setMedia(media);
    }
}
