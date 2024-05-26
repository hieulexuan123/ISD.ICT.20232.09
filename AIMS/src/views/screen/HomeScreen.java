package views.screen;


import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.screen.cart.CartScreen;

public class HomeScreen extends BaseScreen implements Initializable{
	@FXML
	private Button cartBtn;
	public HomeScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cartBtn.setOnMouseClicked(e -> {
            CartScreen cartScreen;
            try {
                //cartScreen = new CartScreen(this.stage, "views/fxml/cart_screen.fxml");
                //cartScreen.setHomeScreenHandler(this);
                //cartScreen.setBController(new ViewCartController());
                //cartScreen.requestToViewCart(this);
            } catch (Exception e1) {
                //throw new Exception(Arrays.toString(e1.getStackTrace()).replaceAll(", ", "\n"));
            }
        });
	}

}
