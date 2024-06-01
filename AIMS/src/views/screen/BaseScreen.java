package views.screen;

import java.io.IOException;

import controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BaseScreen {
	protected FXMLLoader loader;
	protected AnchorPane root;
	private static Stage stage;
	protected Scene scene;
	
	protected BaseScreen prev;
	protected BaseScreen homeScreen;
	protected BaseController controller;
	
	private String screenTitle;

	public BaseScreen(String screenPath) throws IOException {
		this.loader = new FXMLLoader(getClass().getResource(screenPath));
		// Set handler
		this.loader.setController(this);
		this.root = (AnchorPane) loader.load();
	}
	
	public void show() {
		this.scene = new Scene(this.root);
		stage.setScene(this.scene);
		stage.show();
	}
	
	public BaseScreen getPrev() {
		return prev;
	}
	public void setPrevScreen(BaseScreen prev) {
		this.prev = prev;
	}
	
	public BaseController getController() {
		return controller;
	}
	public void setController(BaseController controller) {
		this.controller = controller;
	}
	
	public void setScreenTitle(String title) {
		this.screenTitle = title;
		this.stage.setTitle(title);
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage newStage) {
		stage = newStage;
	}
	
	public BaseScreen getHomeScreen() {
		return this.homeScreen;
	}
	public void setHomeScreen(BaseScreen homeScreen) {
		this.homeScreen = homeScreen;
	}
}