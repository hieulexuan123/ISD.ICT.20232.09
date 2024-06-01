package subsystem.vnpay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import entity.payment.PaymentTransaction;

public class Response {
	public PaymentTransaction processResponse(String query) throws Exception{
		Map<String, String> params = parseQueryString(query);
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
        String errorCode = params.get("vnp_TransactionStatus");
        String transactionId = params.get("vnp_TransactionNo");
        String transactionContent = params.get("vnp_OrderInfo");
        int amount = Integer.parseInt((String) params.get("vnp_Amount")) / 100;
        String createdAt = params.get("vnp_PayDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        Date date = dateFormat.parse(createdAt);
        PaymentTransaction trans = new PaymentTransaction(transactionId, transactionContent, amount, 1, date);
        switch (errorCode) {
            case "00":
                break;
            default:
            	throw new Exception("Transaction failed");
        }
        return trans;
	}
}
