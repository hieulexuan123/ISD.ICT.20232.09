package entity.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	
	private List<CartMedia> cartMediaList;
	private int costNoVAT;
	private int costVAT;
	
	//constructor
	public Cart() {
		cartMediaList = new ArrayList<CartMedia>();
	}
	
	public void addCartMedia(CartMedia cm){
		 cartMediaList.add(cm);
	}

    public void removeCartMedia(CartMedia cm){
    	cartMediaList.remove(cm);
    }

    public List<CartMedia> getListMedia(){
        return cartMediaList;
    }

    public void emptyCart(){
    	cartMediaList.clear();
    }
    
    
    
    public void checkProductAvai() throws Exception{
    	boolean allAvai = true;
        for (CartMedia object : cartMediaList) {
            //CartMedia cartMedia = (CartMedia) object;
        	// get quantity of products needed in the cart
            int requiredQuantity = object.getQuantity();
            // get quantity of products available
            int availQuantity = object.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvai = false;
        }
        //if quantity is insufficient, throw exception
        if (!allAvai) throw new Exception("Some media not available");
    }
}
