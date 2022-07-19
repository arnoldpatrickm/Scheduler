package Controller;

import DAO.AppointmentAccess;
import DAO.CustomerAccess;
import Helper.WindowMethods;
import Model.Appointment;
import Model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class Appointments implements Initializable {
    @FXML
    private TableView customerTable;
    @FXML
    private TableView appTable;
    @FXML
    private Button AddButton;
    @FXML
    private Button ModifyButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private RadioButton CustomerRadio;
    @FXML
    private RadioButton AppointmentsRadio;
    @FXML
    private ToggleGroup ViewChoice;

    final String addFXML = "Add";
    final String modFXML = "Mod";
    final String customerFXML = "Customer.fxml";
    final String apptFXML = "Appt.fxml";
    final String loginFXML = "Login.fxml";
    final String appointmentsFXML = "Appointments.fxml";
    final String reportsFXML = "Reports.fxml";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn appointmentID = new TableColumn("Appointment ID");
        appointmentID.setStyle("-fx-alignment: CENTER");
        TableColumn title = new TableColumn("Title");
        title.setStyle("-fx-alignment: CENTER");
        TableColumn description = new TableColumn("Description");
        description.setStyle("-fx-alignment: CENTER");
        TableColumn location = new TableColumn("Location");
        location.setStyle("-fx-alignment: CENTER");
        TableColumn type = new TableColumn("Type");
        type.setStyle("-fx-alignment: CENTER");
        TableColumn start = new TableColumn("Start");
        start.setStyle("-fx-alignment: CENTER");
        TableColumn end = new TableColumn("End");
        end.setStyle("-fx-alignment: CENTER");
        TableColumn customerID1 = new TableColumn("Customer ID");
        customerID1.setStyle("-fx-alignment: CENTER");
        TableColumn customerID2 = new TableColumn("Customer ID");
        customerID2.setStyle("-fx-alignment: CENTER");
        TableColumn userID = new TableColumn("User ID");
        userID.setStyle("-fx-alignment: CENTER");
        TableColumn contactID = new TableColumn("Contact ID");
        contactID.setStyle("-fx-alignment: CENTER");
        TableColumn[] columns = {appointmentID, title, description, location, type, start, end, customerID1, userID, contactID};

        appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("title"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        start.setCellValueFactory(new PropertyValueFactory<>("start"));
        end.setCellValueFactory(new PropertyValueFactory<>("end"));
        customerID1.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        userID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        contactID.setCellValueFactory(new PropertyValueFactory<>("contactID"));

        appTable.getColumns().addAll(columns);
        appTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        try {
            appTable.setItems(AppointmentAccess.getAppointments());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        TableColumn customerName = new TableColumn("Customer Name");
        customerName.setStyle("-fx-alignment: CENTER");
        TableColumn address = new TableColumn("Address");
        address.setStyle("-fx-alignment: CENTER");
        TableColumn postalCode = new TableColumn("Postal Code");
        postalCode.setStyle("-fx-alignment: CENTER");
        TableColumn phone = new TableColumn("Phone Number");
        phone.setStyle("-fx-alignment: CENTER");
        TableColumn divisionID = new TableColumn("Division ID");
        divisionID.setStyle("-fx-alignment: CENTER");
        TableColumn[] columns2 = {customerName, customerID2, address, postalCode, phone, divisionID};

        customerID2.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        postalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        divisionID.setCellValueFactory(new PropertyValueFactory<>("divisionID"));

        customerTable.getColumns().addAll(columns2);
        customerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        try {
            customerTable.setItems(CustomerAccess.getCustomers());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        refreshAppSelection();
//        refreshCustSelection();
    }

    public void refreshAppSelection(){
        appTable.getSelectionModel().select(0);
    }
    public void refreshCustSelection(){
        customerTable.getSelectionModel().select(0);
    }
    public void onClickAppointmentsRadio() {
        AddButton.setText("Add Appointment");
        ModifyButton.setText("Modify Appointment");
        DeleteButton.setText("Delete Appointment");
        customerTable.getSelectionModel().select(0);
        customerTable.setOpacity(0);
        customerTable.disableProperty().setValue(true);
        appTable.setOpacity(1);
        appTable.disableProperty().setValue(false);
    }

    public void onClickCustomerRadio() {
        AddButton.setText("Add Customer");
        ModifyButton.setText("Modify Customer");
        DeleteButton.setText("Delete Customer");
        appTable.getSelectionModel().select(0);
        appTable.setOpacity(0);
        appTable.disableProperty().setValue(true);
        customerTable.setOpacity(1);
        customerTable.disableProperty().setValue(false);
    }

    public void toReports() throws Exception {
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

    public void onClickAddButton() {
    if (ViewChoice.getSelectedToggle() == AppointmentsRadio) {
        try {
            WindowMethods.switchWindow(addFXML, apptFXML, "New Appointment");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    else {
        try {
            WindowMethods.switchWindow(addFXML, customerFXML, "New Customer");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

    public void onClickModifyButton() {
        if (ViewChoice.getSelectedToggle() == AppointmentsRadio && appTable.getSelectionModel().getSelectedItem() != null) {
            try { WindowMethods.switchWindow(modFXML, apptFXML, "Modify Appointment");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if (customerTable.getSelectionModel().getSelectedItem() != null) {
            try { WindowMethods.switchWindow(modFXML, apptFXML, "Modify Appointment");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onClickDeleteButton() {
        if (ViewChoice.getSelectedToggle() == AppointmentsRadio && appTable.getSelectionModel().getSelectedItem() != null) {
            try {AppointmentAccess.deleteAppointment((Appointment)appTable.getSelectionModel().getSelectedItem());
                appTable.getItems().remove(appTable.getSelectionModel().getSelectedItem());
                refreshAppSelection();
            } catch (Exception e) {
                e.printStackTrace();
                }
            }
        else if (customerTable.getSelectionModel().getSelectedItem() != null) {
            try {CustomerAccess.deleteCustomer((Customer) customerTable.getSelectionModel().getSelectedItem());
                customerTable.getItems().remove(customerTable.getSelectionModel().getSelectedItem());
                refreshCustSelection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
