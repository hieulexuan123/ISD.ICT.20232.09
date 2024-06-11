package dao.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import dao.IMediaDAO;
import entity.media.Media;

public class SqliteMediaDAO implements IMediaDAO{
	private Connection connection;

	public SqliteMediaDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Media> getAllMedia() throws SQLException {
		String query = "select * from Media";
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery(query);
		List<Media> mediaList = new ArrayList();
		while (res.next()) {
			int id = res.getInt("id");
            String title = res.getString("title");
            String category = res.getString("category");
            int value = res.getInt("value");
            int price = res.getInt("price");
            int quantity = res.getInt("quantity");
            String imageUrl = res.getString("image_url");
            boolean isSupportRushShipping = res.getInt("is_rush_support") == 1;
            int weight = res.getInt("weight");
            
            Media media = new Media(id, title, category, price, value, quantity, imageUrl, isSupportRushShipping, weight);
            mediaList.add(media);
		}
		return mediaList;
	}
	
	@Override
	public void deleteMediaById(int id) throws SQLException {
		String query = "delete from media where id = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}

	@Override
	public Media getMediaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
