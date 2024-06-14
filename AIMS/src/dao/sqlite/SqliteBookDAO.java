package dao.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.ISpecificMediaDAO;
import entity.media.Media;
import entity.media.category.Book;
import entity.media.category.SpecificMedia;

public class SqliteBookDAO implements ISpecificMediaDAO{
	private Connection connection;

	public SqliteBookDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<SpecificMedia> getAll() throws SQLException {
		String query = "select * from Book";
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery(query);
		List<SpecificMedia> bookList = new ArrayList<>();
		while (res.next()) {
			int id = res.getInt("id");
			int mediaId = res.getInt("media_id");
            String author = res.getString("author");
            String publisher = res.getString("publisher");
            String coverType = res.getString("cover_type");
            String publicationDate = res.getString("publication_date");
            int pages = res.getInt("pages");
            String genre = res.getString("genre");
            String language = res.getString("language");
            
            Book book = new Book(id, mediaId, author, publisher, coverType, LocalDate.parse(publicationDate), pages, genre, language);
            bookList.add(book);
		}
		return bookList;
	}

	@Override
	public SpecificMedia getByMediaId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void create(SpecificMedia specificMedia) throws SQLException {
		Book book = (Book)specificMedia;
		String sql = "INSERT INTO book (media_id, author, publisher, cover_type, publication_date, pages, genre, language) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, book.getMediaId());
        pstmt.setString(2, book.getAuthor());
        pstmt.setString(3, book.getPublisher());
        pstmt.setString(4, book.getCoverType());
        pstmt.setString(5, book.getPublicationDate().toString());
        pstmt.setInt(6, book.getPages());
        pstmt.setString(7, book.getGenre());
        pstmt.setString(8, book.getLanguage());
        pstmt.executeUpdate();
        System.out.println("Create successfully");
	}

	@Override
	public void deleteByMediaId(int id) throws SQLException {
		String query = "delete from Book where media_id = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}

}
