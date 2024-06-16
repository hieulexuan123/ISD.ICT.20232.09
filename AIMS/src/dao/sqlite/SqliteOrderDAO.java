package dao.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.IOrderDAO;
import entity.media.Media;
import entity.order.Order;
import entity.order.OrderMedia;

public class SqliteOrderDAO implements IOrderDAO{
	private Connection connection;

	public SqliteOrderDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Order> getAllOrder() throws SQLException {
		String query = "select * from [Order]";
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery(query);
		List<Order> orderList = new ArrayList();
		while (res.next()) {
			int id = res.getInt("id");
			String name = res.getString("name");
			String phone = res.getString("phone");
			String email = res.getString("email");
			String province = res.getString("province");
			String address = res.getString("address");
			String instruction = res.getString("instruction");
			int is_rush = res.getInt("is_rush");
			String rush_instruction = res.getString("rush_instruction");
			String delivery_time = res.getString("delivery_time");
			int shipping_fee = res.getInt("shipping_fee");
			int total_cost = res.getInt("total_cost");
			String status = res.getString("status");
			int is_paid = res.getInt("is_paid");
			Order order = new Order(id,email,name,phone,province,address,instruction,is_rush==1,LocalDate.parse(delivery_time)
									,rush_instruction,shipping_fee,total_cost,status, is_paid==1);
            orderList.add(order);
            System.out.println(order.toString());
		}
	
		return orderList;
	}

	@Override
	public void changeOrderStatusById(int id, String status) throws SQLException {
		String query = "UPDATE [Order] SET status = ? WHERE id = ?";
	    PreparedStatement stmt = connection.prepareStatement(query);
	    stmt.setString(1, status);
	    stmt.setInt(2, id);
	    stmt.executeUpdate();
		
	}
	
	@Override
	public List<OrderMedia> getOrderMediaByOrderId(int orderId) throws SQLException{
		String query = "SELECT OrderMedia.*, Media.title, Media.image_url, Media.is_rush_support "
				+ "FROM OrderMedia JOIN Media ON OrderMedia.media_id = Media.id WHERE order_id = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
	    stmt.setInt(1, orderId);
	    ResultSet res = stmt.executeQuery();
		List<OrderMedia> orderMediaList = new ArrayList<>();
		while (res.next()) {
			int id = res.getInt("media_id");
			String title = res.getString("title");
			int price = res.getInt("price");
			
			int quantity = res.getInt("quantity");
			int isRush = res.getInt("is_rush_support");
			String image = res.getString("image_url");
			OrderMedia orderMedia = new OrderMedia(id,title,image,quantity,price,isRush==1);
			orderMediaList.add(orderMedia);
		}
		return orderMediaList;
	}

	@Override
	public int createOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
