package subsystem.vnpay;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import views.screen.BaseScreen;
import subsystem.vnpay.*;

public class VNPayScreen extends BaseScreen{
	@FXML
	private Label pageTitle;
	@FXML
	private VBox vBox;
	
	private String payUrl;
	public VNPayScreen(String screenPath, String payUrl) throws IOException {
		super(screenPath);
		this.payUrl = payUrl;
	}

	public void displayWeb() {
		WebView paymentView = new WebView();
		WebEngine webEngine = paymentView.getEngine();
		webEngine.load(payUrl);
		webEngine.locationProperty().addListener((observable, oldValue, newValue) -> {
			handleUrlChanged(newValue);
		});
		vBox.getChildren().clear();
		vBox.getChildren().add(paymentView);
	}
	
	private void handleUrlChanged(String newUrl) {
		if (newUrl.contains(VNPayConfig.vnp_ReturnUrl)) {
			try {
				URI uri = new URI(newUrl);
				String query = uri.getQuery();
				
				//System.out.println("chuỗi uri " + uri);
				//System.out.println("chuỗi api" + query);
				//sendEmailWithURI(uri.toString());
				sendEmailWithURI();
				ResponseResult.processResponse(query);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} 		
		}
	}
	void sendEmailWithURI() {
		//System.out.println("Email sended!");
			// Thông tin tài khoản email nguồn
			String senderEmail = "nguyenhieunolob@gmail.com";
			String senderPassword = "ubzh pssi iduw hwgr";

			// Thông tin tài khoản email đích
			String recipientEmail = "nguyenhieunolo@gmail.com";
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
