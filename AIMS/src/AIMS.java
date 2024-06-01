import entity.cart.Cart;
import entity.cart.CartMedia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Config;
import views.screen.BaseScreen;
import views.screen.cart.CartScreen;


public class AIMS extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	BaseScreen.setStage(stage);
    	Cart cart = Cart.createCart();
        BaseScreen cartScreen = new CartScreen(Config.CART_SCREEN_PATH, cart);
        cartScreen.show();
    }
}
