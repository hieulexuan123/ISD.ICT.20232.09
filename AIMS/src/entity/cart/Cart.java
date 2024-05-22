package entity.cart;

import java.util.List;

public class Cart {
	private List<CartMedia> cartMediaList;
	private int costNoVAT;
	private int costVAT;
	
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
    	
    }
}
