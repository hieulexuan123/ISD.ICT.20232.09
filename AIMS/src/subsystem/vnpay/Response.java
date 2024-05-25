package subsystem.vnpay;

import java.util.Map;
import common.exception.*;
import entity.payment.PaymentTransaction;


import entity.payment.PaymentTransaction;

//public class Response {
//	public PaymentTransaction processResponse(String query) throws Exception{
//		Map<String, String> params = parseQueryString(query);
//		return handleErrorCode(params);
//	}
//	
//	private Map<String, String> parseQueryString(String query){
//		return null;
//	}
//	
//	private PaymentTransaction handleErrorCode(Map<String, String> params) throws Exception {
//		return null;
//	}
//}
public class Response {
    private Map<String, String> response;

    public Response(Map<String, String> response){
        this.response = response;
    }

    public PaymentTransaction getPaymentTransaction(){
        if (response == null) {
            return null;
        }
        // Create Payment transaction
     //   String errorCode = response.get("vnp_TransactionStatus");
        String transactionId = response.get("vnp_TransactionNo");
        String transactionContent = response.get("vnp_OrderInfo");
        int amount = Integer.parseInt(response.get("vnp_Amount")) / 100;
        String orderID= response.get("vnp_orderID");
        String createdAt = response.get("vnp_PayDate");

        PaymentTransaction trans = new PaymentTransaction();

        switch (trans.getErrorCode()) {
            case "00":
                break;
            case "01":
                throw new TransactionNotDoneException();
            case "02":
                throw new TransactionFailedException();
            case "03":
                throw new TransactionReverseException();
            case "04":
                throw new ProcessingException();
            case "05":
                throw new RejectedTransactionException();
            case "06":
                throw new AnonymousTransactionException();
            case "07":
                throw new InternalServerErrorException();
            default:
                throw new UnrecognizedException();
        }
        return trans;
    }
}
