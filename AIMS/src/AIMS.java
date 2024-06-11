import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.media.Media;

import java.util.List;

import controller.HomeController;
import dao.*;
import dao.sqlite.SqliteBookDAO;
import dao.sqlite.SqliteDAOFactory;
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
import views.screen.home.HomeScreen;
import entity.media.category.*;


public class AIMS extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	try {
        	DAOFactory.initialize(new SqliteDAOFactory());
        	Cart cart = Cart.createCart();
            //BaseScreen cartScreen = new CartScreen(Config.CART_SCREEN_PATH, cart);
            //cartScreen.show();
        	HomeScreen homeScreen = new HomeScreen(Config.HOME_SCREEN_PATH);
        	homeScreen.setStage(stage);
        	homeScreen.show();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
