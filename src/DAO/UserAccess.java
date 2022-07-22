package DAO;

import DAL.CustomerLayer;
import Helper.JDBC;
import Model.Customer;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccess {
    public static User currentUser = null;

    public static boolean userLogin(String userName, String userPassword) throws SQLException {
        System.out.println("****Attempting Login****");
        PreparedStatement st = JDBC.connection.prepareStatement(
                "SELECT * FROM USERS WHERE User_Name = ? AND Password = ?");
        st.setString(1, userName);
        st.setString(2, userPassword);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println("login success");
            return true;
        }
        System.out.println("Login attempt Failed");
        return false;
    }
}
