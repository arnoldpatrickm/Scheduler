package DAO;

import Controller.Appointments;
import DAL.CustomerLayer;
import Helper.JDBC;
import Model.Appointment;
import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CustomerAccess {

    public static int customerIndex = 0;

    public static ObservableList<Customer> getCustomers() throws SQLException {
        System.out.println("****Adding Customers****");
        ObservableList<Customer> cData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM CUSTOMERS";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int customerID = rs.getInt("Customer_ID");
            String customerName = rs.getString("Customer_Name");
            String address = rs.getString("Address");
            String postalCode = rs.getString("Postal_Code");
            String phone = rs.getString("Phone");
            int divisionID = rs.getInt("Division_ID");
            cData.add(new Customer(customerID, customerName, address, postalCode, phone, divisionID));

            if (customerIndex < customerID){customerIndex = customerID;}
        }

        System.out.println(cData.size() + " Customers have been added");
        System.out.println((customerIndex + 1) + " is the current index to be added next.");
        System.out.println("Complete");
        CustomerLayer.customerData = cData;
        return cData;
    }
    public static boolean deleteCustomer(Customer customer) throws SQLException {
        int custID = customer.getCustomerID();
        try {
            System.out.println("****Attempting to delete customer with ID of" + custID + "****");
            PreparedStatement st = JDBC.connection.prepareStatement("DELETE FROM customers WHERE Customer_ID = ?");
            st.setInt(1, custID);
            st.executeUpdate();
            System.out.println("****Customer Deleted!****");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("****Deletion Failed****");
            return false;
        }

    }
    public static void addCustomer(Customer customer) {

        try {
            System.out.println("****Attempting to add new Customer****");
            PreparedStatement st = JDBC.connection.prepareStatement(
                    "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Division_ID)" +
                            ("VALUES (?, ?, ?, ?, ?)"));
            st.setString(1, customer.getCustomerName());
            st.setString(2, customer.getAddress());
            st.setString(3, customer.getPostalCode());
            st.setString(4, customer.getPhone());
            st.setInt(5, customer.getDivisionID());
            st.executeUpdate();
            System.out.println("****New Customer added****");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("****Add Failed****");
        }
    }
}
