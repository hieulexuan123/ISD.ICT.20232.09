package subsystem.vnpay;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import views.screen.BaseScreen;
import subsystem.vnpay.*;

public class VNPayScreen extends BaseScreen{
	@FXML
	private Label pageTitle;
	@FXML
	private VBox vBox;
	
	private String payUrl;
	public VNPayScreen(String screenPath, String payUrl) throws IOException {
		super(screenPath);
		this.payUrl = payUrl;
	}

	public void displayWeb() {
		WebView paymentView = new WebView();
		WebEngine webEngine = paymentView.getEngine();
		webEngine.load(payUrl);
		webEngine.locationProperty().addListener((observable, oldValue, newValue) -> {
			handleUrlChanged(newValue);
		});
		vBox.getChildren().clear();
		vBox.getChildren().add(paymentView);
	}
	
	private void handleUrlChanged(String newUrl) {
		if (newUrl.contains(VNPayConfig.vnp_ReturnUrl)) {
			try {
				URI uri = new URI(newUrl);
				String query = uri.getQuery();
				System.out.println("chuỗi uri " + uri);
				System.out.println("chuỗi api" + query);
				
				((VNPayController)controller).processResponse(query);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} 		
		}
	}
}
