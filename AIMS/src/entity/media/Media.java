package entity.media;

public class Media {
	protected int id;
    protected String title;
    protected String category;
    protected int price;
    protected int value;
    protected int quantity;
    protected String imageURL;
    protected boolean isSupportRushShipping;
    protected int weight;
    
	public Media(int id, String title, String category, int price, int value, int quantity, String imageURL,
			boolean isSupportRushShipping, int weight) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.value = value;
		this.quantity = quantity;
		this.imageURL = imageURL;
		this.isSupportRushShipping = isSupportRushShipping;
		this.weight = weight;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public boolean isSupportRushShipping() {
		return isSupportRushShipping;
	}

	public void setSupportRushShipping(boolean isSupportRushShipping) {
		this.isSupportRushShipping = isSupportRushShipping;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", category=" + category + ", price=" + price + ", value="
				+ value + ", quantity=" + quantity + ", imageURL=" + imageURL + ", isSupportRushShipping="
				+ isSupportRushShipping + ", weight=" + weight + "]";
	}

    
}
