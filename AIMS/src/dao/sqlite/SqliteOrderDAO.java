package dao.sqlite;

import java.sql.Connection;

import dao.IOrderDAO;

public class SqliteOrderDAO implements IOrderDAO{
	private Connection connection;

	public SqliteOrderDAO(Connection connection) {
		this.connection = connection;
	}
}
