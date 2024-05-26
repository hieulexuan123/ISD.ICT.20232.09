package subsystem.vnpay;

import java.io.IOException;

import javafx.stage.Stage;
import views.screen.BaseScreen;

public class VNPayScreen extends BaseScreen{
	public VNPayScreen(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
		// TODO Auto-generated constructor stub
	}

	public void displayWeb(String url) {
		
	}
	
	private void handleUrlChanged(String newUrl) {
		//getController().processResponse(query);
	}
}