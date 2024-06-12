package entity.order;

public class OrderMedia {
	private int id;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getImageURL() {
		return imageURL;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getPrice() {
		return price;
	}
	private String title;
	private String category;
	private String imageURL;
	private int quantity;
    private int price;
	public OrderMedia() {
		// TODO Auto-generated constructor stub
	}

}
