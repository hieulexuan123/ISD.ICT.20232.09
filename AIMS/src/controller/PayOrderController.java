package controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import dao.DAOFactory;
import entity.cart.CartMedia;
import entity.order.Order;
import entity.payment.PaymentTransaction;
import subsystem.IPayment;
import subsystem.vnpay.VNPayController;

public class PayOrderController extends BaseController{
	IPayment subsystem = new VNPayController(this);
	public void payOrder(Order order) throws SQLException {
		try {
			int order_id = DAOFactory.getInstance().getOrderDAO().createOrder(order);
			for (CartMedia cm : order.getMediaList()) {
				int media_id = cm.getMedia().getId();
				int quantity = cm.getMedia().getQuantity();
				DAOFactory.getInstance().getMediaDAO().updateMediaQuantity(media_id, quantity);}
			subsystem.payOrder(order.getTotalCost(), "Pay AIMS invoice");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void onUpdateSuccess(PaymentTransaction trans) {
//		System.out.println(trans.toString());
//	}
//	
//	public void onUpdateFailure(String message) {
//		System.out.println(message);
//	}
}
