package views.fxml;

import entity.cart.CartMedia;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.util.List;

public class CartScreenController {
    @FXML
    private Image imageItem;

    @FXML
    private Label labelPrice;

    @FXML
    private Label labelTotal;

    @FXML
    private Label labelVAT;

    @FXML
    private VBox viewCartItems;

}
