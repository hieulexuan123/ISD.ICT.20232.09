package views.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
public class FXMLScreenHandler {
	protected FXMLLoader loader;
    protected VBox content;

    public FXMLScreenHandler(String screenPath) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource(screenPath));
        // Set this class as the controller
        this.loader.setController(this);
        this.content = (VBox) loader.load();
    }
    
    public VBox getContent() {
        return this.content;
    }
    
    public FXMLLoader getLoader() {
        return this.loader;
    }

    /**
     * This is a set image operation.
     */
    public void setImage(ImageView imv, String path) {
        File file = new File(path);
        Image img = new Image(file.toURI().toString());
        imv.setImage(img);
    }

}
