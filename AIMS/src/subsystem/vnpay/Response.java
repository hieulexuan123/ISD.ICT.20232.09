package subsystem.vnpay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax.activation.*;

import utils.Config;
import views.screen.*;
import views.screen.payment.PaymentResultScreen;
import entity.payment.PaymentTransaction;

public class Response {
	public PaymentTransaction processResponse(String query) throws Exception{
		Map<String, String> params = parseQueryString(query);
		//
		return handleErrorCode(params);
	}
	
	private Map<String, String> parseQueryString(String query){
		Map<String, String> params = new HashMap<>();
        if (query != null && !query.isEmpty()) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    params.put(keyValue[0], keyValue[1]);
                }
            }
        }
        return params;
	}
	
	private PaymentTransaction handleErrorCode(Map<String, String> params) throws Exception {
		if (params == null) {
            return null;
        }

        // Create Payment transaction
        String errorCode = params.get("vnp_ResponseCode");
        String transactionId = params.get("vnp_TransactionNo");
        String transactionContent = params.get("vnp_OrderInfo");
        int amount = Integer.parseInt((String) params.get("vnp_Amount")) / 100;
        String createdAt = params.get("vnp_PayDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        Date date = dateFormat.parse(createdAt);
        PaymentTransaction trans = new PaymentTransaction(transactionId, errorCode,transactionContent, amount, 1, date);
        
        
        switch (errorCode) {
            case "00":
            	
                BaseScreen resultScreen = new PaymentResultScreen( Config.PAYMENT_RESULT_SCREEN,"PAYMENT SUCCESSFUL!", "You had successfully paid the order");

            	resultScreen.show();
            	break;
            default:
            	BaseScreen resultScreen1 = new PaymentResultScreen( Config.PAYMENT_RESULT_SCREEN,"PAYMENT FAILED!", "Please try again!");

            	resultScreen1.show();
            	throw new Exception("Transaction failed");
        }
        return trans;
	}
	 
		
}
