package controller;

import entity.payment.PaymentTransaction;

public class SuccessUpdate {

	public static void onUpdateSuccess(PaymentTransaction trans) {
		System.out.println(trans.toString());
	}
}
