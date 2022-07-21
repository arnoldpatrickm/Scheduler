package DAL;

import DAO.DivisionAccess;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DivisionLayer {

    public static ObservableList<Division> allDivisions = FXCollections.observableArrayList();
    public static ObservableList<Division> unitedStatesDvisions = FXCollections.observableArrayList();
    public static ObservableList<Division> unitedKingdomDivisions = FXCollections.observableArrayList();
    public static ObservableList<Division> canadaDivisions = FXCollections.observableArrayList();

    public static ObservableList<Division> getAllDivisions() {
        return allDivisions;
    }

    public static void setAllDivisions(ObservableList<Division> allDivisions) {
        DivisionLayer.allDivisions = allDivisions;
    }

    public static ObservableList<Division> getUnitedStatesDvisions() {
        return unitedStatesDvisions;
    }

    public static void setUnitedStatesDvisions(ObservableList<Division> unitedStatesDvisions) {
        DivisionLayer.unitedStatesDvisions = unitedStatesDvisions;
    }

    public static ObservableList<Division> getUnitedKingdomDivisions() {
        return unitedKingdomDivisions;
    }

    public static void setUnitedKingdomDivisions(ObservableList<Division> unitedKingdomDivisions) {
        DivisionLayer.unitedKingdomDivisions = unitedKingdomDivisions;
    }

    public static ObservableList<Division> getCanadaDivisions() {
        return canadaDivisions;
    }

    public static void setCanadaDivisions(ObservableList<Division> canadaDivisions) {
        DivisionLayer.canadaDivisions = canadaDivisions;
    }

    public static void assignDivisions() {
        for (Division division : DivisionLayer.getAllDivisions()) {
        if (division.getCountryCode() == 1) {
            unitedStatesDvisions.add(division);
        }
        else if (division.getCountryCode() == 2) {
            unitedKingdomDivisions.add(division);
        }
        else canadaDivisions.add(division);
        }
    }

    public static ObservableList<Division> whichCountry(int divID) {
        if (divID <= 54) {
           return getUnitedStatesDvisions();
        }
        else if (divID >= 60 && divID <= 72) {
           return getCanadaDivisions();
        }
        else return getUnitedKingdomDivisions();
    }

    public static Division whichDivision(int divID) {
        for (Division division : whichCountry(divID)) {
            if (division.getDivisionID() == divID)
            return division;
        }
        Division newDivision = new Division(-1, null, -1);
        System.out.println("Something has gone wrong while finding the division!");
        return newDivision;
    }
}

