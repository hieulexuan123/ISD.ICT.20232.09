package views.screen.admin;

import java.io.IOException;

import controller.AdminMediaController;
import entity.order.OrderMedia;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import views.screen.BaseScreen;

public class AdminOrderDetailScreen extends BaseScreen {

    public AdminOrderDetailScreen(String screenPath) throws IOException {
		super(screenPath);
		// TODO Auto-generated constructor stub
	}

	@FXML
    private Label addressField;

    @FXML
    private Button backHome;

    @FXML
    private Button cancelButton;

    @FXML
    private Label deliveryDate;

    @FXML
    private Label deliveryInstruction;

    @FXML
    private Button mediaManage;

    @FXML
    private Label nameField;

    @FXML
    private Label normalInstruction;

    @FXML
    private Button orderManage;

    @FXML
    private TableColumn<OrderMedia, Integer> orderMediaId;

    @FXML
    private TableColumn<OrderMedia, String> orderMediaImage;

    @FXML
    private TableColumn<OrderMedia, Integer> orderMediaPrice;

    @FXML
    private TableColumn<OrderMedia, Integer> orderMediaQuantity;

    @FXML
    private TableView<OrderMedia> orderMediaTable;

    @FXML
    private TableColumn<OrderMedia, String> orderMediaTitle;

    @FXML
    private TableColumn<OrderMedia, Boolean> orderMediaIsRush;

    @FXML
    private Label orderStatus;

    @FXML
    private Label paymentStatus;

    @FXML
    private Label phoneField;

    @FXML
    private Label provinceField;

    @FXML
    private Label shipTypeField;

    @FXML
    private Label shippingFee;

    @FXML
    private Label totalCost;

    @FXML
    private Label totalPrice;

    @Override
	public void show() {
		setOrderMediaInfo();
		super.show();
	}
    
    @Override
	public AdminOrderMediaController getController() {
		return (AdminOrderMediaController)super.getController();
	}
}
