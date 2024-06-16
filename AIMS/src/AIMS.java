import entity.cart.Cart;
import controller.PayOrderController;
import dao.*;
import dao.sqlite.SqliteDAOFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import subsystem.vnpay.VNPayController;
import utils.Config;
import views.screen.home.HomeScreen;
import views.screen.payment.PaymentResultScreen;
import views.screen.cart.CartScreen;
import views.screen.*;

public class AIMS extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	try {
        	DAOFactory.initialize(new SqliteDAOFactory());
        	  PayOrderController payOrderController = new PayOrderController();
        		VNPayController vnpayController = new VNPayController(payOrderController); 
        	         int amount=1000*1000;
					String content="kjgkdfjgkfjkgjf";
					vnpayController.payOrder(amount, content);
        	
//			Cart cart = Cart.createCart();
//            BaseScreen cartScreen = new CartScreen(Config.CART_SCREEN_PATH, cart);
//            cartScreen.show();
//        	HomeScreen homeScreen = new HomeScreen(Config.HOME_SCREEN_PATH);
//        	homeScreen.setHomeScreen(homeScreen);
//        	homeScreen.setStage(stage);
//        	homeScreen.show();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
