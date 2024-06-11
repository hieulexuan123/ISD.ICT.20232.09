package controller;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.IMediaDAO;
import entity.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminMediaController extends BaseController{
	private IMediaDAO mediaDAO = DAOFactory.getInstance().getMediaDAO();

	public ObservableList<Media> getAllMedia() throws SQLException {
		return FXCollections.observableArrayList(mediaDAO.getAllMedia());
	}
	
	public void deleteMediaById(int id) {
		
	}

	public void deleteMediaById(int id, String category) throws SQLException {
		mediaDAO.deleteMediaById(id);
		switch (category):
			case "book":
				bookDAO.deleteById(id);
			case "cd":
				cdDAO.deleteById(id);
	}

}
