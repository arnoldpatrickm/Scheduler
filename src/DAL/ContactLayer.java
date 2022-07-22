package DAL;

import Model.Contact;
import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactLayer {
    public static ObservableList<Contact> contactData = FXCollections.observableArrayList();
    public static ObservableList<String> comboBoxSelections = FXCollections.observableArrayList();


    public static ObservableList<String> getComboBoxSelections () {
        comboBoxSelections.clear();
        for (Contact contact : contactData) {
            comboBoxSelections.add(contact.getContactName());
        }
        return comboBoxSelections;
    }
    public static int getContactID (String customerName) {
        for (Contact contact : contactData) {
            if (customerName == contact.getContactName()){
                System.out.println(contact.getContactName());
                return contact.getContactID();}
        } return 0;
    }
}
