package entity.payment;

import java.util.Date;

public class PaymentTransaction {
	private String transactionId;
    private String transactionContent;
    private int amount;
    private int orderID;
    private Date createdAt;
    
    public void save(Integer orderId) {
    	
    }
}
