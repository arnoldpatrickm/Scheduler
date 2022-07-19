package DAO;

import Controller.Appointments;
import Helper.JDBC;
import Model.Appointment;
import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerAccess {

    public static ObservableList<Customer> getCustomers() throws SQLException {
        ObservableList<Customer> customerData = FXCollections.observableArrayList();
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
            customerData.add(new Customer(customerID, customerName, address, postalCode, phone, divisionID));
            System.out.println(customerID + customerName + phone);
        }
        return customerData;
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
}
