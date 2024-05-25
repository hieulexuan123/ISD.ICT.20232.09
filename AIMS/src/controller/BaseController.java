package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartMedia;

public class BaseController {
	public CartMedia checkMediaInCart(Media media) {
        return Cart.getCart().checkMediaInCart(media);
    }

    /**
     * This method gets the list of items in cart.
     */
    public List getListCartMedia() {
        return Cart.getCart().getListMedia();
    }
}
