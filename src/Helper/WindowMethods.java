package Helper;

import Controller.Appointments;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

    public class WindowMethods {

        final static String addFXML = "Add";
        final static String modFXML = "Mod";
        final static String customerFXML = "Customer.fxml";
        final static String apptFXML = "Appt.fxml";
        final static String loginFXML = "Login.fxml";
        final static String appointmentsFXML = "Appointments.fxml";
        final static String reportsFXML = "Reports.fxml";

        public static void closeWindow(Button button) {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        }

        public static void switchWindow (String FXMLPage, String titleString) {
            try {
                System.out.println("/view/" + FXMLPage);
                FXMLLoader fxmlLoader = new FXMLLoader(Appointments.class.getResource("/view/" + FXMLPage));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                if (FXMLPage != "Appointments.fxml") {
                    stage.initModality(Modality.APPLICATION_MODAL);}
                stage.setScene(new Scene(root1));
                stage.setTitle(titleString);
                stage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public static void switchWindow(String prefix, String FXMLPage, String titleString) {
            try {
                System.out.println("/view/" + prefix + FXMLPage);
                FXMLLoader fxmlLoader = new FXMLLoader(Appointments.class.getResource("/view/" + prefix + FXMLPage));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                if (FXMLPage != "Appointments.fxml") {
                    stage.initModality(Modality.APPLICATION_MODAL);}
                stage.setScene(new Scene(root1));
                stage.setTitle(titleString);
                stage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
