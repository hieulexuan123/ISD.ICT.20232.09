
package entity.payment;

public class PaymentTransaction {
	private String errorCode;
	private CreditCard card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private int orderID;
	private String createdAt;

	public PaymentTransaction(){
		super();
	}
	
	public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent,
			int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.card = card;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.orderID= orderID;
		this.amount = amount;
		this.createdAt = createdAt;
	}

	
	public String getErrorCode() {
		return errorCode;
	}
	public void save(Integer orderId) {

}}