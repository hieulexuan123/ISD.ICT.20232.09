package subsystem.vnpay;

import controller.FailureUpdate;
import controller.SuccessUpdate;
import entity.payment.PaymentTransaction;

public class ResponseResult {
	public static void processResponse(String query) {
		Response response = new Response();
		try {
			PaymentTransaction transaction = response.processResponse(query);
			SuccessUpdate.onUpdateSuccess(transaction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FailureUpdate.onUpdateFailure(e.getMessage());
			//client.onUpdateFailure(e.getMessage());
		}
	}

}
