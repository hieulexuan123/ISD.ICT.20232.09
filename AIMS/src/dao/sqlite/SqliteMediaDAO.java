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
import entity.media.category.SpecificMedia;

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
	public int createMedia(Media media) throws SQLException {
		String sql = "INSERT INTO media (title, category, value, price, quantity, image_url, is_rush_support, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, media.getTitle());
        pstmt.setString(2, media.getCategory());
        pstmt.setInt(3, media.getValue());
        pstmt.setInt(4, media.getPrice());
        pstmt.setInt(5, media.getQuantity());
        pstmt.setString(6, media.getImageURL());
        pstmt.setInt(7, media.getIsSupportRushShipping() ? 1 : 0);
        pstmt.setInt(8, media.getWeight());
        pstmt.executeUpdate();
        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int id = generatedKeys.getInt(1); 
        System.out.println("Update successfully");
        return id;
	}
	
	@Override
	public void deleteMediaById(int id) throws SQLException {
		String query = "delete from media where id = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	
	@Override
	public void updateMediaQuantity(int id, int quantity) throws SQLException {
		String query = "UPDATE Media SET quantity = ? WHERE id = ?";
	    PreparedStatement stmt = connection.prepareStatement(query);
	    stmt.setInt(1, quantity);
	    stmt.setInt(2, id);
	    stmt.executeUpdate(); 
	}

	@Override
	public Media getMediaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
