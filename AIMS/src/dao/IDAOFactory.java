package dao;

public interface IDAOFactory {
	IMediaDAO getMediaDAO();
	IOrderDAO getOrderDAO();
	ISpecificMediaDAO getBookDAO();
	IUserDAO getUserDAO();
}
