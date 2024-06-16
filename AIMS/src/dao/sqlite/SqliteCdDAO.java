package dao.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.ISpecificMediaDAO;
import entity.media.category.SpecificMedia;
import entity.media.category.Book;
import entity.media.category.CD;

public class SqliteCdDAO implements ISpecificMediaDAO {
	private Connection connection;

	public SqliteCdDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public SpecificMedia getByMediaId(int media_id) throws SQLException {
		String sql = "select * from cd where media_id=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, media_id);
		ResultSet res = pstmt.executeQuery();
		CD cd = new CD();
		if (res.next()) {
			int id = res.getInt("id");
			String artist = res.getString("artist");
			String recordLabel = res.getString("record_label");
			String trackList = res.getString("trackList");
			String releaseDate = res.getString("release_date");
			String genre = res.getString("genre");
			System.out.println("Genre CD: " + genre);
			System.out.println("Date CD: " + releaseDate);
			cd = new CD(id, media_id, artist, recordLabel, trackList, genre, LocalDate.parse(releaseDate));
		}
		return cd;
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
        pstmt.setString(6, cd.getReleaseDate().toString());
        pstmt.executeUpdate();
        System.out.println("Create successfully");
	}

}
