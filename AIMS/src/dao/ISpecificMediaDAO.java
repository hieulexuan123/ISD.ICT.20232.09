package dao;

import java.sql.SQLException;

import entity.media.category.SpecificMedia;

public interface ISpecificMediaDAO {
	SpecificMedia getByMediaId(int media_id) throws SQLException;
	void deleteByMediaId(int media_id) throws SQLException;
	void create(SpecificMedia specificMedia) throws SQLException;
}
