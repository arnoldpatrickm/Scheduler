//package c195db2tableviewexample;
//
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.property.ReadOnlyStringWrapper;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//
//public class DB2TableViewController implements Initializable {
//
//    @FXML
//    private TableView<TableRow> table;
//
//    @FXML
//    private TableColumn<TableRow, String> colCity;
//
//    @FXML
//    private TableColumn<TableRow, String> colCountry;
//
//    @FXML
//    private TableColumn<TableRow, String> colStart;
//
//    @FXML
//    private Button btnDetail;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//
//        ObservableList<TableRow> cityList = FXCollections.observableArrayList();
//
//        ResultSet rs = accessDB();
//        colCity.setCellValueFactory(cellData -> {
//            return cellData.getValue().getCity();
//        });
//        colCountry.setCellValueFactory(cellData -> {
//            return cellData.getValue().getCountry();
//        });
//        colStart.setCellValueFactory(cellData -> {
//            return cellData.getValue().getStart();
//        });
//        try {
//            rs.beforeFirst(); //this is needed because the result set was looped through in accessDB.  We need to reset the cursor!
//            while (rs.next()) {
//                String city = rs.getString("city"); //parameter is the column name in the database
//                String country = rs.getString("country");
//                String start = rs.getString("start");
//                TableRow tr = new TableRow(new ReadOnlyStringWrapper(city),
//                        new ReadOnlyStringWrapper(country),
//                        new ReadOnlyStringWrapper(start),
//                        new ReadOnlyStringWrapper("The city of " + city + " in the country of " + country + " really was beautiful at " + start + "!"));
//                cityList.add(tr);
//            }
//            table.setItems(cityList);
//        } catch (SQLException ex) {
//            Logger.getLogger(DB2TableViewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public ResultSet accessDB() {
//        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        final String DB_URL = "jdbc:mysql://52.206.157.109/U03QIu";
//
//        //  Database credentials
//        final String DBUSER = "U03QIu";
//        final String DBPASS = "53688051379";
//
//        Connection conn;
//        boolean res = false;
//        ResultSet rs = null;
//
//        try {
//
//            Class.forName("com.mysql.jdbc.Driver");
//
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);
//
//            Statement stmt;
//
//            try {
//
//                stmt = conn.createStatement();
//                rs = stmt.executeQuery("SELECT city, country, start FROM city, country, appointment WHERE city.countryID = country.countryID");
//                while (rs.next()) {
//                    System.out.println(rs.getString(1));
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            ex.printStackTrace();
//        }
//        return rs;
//    }
//
//    @FXML
//    void handleButtonAction(ActionEvent event) {
//        TableRow tr = table.getSelectionModel().getSelectedItem();
//        if (tr == null) {
//            Alert err = new Alert(AlertType.ERROR);
//            err.setTitle("Error");
//            err.setHeaderText("Error!");
//            err.setContentText("Please choose a city");
//            err.showAndWait();
//        }
//        String detail = tr.getDetail().getValue();
//
//        Alert a = new Alert(AlertType.INFORMATION);
//        a.setTitle("Detail");
//        a.setHeaderText("City detail");
//        a.setContentText(detail);
//        a.showAndWait();
//    }
//}
