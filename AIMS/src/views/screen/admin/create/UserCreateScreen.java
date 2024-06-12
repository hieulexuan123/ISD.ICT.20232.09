package views.screen.admin.create;

import controller.AdminUserController;
import entity.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import views.screen.BaseScreen;

import java.io.IOException;


public class UserCreateScreen extends BaseScreen {
    @FXML
    private VBox form;

    @FXML
    private Label formTitle;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textName;

    @FXML
    private TextField textPhone;

    @FXML
    void handleCancelAction(ActionEvent event) {
        prev.show();
    }

    @FXML
    void handleSaveAction(ActionEvent event) {
        try {
            User user = new User(textName.getText(), textEmail.getText(), textPhone.getText());
            getController().createUser(user);
            homeScreen.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public UserCreateScreen(String screenPath) throws IOException {
        super(screenPath);
    }

    @Override
    public AdminUserController getController(){
        return (AdminUserController) super.getController();
    }
}
