package com.bl.java.address_book_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    String email;
    String phoneNo;

    // Constructor with parameters
    public Contact(String firstName, String lastName, String address, String city, String state, int zip, String email, String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    // Default constructor
    public Contact() {
    }

    // Getters and Setters
    // ...

    @Override
    public String toString(){
        return "Contact Name: " + firstName + " " + lastName + "\n" +
                "Contact Address: " + address + "\n" +
                "Contact City: " + city + "\n" +
                "Contact State: " + state + "\n" +
                "Contact Zip: " + zip + "\n" +
                "Contact Phone No: " + phoneNo + "\n" +
                "Contact Email: " + email + "\n";
    }
}

class AddressBook {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contactList = new ArrayList<>();

    public void addContact(){
        System.out.println("Enter Contact Details");
        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter City: ");
        String city = scanner.nextLine();
        System.out.println("Enter State: ");
        String state = scanner.nextLine();
        System.out.println("Enter Zip code:");
        int zip = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Phone No: ");
        String phoneNo = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(firstName, lastName, address, city, state, zip, email, phoneNo);
        contactList.add(contact);
        System.out.println("\nContact Added Successfully...\n");
        System.out.println("=====================================");
    }

    public void editContact(String name){
        boolean flag = false;
        for (Contact contact : contactList) {
            if (name.equalsIgnoreCase(contact.firstName)) {
                flag = true;
                System.out.println("Enter what to update:");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Address");
                System.out.println("4. City");
                System.out.println("5. State");
                System.out.println("6. Zip");
                System.out.println("7. Phone Number");
                System.out.println("8. Email");
                System.out.println("9. Update All");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter First Name: ");
                        contact.firstName = scanner.nextLine();
                        break;

                    case 2:
                        System.out.println("Enter Last Name: ");
                        contact.lastName = scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("Enter Address: ");
                        contact.address = scanner.nextLine();
                        break;

                    case 4:
                        System.out.println("Enter City: ");
                        contact.city = scanner.nextLine();
                        break;

                    case 5:
                        System.out.println("Enter State: ");
                        contact.state = scanner.nextLine();
                        break;

                    case 6:
                        System.out.println("Enter Zip Code: ");
                        contact.zip = scanner.nextInt();
                        scanner.nextLine();
                        break;

                    case 7:
                        System.out.println("Enter Phone Number: ");
                        contact.phoneNo = scanner.nextLine();
                        break;

                    case 8:
                        System.out.println("Enter Email: ");
                        contact.email = scanner.nextLine();
                        break;

                    case 9:
                        System.out.println("Enter Contact Details\n");
                        System.out.println("Enter First Name: ");
                        contact.firstName = scanner.nextLine();
                        System.out.println("Enter Last Name: ");
                        contact.lastName = scanner.nextLine();
                        System.out.println("Enter Address: ");
                        contact.address = scanner.nextLine();
                        System.out.println("Enter City: ");
                        contact.city = scanner.nextLine();
                        System.out.println("Enter State: ");
                        contact.state = scanner.nextLine();
                        System.out.println("Enter Zip code: ");
                        contact.zip = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Phone No: ");
                        contact.phoneNo = scanner.nextLine();
                        System.out.println("Enter Email: ");
                        contact.email = scanner.nextLine();
                        break;

                    default:
                        System.out.println("Wrong input");
                        break;
                }
                break;
            }
        }
        if (flag) {
            System.out.println("Contact Updated Successfully...");
        } else {
            System.out.println("Contact Not Found for " + name);
        }
    }

    public void deleteContact(String name){
        Contact tempContact = null;
        for (Contact contact : contactList) {
            if (name.equals(contact.firstName)) {
                tempContact = contact;
                break;
            }
        }
        if (tempContact != null) {
            contactList.remove(tempContact);
            System.out.println("Contact Deleted Successfully...!");
        } else {
            System.out.println("Contact Not Found for " + name);
        }
    }

    public void displayContacts(){
        if (contactList.isEmpty()) {
            System.out.println("No Contacts Available.");
        } else {
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
        }
    }
}

public class AddressBookMain {
    private Map<String, AddressBook> addressBooks;

    public AddressBookMain() {
        addressBooks = new HashMap<>();
    }

    public void addAddressBook(String name){
        if (!addressBooks.containsKey(name)) {
            addressBooks.put(name, new AddressBook());
            System.out.println("Address Book created Successfully for " + name);
        } else {
            System.out.println("Address Book with name " + name + " already exists.");
        }
    }

    public AddressBook searchAddressBook(String name){
        return addressBooks.get(name);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n========= Welcome to Address Book Program =========\n");

        AddressBookMain addressBooksManager = new AddressBookMain();

        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("Select Operation");
            System.out.println("1. Create New AddressBook");
            System.out.println("2. Add Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name for new AddressBook: ");
                    String addName = scanner.nextLine();
                    addressBooksManager.addAddressBook(addName);
                    System.out.println("=====================================");
                    break;

                case 2:
                    System.out.println("Enter Name of AddressBook to add Contact: ");
                    String bookName1 = scanner.nextLine();
                     AddressBook addressBook1 = addressBooksManager.searchAddressBook(bookName1);
                    if (addressBook1 != null) {
                        addressBook1.addContact();
                    } else {
                        System.out.println("AddressBook Not Found!");
                    }
                    break;

                case 3:
                    System.out.println("Enter Name of AddressBook to edit Contact: ");
                    String bookName2 = scanner.nextLine();
                    AddressBook addressBook2 = addressBooksManager.searchAddressBook(bookName2);
                    if (addressBook2 != null) {
                        System.out.println("Enter Name to edit Contact: ");
                        String nameToEdit = scanner.nextLine();
                        addressBook2.editContact(nameToEdit);
                        System.out.println("=====================================");
                    } else {
                        System.out.println("AddressBook Not Found!");
                    }
                    break;

                case 4:
                    System.out.println("Enter Name of AddressBook to delete Contact: ");
                    String bookName3 = scanner.nextLine();
                    AddressBook addressBook3 = addressBooksManager.searchAddressBook(bookName3);
                    if (addressBook3 != null) {
                        System.out.println("Enter Name to Delete Contact: ");
                        String nameToDelete = scanner.nextLine();
                        addressBook3.deleteContact(nameToDelete);
                        System.out.println("=====================================");
                    } else {
                        System.out.println("AddressBook Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Enter Name of AddressBook to view Contacts: ");
                    String bookName4 = scanner.nextLine();
                    AddressBook addressBook4 = addressBooksManager.searchAddressBook(bookName4);
                    if (addressBook4 != null) {
                        addressBook4.displayContacts();
                    } else {
                        System.out.println("AddressBook Not Found!");
                    }
                    break;

                case 0:
                    flag = false;
                    break;

                default:
                    System.out.println("\nEnter valid input!");
                    break;
            }
        }

        System.out.println("\nExiting Program...");
        System.out.println("Thank You!");
    }
}
