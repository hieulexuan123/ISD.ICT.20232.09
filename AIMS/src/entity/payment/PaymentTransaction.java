package entity.payment;

import java.util.Date;

public class PaymentTransaction {
	private String transactionId;
	private String ErrorCode;
    private String transactionContent;
    private int amount;
    private int orderID;
    private Date createdAt;
    
    public PaymentTransaction(String transactionId, String ErrorCode, String transactionContent, int amount, int orderID,
			Date createdAt) {
		super();
		this.ErrorCode =ErrorCode;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.orderID = orderID;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "PaymentTransaction [transactionId=" + transactionId +  "errorCode =" + ErrorCode + ", transactionContent=" + transactionContent
				+ ", amount=" + amount + ", orderID=" + orderID + ", createdAt=" + createdAt + "]";
	}

	public void save(Integer orderId) {
    	
    }
}
