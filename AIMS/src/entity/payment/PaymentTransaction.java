package entity.payment;

import java.time.LocalDate;

public class PaymentTransaction {
<<<<<<< HEAD
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
=======
	private String id;
    private String content;
    private int amount;
    private int orderID;
    private LocalDate paidTime;

	public PaymentTransaction(String id, String content, int amount, LocalDate paidTime) {
		super();
		this.id = id;
		this.content = content;
>>>>>>> 763eb0b8a17e5e635d62051a4263814ff2d06870
		this.amount = amount;
		this.paidTime = paidTime;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

<<<<<<< HEAD
	@Override
	public String toString() {
		return "PaymentTransaction [transactionId=" + transactionId +  "errorCode =" + ErrorCode + ", transactionContent=" + transactionContent
				+ ", amount=" + amount + ", orderID=" + orderID + ", createdAt=" + createdAt + "]";
=======
	public String getId() {
		return id;
>>>>>>> 763eb0b8a17e5e635d62051a4263814ff2d06870
	}

	public String getContent() {
		return content;
	}

	public int getAmount() {
		return amount;
	}

	public LocalDate getPaidTime() {
		return paidTime;
	}

	

}
