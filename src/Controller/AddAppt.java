package Controller;

import DAO.AppointmentAccess;
import Helper.WindowMethods;
import Model.Appointment;
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
    private int currentIndex = AppointmentAccess.appointmentIndex;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        appIDBox.setText(String.valueOf(currentIndex + 1));
    }

    @FXML
    private void onClickCancelButton(){
        WindowMethods.closeWindow(cancelButton);
    }
    @FXML
    private void onClickSaveButton()
    {
        String title = titleBox.getText();
        String description = descriptionBox.getText();
        String location = locationBox.getText();
        String type = typeBox.getText();
//        int customerID = Integer.parseInt(customerBox.getItems().toString());
//        int userID = Integer.parseInt(userBox.getItems().toString());
//        int contactID = Integer.parseInt(contactBox.getItems().toString());
        System.out.println(AppointmentAccess.appointmentIndex);
        AppointmentAccess.appointmentIndex++;
        int appointmentIndex = AppointmentAccess.appointmentIndex;
        int customerID = 1;
        int userID = 1;
        int contactID = 1;
        Appointment appointment = new Appointment(appointmentIndex, title, description, location, type, customerID, userID, contactID);
        System.out.println(AppointmentAccess.appointmentIndex);
        AppointmentAccess.addAppointment(appointment);
        Appointments.appointmentsOL.add(appointment);
        WindowMethods.closeWindow(saveButton);
    }
}
