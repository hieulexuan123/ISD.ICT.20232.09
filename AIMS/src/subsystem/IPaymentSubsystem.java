package subsystem;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.PaymentTransaction;
import subsystem.vnpay.VNPayController;

import java.io.IOException;
import java.util.Map;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 * 
 * @author hieud
 *
 */
public class IPaymentSubsystem implements IPayment {

	/**
	 * Represent the controller of the subsystem
	 */
	private VNPayController controller;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public IPaymentSubsystem() {
		this.controller = new VNPayController();
	}

	public PaymentTransaction getPaymentTransaction(Map<String, String> res) throws PaymentException, UnrecognizedException {
		return controller.getPaymentTransaction(res);
	}

	@Override
	public String generateURL(int amount, String content) throws IOException {
		return controller.generatePayUrl(amount, content);
	}

	@Override
	public void payOrder(int amount, String content) {
		
	}
}
