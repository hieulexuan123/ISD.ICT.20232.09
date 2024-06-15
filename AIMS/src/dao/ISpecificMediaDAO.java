package dao;

import java.sql.SQLException;
import java.util.List;

import entity.media.category.SpecificMedia;

public interface ISpecificMediaDAO {
	List<SpecificMedia> getAll() throws SQLException;
	SpecificMedia getByMediaId(int id) throws SQLException;
	void deleteByMediaId(int id) throws SQLException;
	void create(SpecificMedia specificMedia) throws SQLException;
}
