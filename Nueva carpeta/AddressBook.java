import java.io.*;
import java.util.HashMap;

public class AddressBook {
    private HashMap<String, Contact> contacts;

    public AddressBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getEmail())) {
            System.out.println("A contact with this email already exists.");
        } else {
            contacts.put(contact.getEmail(), contact);
            System.out.println("Contact added successfully.");
        }
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("The address book is empty.");
        } else {
            for (Contact contact : this.contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    public void searchContact(String email) {
        if (contacts.containsKey(email)) {
            System.out.println(contacts.get(email));
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String email) {
        if (contacts.containsKey(email)) {
            contacts.remove(email);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("No contact found with the provided email.");
        }
    }

    public void storeContacts(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public void loadContacts(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (HashMap<String, Contact>) ois.readObject();
            System.out.println("Contacts loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}