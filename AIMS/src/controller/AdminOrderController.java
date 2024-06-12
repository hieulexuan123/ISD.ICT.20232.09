package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.DAOFactory;
import dao.IMediaDAO;
import dao.IOrderDAO;
import entity.order.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Config;
import views.screen.BaseScreen;
import views.screen.admin.AdminMediaScreen;
import views.screen.admin.AdminOrderScreen;

public class AdminOrderController extends BaseController{
	private IOrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
	
	public AdminOrderController() {
		// TODO Auto-generated constructor stub
	}
	
	public void requestMediaScreen(BaseScreen prevScreen) {
		try {
			AdminMediaScreen adminMediaScreen = new AdminMediaScreen(Config.ADMIN_MEDIA_SCREEN_PATH);
			adminMediaScreen.setStage(prevScreen.getStage());
			adminMediaScreen.setController(new AdminMediaController());
			adminMediaScreen.setHomeScreen(prevScreen.getHomeScreen());
			adminMediaScreen.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ObservableList<Order> getAllOrder() throws SQLException {
		return FXCollections.observableArrayList(orderDAO.getAllOrder());
	}
	
	public void changeOrderStatusById(int id, String status ) throws SQLException {
		orderDAO.changeOrderStatusById(id, status);
	}
	

}
