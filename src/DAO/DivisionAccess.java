package DAO;

import DAL.DivisionLayer;
import Helper.JDBC;
import Model.Customer;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionAccess {

    public static void getDivisions() throws SQLException {
        System.out.println("****Gathering divisions****");
        ObservableList<Division> regionData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM FIRST_LEVEL_DIVISIONS";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int divisionID = rs.getInt("Division_ID");
            String division = rs.getString("Division");
            int countryID = rs.getInt("Country_ID");
            DivisionLayer.allDivisions.add(new Division(divisionID, division, countryID));
        }
        DivisionLayer.assignDivisions();

        System.out.println("There are " + DivisionLayer.getAllDivisions().size() + " added Regions in all");
        System.out.println("Regions being sorted");
        System.out.println("There are " + DivisionLayer.getUnitedStatesDvisions().size() + " added States for the United States");
        System.out.println("There are " + DivisionLayer.getUnitedKingdomDivisions().size() + " added Regions for the United Kingdom");
        System.out.println("There are " + DivisionLayer.getCanadaDivisions().size() + " added Regions for Canada");
        System.out.println("Complete");
    }
}
