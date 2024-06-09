package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.IMediaDAO;
import exception.MediaUnavailableException;
import entity.media.Media;

public class Cart {
	
	
	private List<CartMedia> cartMediaList;
	private int costNoVAT;
	private int costVAT;
	
	public static Cart createCart() {
		Cart cart = new Cart();
		IMediaDAO mediaDao = DAOFactory.getInstance().getMediaDAO();
    	try {
			for (Media media : mediaDao.getAllMedia()) {
				CartMedia bookCart = new CartMedia(media, 2);
				cart.addCartMedia(bookCart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}
	
	//constructor
	public Cart() {
		cartMediaList = new ArrayList<CartMedia>();
	}
	
	public void addCartMedia(CartMedia cm){
		 cartMediaList.add(cm);
		 updateCost();
	}

    public void removeCartMedia(CartMedia cm){
    	cartMediaList.remove(cm);
    	updateCost();
    }

    public List<CartMedia> getMediaList(){
        return cartMediaList;
    }
    
    
    public int getCostNoVAT() {
		return costNoVAT;
	}
    
    public int getCostVAT() {
		return costVAT;
	}
    
    public int calculateVAT() {
    	return (int)(0.1 * costNoVAT);
    }
    
    public void updateCost() {
    	costNoVAT = 0;
    	for (CartMedia cm : cartMediaList) {
    		costNoVAT += cm.calculateTotal();
    	}
    	costVAT = costNoVAT + calculateVAT();
    }

    public void emptyCart(){
    	cartMediaList.clear();
    }
    
    
    
    public void checkProductAvai() throws MediaUnavailableException{
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
        if (!allAvai) throw new MediaUnavailableException("Some media not available");
    }


}
