package subsystem.vnpay;

import controller.BaseController;
import controller.PayOrderController;
import entity.payment.PaymentTransaction;
import subsystem.IPayment;

public class VNPayController extends BaseController implements IPayment{
	private PayOrderController client;
	
	public VNPayController(PayOrderController client) {
		this.client = client;
	}

	@Override
	public void payOrder(int amount, String content) {
		// TODO Auto-generated method stub
		String payUrl = Request.createPayUrl(amount, content);
		//VNPayScreen vnpayScreen = new VNPayScreen();
		//vnpayScreen.setController(this);
	}
	
	private void processResponse(String query) {
		Response response = new Response();
		try {
			PaymentTransaction transaction = response.processResponse(query);
			client.onUpdateSuccess(transaction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			client.onUpdateFailure("Some error");
		}
	}

}
