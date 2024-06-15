package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.DAOFactory;
import dao.IMediaDAO;
import entity.media.Media;
import entity.media.category.SpecificMedia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Config;
import views.screen.BaseScreen;
import views.screen.admin.AdminOrderScreen;
import views.screen.admin.AdminUserScreen;
import views.screen.admin.create.*;

public class AdminMediaController extends BaseController{
	private IMediaDAO mediaDAO = DAOFactory.getInstance().getMediaDAO();

	public ObservableList<Media> getAllMedia() throws SQLException {
		return FXCollections.observableArrayList(mediaDAO.getAllMedia());
	}

	public void deleteMedia(Media media) throws SQLException {
		mediaDAO.deleteMediaById(media.getId());
		media.getSpecificMedia().getSpecificMediaDAO().deleteByMediaId(media.getId());
	}
	
	public void requestCreateMedia(BaseScreen prevScreen) {
		MediaCreateScreen mediaCreateScreen;
		try {
			mediaCreateScreen = new MediaCreateScreen(Config.MEDIA_CREATE_SCREEN_PATH);
			mediaCreateScreen.setController(this);
			mediaCreateScreen.setStage(prevScreen.getStage());
			mediaCreateScreen.setPrevScreen(prevScreen);
			mediaCreateScreen.setHomeScreen(prevScreen);
			mediaCreateScreen.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void requestCreateSpecificMedia(Media media, BaseScreen prevScreen) {
		try {
			SpecificMediaCreateScreen specificMediaCreateScreen = media.getSpecificMedia().getCreateScreen();
			specificMediaCreateScreen.setController(this);
			specificMediaCreateScreen.setStage(prevScreen.getStage());
			specificMediaCreateScreen.setPrevScreen(prevScreen);
			specificMediaCreateScreen.setHomeScreen(prevScreen.getHomeScreen());
			specificMediaCreateScreen.setMedia(media);
			specificMediaCreateScreen.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createMedia(Media media) {
		try {
			int mediaId = mediaDAO.createMedia(media);
			SpecificMedia specificMedia = media.getSpecificMedia();
			specificMedia.setMediaId(mediaId);
			specificMedia.getSpecificMediaDAO().create(specificMedia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void requestOrderScreen(BaseScreen prevScreen) {
		try {
			AdminOrderScreen adminOrderScreen = new AdminOrderScreen(Config.ADMIN_ORDER_SCREEN_PATH);
			adminOrderScreen.setStage(prevScreen.getStage());
			adminOrderScreen.setController(new AdminOrderController());
			adminOrderScreen.setHomeScreen(prevScreen.getHomeScreen());
			adminOrderScreen.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

    public void requestUserScreen(BaseScreen prevScreen) {
		try {
			AdminUserScreen userScreen = new AdminUserScreen(Config.ADMIN_USER_SCREEN_PATH);
			userScreen.setController(new AdminUserController());
			userScreen.setHomeScreen(prevScreen.getHomeScreen());
			userScreen.setStage(prevScreen.getStage());
			userScreen.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
