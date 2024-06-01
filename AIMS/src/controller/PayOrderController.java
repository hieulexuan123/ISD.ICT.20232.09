package controller;

import java.io.UnsupportedEncodingException;

import entity.order.Order;
import entity.payment.PaymentTransaction;
import subsystem.IPayment;
import subsystem.vnpay.VNPayController;

public class PayOrderController extends BaseController{
	IPayment subsystem = new VNPayController(this);
	public void payOrder(Order order) {
		try {
			subsystem.payOrder(order.getTotalCost(), "Pay AIMS invoice");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onUpdateSuccess(PaymentTransaction trans) {
		System.out.println(trans.toString());
	}
	
	public void onUpdateFailure(String message) {
		System.out.println(message);
	}
}
