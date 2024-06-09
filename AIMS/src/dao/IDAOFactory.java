package dao;

public interface IDAOFactory {
	IMediaDAO getMediaDAO();
	IOrderDAO getOrderDAO();
}
