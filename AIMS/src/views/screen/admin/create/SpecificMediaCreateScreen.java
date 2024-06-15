package views.screen.admin.create;

import java.io.IOException;

import entity.media.Media;
import views.screen.BaseScreen;

public class SpecificMediaCreateScreen extends BaseScreen{
	protected Media media;
	public SpecificMediaCreateScreen(String screenPath) throws IOException {
		super(screenPath);
	}
	
	public Media getMedia() {
		return media;
	}
	
	public void setMedia(Media media) {
		this.media = media;
	}
	
}
