package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Appointments implements Initializable {
    public Button AddButton;
    public Button ModifyButton;
    public Button DeleteButton;
    @FXML
    private RadioButton CustomerRadio;
    @FXML
    private RadioButton AppointmentsRadio;
    @FXML
    private ToggleGroup ViewChoice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void onClickAppointmentsRadio() {
        AddButton.setText("Add Appointment");
        ModifyButton.setText("Modify Appointment");
        DeleteButton.setText("Delete Appointment");
    }
    public void onClickCustomerRadio() {
        AddButton.setText("Add Customer");
        ModifyButton.setText("Modify Customer");
        DeleteButton.setText("Delete Customer");
    }
    @FXML
    public void toAddAppt(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AddAppt.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Create Appointment");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void toReports(ActionEvent event) throws Exception {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Reports.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Reports");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void onClickAddButton(ActionEvent actionEvent) {
    if (ViewChoice.getSelectedToggle() == AppointmentsRadio ) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AddAppt.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Create Appointment");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    } else {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AddCustomer.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Create Customer");
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    }

    public void onClickModifyButton(ActionEvent actionEvent) {
    }

    public void onClickDeleteButton(ActionEvent actionEvent) {
    }
}
