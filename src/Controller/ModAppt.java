package Controller;

import Helper.WindowMethods;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ModAppt implements Initializable {
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
    private void onClickSaveButton(){
        WindowMethods.closeWindow(saveButton);
    }

}