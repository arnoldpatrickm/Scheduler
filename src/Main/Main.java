package Main;

import DAO.ContactAccess;
import DAO.DivisionAccess;
import DAO.UserAccess;
import Helper.JDBC;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Appointments.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.onCloseRequestProperty().setValue(e -> Platform.exit());
        primaryStage.show();
    }



    public static void main(String[] args) throws SQLException {

        JDBC.openConnection();
        UserAccess.userLogin("test", "test");
        DivisionAccess.getDivisions();
        ContactAccess.getContacts();

        //********Important*********JavaFX Specific********From JDBC Webinar***********
        //openConnection() goes before launch. When it reaches launch(args) it pauses and does not continue to closeConnection() until the application is closed.
        launch(args);
        JDBC.closeConnection();
    }
}
