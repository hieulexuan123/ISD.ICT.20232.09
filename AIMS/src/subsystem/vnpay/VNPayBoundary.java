package subsystem.vnpay;

import common.exception.UnrecognizedException;
import entity.payment.PaymentTransaction;
import utils.API;

import java.io.IOException;
import java.util.Map;

public class VNPayBoundary {

	public String generatePayUrl(int amount, String content) throws IOException {
		Request payRequestVNPay = new Request(amount, content);
		return payRequestVNPay.createPayUrl(amount, content);
	}

	public PaymentTransaction getPaymentTransaction(Map<String,String> response) {
		Response payResponseVNPay = new Response(response);
		return payResponseVNPay.getPaymentTransaction();
	}

}