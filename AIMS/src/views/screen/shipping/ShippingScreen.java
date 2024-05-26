package views.screen.shipping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import controller.PlaceOrderController;
import entity.cart.CartMedia;
import entity.order.Order;
import entity.shipping.DeliveryInfo;
import views.screen.BaseScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ShippingScreen extends BaseScreen {
    private List<CartMedia> cartMediaList;
    private double costNoVAT;
    private double costVAT;
    private boolean isRush;
    
    private ObservableList<String> choiceBoxItems = FXCollections.observableArrayList("Hanoi", "Saigon", "Danang");

    @FXML
    private DatePicker dateRushOrder;

    @FXML
    private ImageView imageItem;

    @FXML
    private ImageView imageItem1;

    @FXML
    private ImageView imageItem2;

    @FXML
    private Label labelCost;

    @FXML
    private Label labelNotVatIncluded;

    @FXML
    private Label labelTotal;

    @FXML
    private Label labelVATIncluded;

    @FXML
    private ToggleGroup radioDeliInfo;

    @FXML
    private RadioButton radioNormalOrder;

    @FXML
    private RadioButton radioRushOrder;

    @FXML
    private ChoiceBox<String> selectCity;

    @FXML
    private TextField textCustomEmail;

    @FXML
    private TextField textCustomerAddress;

    @FXML
    private TextField textCustomerName;

    @FXML
    private TextField textCustomerNote;

    @FXML
    private TextField textCustomerTel;

    @FXML
    private VBox viewOrderItems;
    
    public ShippingScreen(List<CartMedia> cartMediaList, double costNoVAT, double costVAT) {
        this.cartMediaList = cartMediaList;
        this.costNoVAT = costNoVAT;
        this.costVAT = costVAT;
        PlaceOrderController controller = new PlaceOrderController();
        this.setController(controller);
    }
    
    @FXML
    private void initialize() {
        labelCost.setText("0");
        labelNotVatIncluded.setText(Double.toString(costNoVAT));
        labelVATIncluded.setText(Double.toString(costVAT));
        labelTotal.setText(Double.toString(costVAT));
        selectCity.setItems(choiceBoxItems);
    }
    
    @FXML 
    private void deliveryCost() {
    	if (radioNormalOrder.isSelected()) {
    		labelCost.setText(Double.toString(100));
    		labelTotal.setText(Double.toString(100+costVAT));
    	}
    	else {
    		labelCost.setText(Double.toString(200));
    		labelTotal.setText(Double.toString(200+costVAT));
    	}
    }
    
    @FXML
    void handleConfirm(ActionEvent event) throws Exception {
        String email = textCustomEmail.getText();
        String name = textCustomerName.getText();
        String phone = textCustomerTel.getText();
        String city = selectCity.getValue();
        String address = textCustomerAddress.getText();
        String rushInstruction = textCustomerNote.getText();
        boolean isRush = radioRushOrder.isSelected();
        LocalDate currentDate = dateRushOrder.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String time = currentDate.format(formatter);

        DeliveryInfo info = new DeliveryInfo(email, name, phone, city, address, isRush, time, rushInstruction);
        
        if (info.validateInfo()) {
            // Cast the controller to PlaceOrderController to access the specific method
            PlaceOrderController controller = (PlaceOrderController) getController();
            double shippingFee = controller.calculateShippingFee(city,cartMediaList,isRush);
            double totalCost = costVAT + shippingFee;
            Order newOrder = new Order(cartMediaList, shippingFee, costNoVAT,costVAT,info);
            controller.requestInvoice(newOrder);
        }
    }
}
