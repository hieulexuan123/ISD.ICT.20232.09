package subsystem.vnpay;

import java.util.Map;

import entity.payment.PaymentTransaction;

public class Response {
	public PaymentTransaction processResponse(String query) throws Exception{
		Map<String, String> params = parseQueryString(query);
		return handleErrorCode(params);
	}
	
	private Map<String, String> parseQueryString(String query){
		return null;
	}
	
	private PaymentTransaction handleErrorCode(Map<String, String> params) throws Exception {
		return null;
	}
}
