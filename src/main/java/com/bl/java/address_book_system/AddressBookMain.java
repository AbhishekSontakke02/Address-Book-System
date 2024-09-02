package com.bl.java.address_book_system;

class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    String email;
    String phoneNo;

    public Contact(String firstName, String lastName, String address, String city, String state, int zip,String email,String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    @Override
    public String toString(){
        System.out.println("Contact Name : "+firstName+" "+lastName);
        System.out.println("Contact Address : "+address);
        System.out.println("Contact City : "+city);
        System.out.println("Contact State : "+state);
        System.out.println("Contact Zip : "+zip);
        System.out.println("Contact Phone No : "+phoneNo);
        System.out.println("Contact Email : "+email);
        return"";
    }

}



public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Address Book\n");
        Contact contact = new Contact("Abhishek", "Sontakke", "002,Sai Samartha Blessings", "Panvel", "Maharashtra", 410206,"abhisontakke3930@gmail.com", "7977467636");
        System.out.println(contact);
    }
}
