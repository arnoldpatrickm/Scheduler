package DAO;

import Controller.Appointments;
import Helper.JDBC;
import Model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AppointmentAccess {

    public static int appointmentIndex = 0;

    public static ObservableList<Appointment> getAppointments() throws SQLException {
        System.out.println("****Adding Appointments****");
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
         appointmentIndex = id;
        }
        System.out.println(appData.size() + " Appointments have been added.");
        System.out.println((appointmentIndex + 1) + " is the current index to be added next.");
        System.out.println("Complete");
        return appData;
    }

    public static void addAppointment(Appointment appointment) {

        try {
            System.out.println("****Attempting to add new appointment****");
            PreparedStatement st = JDBC.connection.prepareStatement(
                            "INSERT INTO appointments (Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update, Customer_ID, User_ID, Contact_ID)" +
                                    ("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"));
            st.setString(1, appointment.getTitle());
            st.setString(2, appointment.getDescription());
            st.setString(3, appointment.getLocation());
            st.setString(4, appointment.getType());
            st.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            st.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            st.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            st.setString(8, "user");
            st.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
            st.setInt(10, appointment.getCustomerID());
            st.setInt(11, appointment.getUserID());
            st.setInt(12, appointment.getContactID());
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
