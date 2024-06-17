package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dao.DAOFactory;
import entity.cart.CartMedia;
import entity.order.Order;
import entity.payment.PaymentTransaction;
import javafx.stage.Stage;
import subsystem.IPayment;
import subsystem.vnpay.VNPayController;
import utils.Config;
import views.screen.BaseScreen;
import views.screen.payment.PaymentResultScreen;

public class PayOrderController extends BaseController{
<<<<<<< HEAD
	IPayment subsystem = new VNPayController(this);
	public void payOrder(Order order) throws SQLException {
		try {
			
			int order_id = DAOFactory.getInstance().getOrderDAO().createOrder(order);
=======
	IPayment subsystem;
	BaseScreen homeScreen;
	int order_id;
	String email;
	
	public void payOrder(Order order, BaseScreen homeScreen) {
		try {
			order_id = DAOFactory.getInstance().getOrderDAO().createOrder(order);
>>>>>>> 763eb0b8a17e5e635d62051a4263814ff2d06870
			for (CartMedia cm : order.getMediaList()) {
				int media_id = cm.getMedia().getId();
				int quantity = cm.getMedia().getQuantity();
				DAOFactory.getInstance().getMediaDAO().updateMediaQuantity(media_id, quantity);
			}
			this.homeScreen = homeScreen;
			this.email = order.getEmail();
			subsystem = new VNPayController(this, homeScreen.getStage());
			subsystem.payOrder(order.getTotalCost(), "Pay AIMS invoice");
		} catch (UnsupportedEncodingException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void handleSuccess(PaymentTransaction trans) {
		System.out.println(trans.toString());
		try {
			BaseScreen resultScreen = new PaymentResultScreen(Config.PAYMENT_RESULT_SCREEN, "Successfully paid", "We have sent the order information to you email");
			resultScreen.setHomeScreen(homeScreen);
			resultScreen.setStage(homeScreen.getStage());
			resultScreen.setScreenTitle("Payment result");
			resultScreen.show();
			
			//save transaction
			trans.setOrderID(order_id);
			DAOFactory.getInstance().getTransDAO().createTransaction(trans);
			DAOFactory.getInstance().getOrderDAO().updateOrderIsPaidById(order_id);
			
			//send email
			sendEmail();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void handleFailure(String message) {
		try {
			BaseScreen resultScreen = new PaymentResultScreen(Config.PAYMENT_RESULT_SCREEN, "Failed payment", message);
			resultScreen.setHomeScreen(homeScreen);
			resultScreen.setStage(homeScreen.getStage());
			resultScreen.setScreenTitle("Payment result");
			resultScreen.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendEmail() {
		// Thông tin tài khoản email nguồn
		String senderEmail = "nguyenhieunolob@gmail.com";
		String senderPassword = "ubzh pssi iduw hwgr";

		// Thông tin tài khoản email đích
		String recipientEmail = email;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});
		Message message = new MimeMessage(session);
		System.out.println("truoc ham try");
		try {
			// Tạo đối tượng Message
			
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail , false));
			message.setSubject("Thanh toán thành công");

			// Tạo nội dung email
			String content = "\n\nThank you for choosing AIMS project from group 9!\n\n"
					  + "Your order has been confirmed!" ;
			message.setText(content);

			// Gửi email
			Transport.send(message);

			System.out.println("Email sended!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}