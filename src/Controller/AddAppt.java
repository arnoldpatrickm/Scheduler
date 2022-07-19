package Controller;

import Helper.WindowMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAppt implements Initializable {
    @FXML
    private Button saveButton;
    @FXML
    private TextField appIDBox;
    @FXML
    private TextField titleBox;
    @FXML
    private TextField descriptionBox;
    @FXML
    private TextField locationBox;
    @FXML
    private TextField typeBox;
    @FXML
    private ChoiceBox contactBox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Spinner startTimeHourSpinner;
    @FXML
    private Spinner endTimeHourSpinner;
    @FXML
    private Spinner startTimeMinutesSpinner;
    @FXML
    private Spinner endTimeMinutesSpinner;
    @FXML
    private ChoiceBox customerBox;
    @FXML
    private ChoiceBox userBox;
    @FXML
    private Button cancelButton;

//    private int appID;
//    private String title;
//    private String description;
//    private String location;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void onClickCancelButton(){
        WindowMethods.closeWindow(cancelButton);
    }
    @FXML
    private void onClickSaveButton(){
        WindowMethods.closeWindow(saveButton);
    }
}