package DAL;

import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerLayer {

    public static ObservableList<Customer> customerData = FXCollections.observableArrayList();

    public static ObservableList<String> comboBoxSelections = FXCollections.observableArrayList();

    public static ObservableList<Customer> getCustomerData() {
        return customerData;
    }

    public static void setCustomerData(ObservableList<Customer> customerData) {
        CustomerLayer.customerData = customerData;
    }

    public static void setComboBoxSelections(ObservableList<String> comboBoxSelections) {
        CustomerLayer.comboBoxSelections = comboBoxSelections;
    }

    public static ObservableList<String> getComboBoxSelections () {
        comboBoxSelections.clear();
        for (Customer customer : customerData) {
            comboBoxSelections.add(customer.getCustomerName());
        }
        return comboBoxSelections;
    }
    public static int getCustomerID (String customerName) {
        for (Customer customer : getCustomerData()) {
            if (customerName == customer.getCustomerName()){
                System.out.println(customer.getCustomerID());
                return customer.getCustomerID();}
        } return 0;
    }
}
