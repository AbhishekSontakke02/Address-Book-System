package com.bl.java.address_book_system;

import java.util.*;
import java.util.stream.Collectors;

class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    String email;
    String phoneNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

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
    static Map<String, List<String>> personbyCity = new HashMap<>();
    static Map<String, List<String>> personbyState = new HashMap<>();

    public boolean addContact(){

        System.out.println();
        System.out.println("Enter Contact Details\n");
        System.out.println("Enter First Name :");
        String fname = scanner.nextLine();

        if (contactList.stream().anyMatch(contact->contact.getFirstName().equals(fname))) {
            System.out.println("Person "+ fname +" Already Exists!");
            return false;
        }else{
            System.out.println("Enter Last Name : ");
            String lname = scanner.nextLine();
            System.out.println("Enter Address : ");
            String address = scanner.nextLine();
            System.out.println("Enter City : ");
            String city = scanner.nextLine();
            System.out.println("Enter State : ");
            String state = scanner.nextLine();
            System.out.println("Enter Zip code :");
            int zip = scanner.nextInt();
            System.out.println("Enter Phone No : ");
            String phoneNo = scanner.nextLine();
            System.out.println("Enter Email : ");
            String email = scanner.nextLine();

            Contact contact = new Contact(fname, lname, address, city, state, zip, email, phoneNo);
            contactList.add(contact);
            return true;
        }

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
                        contact.setFirstName(scanner.nextLine());
                        break;

                    case 2:
                        System.out.println("Enter Last Name: ");
                        contact.setLastName(scanner.nextLine());
                        break;

                    case 3:
                        System.out.println("Enter Address: ");
                        contact.setAddress(scanner.nextLine());
                        break;

                    case 4:
                        System.out.println("Enter City: ");
                        contact.setCity(scanner.nextLine());
                        break;

                    case 5:
                        System.out.println("Enter State: ");
                        contact.setState(scanner.nextLine());
                        break;

                    case 6:
                        System.out.println("Enter Zip Code: ");
                        contact.setZip(scanner.nextInt());
                        scanner.nextLine();
                        break;

                    case 7:
                        System.out.println("Enter Phone Number: ");
                        contact.setPhoneNo(scanner.nextLine());
                        break;

                    case 8:
                        System.out.println("Enter Email: ");
                        contact.setEmail(scanner.nextLine());
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
            if (name.equals(contact.getFirstName())) {
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
    public void searchContactByCity(String city) {
        List<Contact> contactsInCity = contactList.stream()
                .filter(contact -> contact.getCity().equals(city))
                .toList();
        if (contactsInCity.isEmpty()) {
            System.out.println("No contacts found in the city: " + city);
        } else {
            contactsInCity.forEach(contact -> System.out.println(contact));
        }
    }

    public void searchContactByState(String state) {
        List<Contact> contactsInState = contactList.stream()
                .filter(contact -> contact.getState().equals(state))
                .toList(); // or use .collect(Collectors.toList()) if using Java version lower than 16

        if (contactsInState.isEmpty()) {
            System.out.println("No contacts found in the state: " + state);
        } else {
            contactsInState.forEach(contact -> System.out.println(contact));
        }
    }
    public Collection<Contact> getContacts() {
        return contactList;
    }


    public List<String> getContactsByCity(String city) {
        return personbyCity.getOrDefault(city, Collections.emptyList());
    }


    public List<String> getContactsByState(String state) {
        return personbyState.getOrDefault(state, Collections.emptyList());
    }




}

public class AddressBookMain {
    private static Map<String, AddressBook> addressBooks;
    static Scanner scanner = new Scanner(System.in);

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
            System.out.println("6. Search Contact by City");
            System.out.println("7. Search Contact by State");
            System.out.println("8. View Contacts by City/State");
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

                case 6:
                    System.out.println("Enter Name of AddressBook to search by City: ");
                    String bookNameByCity = scanner.nextLine();
                    AddressBook addressBookByCity = addressBooksManager.searchAddressBook(bookNameByCity);
                    if (addressBookByCity != null) {
                        System.out.println("Enter City to search: ");
                        String city = scanner.nextLine();
                        addressBookByCity.searchContactByCity(city);
                    } else {
                        System.out.println("AddressBook Not Found!");
                    }
                    break;

                case 7:
                    System.out.println("Enter Name of AddressBook to search by State: ");
                    String bookNameByState = scanner.nextLine();
                    AddressBook addressBookByState = addressBooksManager.searchAddressBook(bookNameByState);
                    if (addressBookByState != null) {
                        System.out.println("Enter State to search: ");
                        String state = scanner.nextLine();
                        addressBookByState.searchContactByState(state);
                    } else {
                        System.out.println("AddressBook Not Found!");
                    }
                    break;
                case 8:
                    viewContactsByCityOrState();
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
    private static void viewContactsByCityOrState() {
        System.out.println("1. View Contacts by City");
        System.out.println("2. View Contacts by State");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();


        switch (choice) {
            case 1:
                viewContactsByCity();
                break;
            case 2:
                viewContactsByState();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }


    private static void viewContactsByCity() {
        System.out.print("Enter City to view contacts: ");
        String city = scanner.nextLine();


        List<String> result = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactsByCity(city).stream())
                .collect(Collectors.toList());


        if (result.isEmpty()) {
            System.out.println("No contacts found in the city.");
        } else {
            result.forEach(System.out::println);
        }
    }


    private static void viewContactsByState() {
        System.out.print("Enter State to view contacts: ");
        String state = scanner.nextLine();


        List<String> result = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactsByState(state).stream())
                .collect(Collectors.toList());


        if (result.isEmpty()) {
            System.out.println("No contacts found in the state.");
        } else {
            result.forEach(System.out::println);
        }
    }

}
