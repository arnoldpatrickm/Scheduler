package Model;

import DAL.DivisionLayer;
import DAO.DivisionAccess;

public class Division {
    private int divisionID;
    private String divisionName;
    private int countryCode;

    public Division (int divisionID, String divisionName, int countryCode){
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryCode = countryCode;
    }
    public Division () {

    }


    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }
}
