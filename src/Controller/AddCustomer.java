package Controller;

import Helper.WindowMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomer implements Initializable{
    @FXML
    private TextField customerIDBox;
    @FXML
    private TextField customerNameBox;
    @FXML
    private TextField customerAddressBox;
    @FXML
    private TextField customerZipBox;
    @FXML
    private TextField customerPhoneBox;
    @FXML
    private ChoiceBox customerCountryComboBox;
    @FXML
    private ChoiceBox customerRegionComboBox;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void onClickCancelButton(){
        WindowMethods.closeWindow(cancelButton);
    }
    @FXML
    private void onClickSaveButton() {

        int customerID = Integer.parseInt(customerIDBox.getText());
        String customerName = customerNameBox.getText();
        String customerAddress = customerAddressBox.getText();
        String customerZip = customerZipBox.getText();
        String customerPhone = customerPhoneBox.getText();
        String customerCountry = customerCountryComboBox.getSelectionModel().toString();
        String customerRegion = customerRegionComboBox.getSelectionModel().toString();


        WindowMethods.closeWindow(saveButton);
    }


}