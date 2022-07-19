package DAO;

import Controller.Appointments;
import Helper.JDBC;
import Model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppointmentAccess {

    public static ObservableList<Appointment> getAppointments() throws SQLException {
        ObservableList<Appointment> appData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM APPOINTMENTS";
        PreparedStatement ps =  JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
//        Appointments.appData.clear();
        while(rs.next()){
            int id = rs.getInt(1);
            String title = rs.getString("Title");
            String description = rs.getString("Description");
            String location = rs.getString("Location");
            String type = rs.getString("Type");
            LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
            LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
            int customerID = rs.getInt("Customer_ID");
            int userID = rs.getInt("User_ID");
            int contactID = rs.getInt("Contact_ID");
            appData.add(new Appointment(id, title, description, location, type, start, end, customerID, userID, contactID));
            System.out.println(id + " | " + title + " | " + description + " | " + location + " | " + type + " | " + start + " | "
                    + end + " | " + customerID  + " | " + userID  + " | " + contactID );
            System.out.println(appData.size());
        }
        return appData;
    }

    public static void addAppointment() {

        try {
            System.out.println("****Attempting to add new appointment****");
            PreparedStatement st = JDBC.connection.prepareStatement(
                            "INSERT INTO appointments (Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update, Customer_ID, User_ID, Contact_ID)" +
                                    ("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"));
//            st.setInt(1, appID);
            st.executeUpdate();

        }
        catch(Exception e) {
            System.out.println(e);
            System.out.println("****Add Failed****");
        }
    }
    public static boolean deleteAppointment(Appointment appointment) {
        int appID = appointment.getAppointmentID();
        try {
            System.out.println("****Attempting to delete appointment with ID of " + appID + " ****");
            PreparedStatement st = JDBC.connection.prepareStatement("DELETE FROM appointments WHERE Appointment_ID = ?");
            st.setInt(1, appID);
            st.executeUpdate();
            System.out.println("****Appointment deleted!****");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("****Deletion Failed****");
            return false;
        }
    }
}
