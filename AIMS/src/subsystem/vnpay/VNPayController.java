package subsystem.vnpay;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import controller.BaseController;
import controller.FailureUpdate;
import controller.PayOrderController;
import controller.SuccessUpdate;
import entity.payment.PaymentTransaction;
import subsystem.IPayment;
import subsystem.vnpay.*;
import utils.Config;

public class VNPayController extends BaseController implements IPayment{
	private PayOrderController client;
	
	public VNPayController(PayOrderController client) {
		this.client = client;
	}

	@Override
	public void payOrder(int amount, String content) throws UnsupportedEncodingException {
		Request request = new Request(amount, content);
	
		String payUrl = CreatePayUrl.createPayUrl(request);
		try {
			VNPayScreen vnpayScreen = new VNPayScreen(Config.PAYMENT_SCREEN_PATH, payUrl);
			vnpayScreen.setController(this);
			vnpayScreen.show();
			vnpayScreen.displayWeb();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
