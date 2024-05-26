//package controller;
//
//import entity.order.Order;
//import entity.payment.PaymentTransaction;
//import subsystem.IPayment;
//import subsystem.vnpay.VNPayController;
//
//public class PayOrderController extends BaseController{
//	IPayment subsystem = new VNPayController(this);
//	public void payOrder(Order order) {
//		subsystem.payOrder(0, null);
//	}
//	
//	public void onUpdateSuccess(PaymentTransaction trans) {
//		//save trans
//		//call result screen
//	}
//	
//	public void onUpdateFailure(String message) {
//		//call result screen with failure message
//	}
//}
package controller;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.cart.Cart;
import entity.payment.PaymentTransaction;
import subsystem.IPayment;
import subsystem.IPaymentSubsystem;



/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 */
public class PayOrderController extends BaseController {

	/**
	 * Represent the Interbank subsystem
	 */
	private IPayment vnPay;


	public Map<String, String> makePayment(Map<String, String> res) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {

			this.vnPay = new IPaymentSubsystem();
			PaymentTransaction transaction = vnPay.getPaymentTransaction(res);

			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have succesffully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String generateURL(int amount, String content) throws IOException {
		this.vnPay = new IPaymentSubsystem();
		return vnPay.createPayUrl(amount, content);
	}

	public void emptyCart(){
        Cart.getCart().emptyCart();
    }
}