package dao;

import java.sql.SQLException;
import java.util.List;

import entity.media.Media;

public interface IMediaDAO {
	List<Media> getAllMedia() throws SQLException;
	Media getMediaById(int id);
}
