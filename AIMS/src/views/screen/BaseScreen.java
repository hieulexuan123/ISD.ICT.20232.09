package views.screen;

import java.io.IOException;
import java.util.Hashtable;

import controller.BaseController;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BaseScreen extends FXMLScreenHandler {
	protected final Stage stage;
    //protected HomeScreenHandler homeScreenHandler;
    protected Hashtable<String, String> messages;
    private Scene scene;
    private BaseScreen prev;
    private BaseController bController;

    private BaseScreen(String screenPath) throws IOException {
        super(screenPath);
        this.stage = new Stage();
    }


    public BaseScreen(Stage stage, String screenPath) throws IOException {
        super(screenPath);
        this.stage = stage;
    }

    public BaseScreen getPreviousScreen() {
        return this.prev;
    }
    
    public void setPreviousScreen(BaseScreen prev) {
        this.prev = prev;
    }

    public void show() {
        if (this.scene == null) {
            this.scene = new Scene(this.content);
        }
        this.stage.setScene(this.scene);
        this.stage.show();
    }
    
    public void setScreenTitle(String string) {
        this.stage.setTitle(string);
    }
    
    public BaseController getBController() {
        return this.bController;
    }
    
    public void setBController(BaseController bController) {
        this.bController = bController;
    }

    public void forward(Hashtable messages) {
        this.messages = messages;
    }
    
//    public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
//        this.homeScreenHandler = HomeScreenHandler;
//    }
}
