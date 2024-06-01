package entity.media;

public class Media {
	protected int id;
    protected String title;
    protected String category;
    protected int price;
    protected int quantity;
    protected String imageURL;
    protected boolean isSupportRushShipping;
    protected int weight;

    public Media(int id, String title, int price, int quantity) {
    	this.id = id;
    	this.title = title;
    	this.price = price;
    	this.quantity = quantity;
    	this.price = price;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setSupportRushShipping(boolean supportRushShipping) {
        isSupportRushShipping = supportRushShipping;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
