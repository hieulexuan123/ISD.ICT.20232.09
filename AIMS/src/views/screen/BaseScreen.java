package views.screen;

import controller.BaseController;

public class BaseScreen {
	private BaseScreen prev;
	private BaseController controller;
	public BaseScreen getPrev() {
		return prev;
	}
	public void setPrev(BaseScreen prev) {
		this.prev = prev;
	}
	public BaseController getController() {
		return controller;
	}
	public void setController(BaseController controller) {
		this.controller = controller;
	}
	
	
}
