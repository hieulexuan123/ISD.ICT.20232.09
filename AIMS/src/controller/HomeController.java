package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.DAOFactory;
import dao.IMediaDAO;
import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.media.Media;
import utils.Config;
import views.screen.BaseScreen;
import views.screen.cart.CartScreen;

public class HomeController extends BaseController{
	private IMediaDAO mediaDAO = DAOFactory.getInstance().getMediaDAO();
	
	public List<Media> getAllMedia() throws SQLException{
		return mediaDAO.getAllMedia();
    }

	public void addMediaToCart(Cart cart, Media media) {
		CartMedia cartMedia = cart.checkMediaInCart(media);
		if (cartMedia != null) {
            cartMedia.setQuantity(cartMedia.getQuantity() + 1);
		} else {
			 cartMedia = new CartMedia(media, 1, media.getPrice());
			 cart.addCartMedia(cartMedia);
		}
		media.setQuantity(media.getQuantity()-1);
	}
	
	public void requestToCart(Cart cart, BaseScreen prevScreen) {
		try {
			CartScreen cartScreen = new CartScreen(Config.CART_SCREEN_PATH, cart);
			cartScreen.setStage(prevScreen.getStage());
			cartScreen.setHomeScreen(prevScreen);
			cartScreen.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
