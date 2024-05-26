import java.io.IOException;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.media.Media;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.components.CartItemView;
import views.screen.HomeScreen;
import views.screen.cart.CartScreen;

public class AIMS extends Application{
	@FXML
	Button cartBtn;
	
	Stage window;
	Scene cartScene;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Open home screen
//    	window = stage;
//        stage.setTitle("Home page");
//        //create cart scene
//        AnchorPane cartRoot = FXMLLoader.load(getClass().getResource("/views/fxml/cart_screen.fxml"));
//        cartRoot.getChildren();
//        cartScene = new Scene(cartRoot, 1280, 720);
//        //button navigating to cart scene
//        cartBtn = new Button();
//        cartBtn.setText("Cart");
//        cartBtn.setOnAction(e -> window.setScene(cartScene));
//       
//        
//        StackPane layout = new StackPane();
//        layout.getChildren().add(cartBtn);
//        
//        Scene scene = new Scene(layout, 400, 200);
//        stage.setScene(scene);
//        stage.show();
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("views/fxml/cart_screen.fxml"));
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    		
        
        
        
        
    }
    
    
    
   
    

}
