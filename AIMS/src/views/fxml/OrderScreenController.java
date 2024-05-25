package views.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class OrderScreenController {

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
    private ChoiceBox<?> selectCity;

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

}
