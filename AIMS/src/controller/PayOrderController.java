package controller;

import entity.order.Order;
import entity.payment.PaymentTransaction;
import subsystem.IPayment;
import subsystem.vnpay.VNPayController;

public class PayOrderController extends BaseController{
	IPayment subsystem = new VNPayController(this);
	public void payOrder(Order order) {
		subsystem.payOrder(0, null);
	}
	
	public void onUpdateSuccess(PaymentTransaction trans) {
		//save trans
		//call result screen
	}
	
	public void onUpdateFailure(String message) {
		//call result screen with failure message
	}
}
