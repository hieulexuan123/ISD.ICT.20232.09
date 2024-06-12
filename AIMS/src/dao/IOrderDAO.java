package dao;

import java.sql.SQLException;
import java.util.List;

import entity.media.Media;
import entity.order.Order;

public interface IOrderDAO {
	List<Order> getAllOrder() throws SQLException;
	void changeOrderStatusById(int id, String status) throws SQLException;
	Order getOrderDetail() throws SQLException;
}
