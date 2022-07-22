package DAO;

import DAL.ContactLayer;
import DAL.CustomerLayer;
import Helper.JDBC;
import Model.Appointment;
import Model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ContactAccess {
    public static ObservableList<Contact> getContacts() throws SQLException {
        System.out.println("****Adding Contacts****");
        ObservableList<Contact> contactData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM CONTACTS";
        PreparedStatement ps =  JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
//        Appointments.appData.clear();
        while(rs.next()){
            int contactID = rs.getInt(1);
            String contactName = rs.getString(2);
            String contactEmail = rs.getString(3);

            contactData.add(new Contact(contactID, contactName, contactEmail));
        }
        System.out.println(contactData.size() + " Contacts have been added.");
        ContactLayer.contactData = contactData;
        System.out.println(contactData.size() + " contacts have been added");
        System.out.println("Complete");


        return contactData;
    }
}
