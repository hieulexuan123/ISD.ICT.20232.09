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
				
				
				sendEmailWithURI();
				ResponseResult.processResponse(query);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} 		
		}
	}
	void sendEmailWithURI() {
		
			String senderEmail = "nguyenhieunolob@gmail.com";
			String senderPassword = "ubzh pssi iduw hwgr";
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
						try {
			
				message.setFrom(new InternetAddress(senderEmail));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail , false));
				message.setSubject("Payment successful!");
				String htmlContent = "<h1>Order Confirmation</h1>"
                        + "<p>Dear Customer,</p>"
                        + "<p>Thank you for placing your order. Your order has been confirmed.</p>"
                        + "<p>Best regards,</p>"
                        + "<p>ITSS group 9 </p>"  
						+ "<p><img src=\"https://phunugioi.com/wp-content/uploads/2020/10/hinh-anh-cam-on.jpg\" alt=\"Order Confirmation Image\" style=\"max-width: 100%; height: auto;\"></p>";
				message.setContent(htmlContent, "text/html");
				
				Transport.send(message);

				System.out.println("Email sended!");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
