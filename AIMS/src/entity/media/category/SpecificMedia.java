package entity.media.category;

import java.io.IOException;

import dao.ISpecificMediaDAO;
import views.screen.BaseScreen;
import views.screen.admin.create.SpecificMediaCreateScreen;

public abstract class SpecificMedia {
	protected int mediaId;
	
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	
	public int getMediaId() {
		return mediaId;
	}
	
	public abstract ISpecificMediaDAO getSpecificMediaDAO();
	public abstract SpecificMediaCreateScreen getCreateScreen() throws IOException;
}
