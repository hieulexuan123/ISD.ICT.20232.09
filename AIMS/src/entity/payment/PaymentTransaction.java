package entity.payment;

import java.util.Date;

public class PaymentTransaction {
	private String transactionId;
    private String transactionContent;
    private int amount;
    private int orderID;
    private Date createdAt;
    
    public PaymentTransaction(String transactionId, String transactionContent, int amount, int orderID,
			Date createdAt) {
		super();
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.orderID = orderID;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "PaymentTransaction [transactionId=" + transactionId + ", transactionContent=" + transactionContent
				+ ", amount=" + amount + ", orderID=" + orderID + ", createdAt=" + createdAt + "]";
	}

	public void save(Integer orderId) {
    	
    }
}
