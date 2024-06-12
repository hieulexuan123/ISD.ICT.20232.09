package controller;

import dao.DAOFactory;
import dao.IUserDAO;
import entity.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Config;
import views.screen.BaseScreen;
import views.screen.admin.create.UserCreateScreen;

public class AdminUserController extends BaseController {
    IUserDAO userDAO = DAOFactory.getInstance().getUserDAO();

    public ObservableList<User> getAllUser() {
        return FXCollections.observableArrayList(userDAO.getAll());
    }

    public void deleteUser(User user) {
        userDAO.deleteUserById(user.getId());
    }

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public void requestCreateUser(BaseScreen prevScreen) {
        UserCreateScreen userCreateScreen;
        try {
            userCreateScreen = new UserCreateScreen(Config.USER_CREATE_SCREEN_PATH);
            userCreateScreen.setController(this);
            userCreateScreen.setStage(prevScreen.getStage());
            userCreateScreen.setPrevScreen(prevScreen);
            userCreateScreen.setHomeScreen(prevScreen);
            userCreateScreen.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
