package views.screen.item;

import java.io.IOException;

import entity.cart.Cart;
import entity.media.Media;
import views.screen.BaseScreen;

public class SpecificMediaDetailScreen extends BaseScreen{
	protected Media media;
	protected Cart cart;
	
	public SpecificMediaDetailScreen(String screenPath) throws IOException {
		super(screenPath);
	}
	
	public Media getMedia() {
		return media;
	}
	
	public void setMedia(Media media) {
		this.media = media;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
