package subsystem;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.PaymentTransaction;
import java.io.IOException;

import java.util.Map;

public interface IPayment {
	public void payOrder(int amount, String content);
	public abstract PaymentTransaction getPaymentTransaction(Map<String,String> res)
			throws PaymentException, UnrecognizedException, IOException;

	public abstract String createPayUrl(int amount, String content) throws IOException;

}
