package views.fxml;

import entity.cart.CartMedia;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;

public class CartItemController {
    @FXML
    Image imageItem;
    @FXML
    Label labelItemName;

    @FXML
    Label labelItemPrice;

    @FXML
    Spinner spinnerQty;

    @FXML
    Button btnRemoveItem;

    public void setMedia(CartMedia media){
        this.labelItemPrice.setText(media.getMedia().getPrice() + "");
        this.labelItemName.setText(media.getMedia().getTitle());
    }
}
