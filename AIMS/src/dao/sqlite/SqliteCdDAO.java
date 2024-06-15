package dao.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.ISpecificMediaDAO;
import entity.media.category.SpecificMedia;
import entity.media.category.CD;

public class SqliteCdDAO implements ISpecificMediaDAO {
	private Connection connection;

	public SqliteCdDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<SpecificMedia> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpecificMedia getByMediaId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByMediaId(int id) throws SQLException {
		String query = "delete from cd where media_id = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}

	@Override
	public void create(SpecificMedia specificMedia) throws SQLException {
		CD cd = (CD)specificMedia;
		String sql = "INSERT INTO cd (media_id, artist, record_label, tracklist, genre, release_date) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, cd.getMediaId());
        pstmt.setString(2, cd.getArtist());
        pstmt.setString(3, cd.getRecordLabel());
        pstmt.setString(4, cd.getTrackList());
        pstmt.setString(5, cd.getGenre());
        pstmt.setString(6, cd.getGenre().toString());
        pstmt.executeUpdate();
        System.out.println("Create successfully");
	}

}
