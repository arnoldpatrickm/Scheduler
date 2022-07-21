package Model;

import DAL.DivisionLayer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;

public class Customer {
    private int customerID;
    private String customerName;
    private String address;
    private String postalCode;
    private String phone;
    private String country;
    private String region;
    private int divisionID;

    public Customer(int customerID, String customerName, String customerAddress, String customerZip, String customerPhone, String customerCountry, String customerRegion) {
        this.customerID = customerID;
        this.customerName = customerName;
        address = customerAddress;
        postalCode = customerZip;
        phone = customerPhone;
        country = customerCountry;
        region = customerRegion;

    }
    public Customer (int customerID, String customerName, String address, String postalCode, String phone, int divisionID) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.divisionID = divisionID;
    }

    public String getCountry() {
        int countryNumber = DivisionLayer.whichDivision(divisionID).getCountryCode();

        if (countryNumber == 1) {
            return "United States";
        }
        else if (countryNumber == 2) {
            return "United Kingdom";
        }
        else {
            return "Canada";
        }
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return DivisionLayer.whichDivision(divisionID).getDivisionName();
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }
}

