package dao.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.IDAOFactory;
import dao.IMediaDAO;
import dao.IOrderDAO;

public class SqliteDAOFactory implements IDAOFactory{
	private IMediaDAO mediaDAO;
	private IOrderDAO orderDAO;
	private Connection connection;
	
	public SqliteDAOFactory() throws Exception{
		this.connection = createConnection();
	}
	
	private Connection createConnection() throws Exception{
		Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:AIMS/assets/db/aims.db");
    }

	@Override
	public IMediaDAO getMediaDAO() {
		if (mediaDAO==null) {
			mediaDAO = new SqliteMediaDAO(connection);
		}
		return mediaDAO;
	}

	@Override
	public IOrderDAO getOrderDAO() {
		if (orderDAO==null) {
			orderDAO = new SqliteOrderDAO(connection);
		}
		return orderDAO;
	}

}
