import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, Contact> contacts;

    public AddressBook() {
        this.contacts = new HashMap<>();
        loadContacts();
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getEmail())) {
            System.out.println("A contact with this email already exists.");
        } else {
            contacts.put(contact.getEmail(), contact);
            System.out.println("Contact added successfully.");
            storeContacts();
        }
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("The address book is empty.");
            return;
        }
        for (Contact contact : this.contacts.values()) {
            System.out.println(contact);
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
            storeContacts();
        } else {
            System.out.println("No contact found with the provided email.");
        }
    }

    public void storeContacts() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contacts.dat"))) {
            out.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public void loadContacts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("contacts.dat"))) {
            contacts = (HashMap<String, Contact>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}
