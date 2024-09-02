package com.bl.java.address_book_system;

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Contact Details");
        System.out.println("Enter First Name ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name : ");
        String lastName = scanner.nextLine();
        System.out.println("Enter Address : ");
        String address = scanner.nextLine();
        System.out.println("Enter City : ");
        String city = scanner.nextLine();
        System.out.println("Enter State : ");
        String state = scanner.nextLine();
        System.out.println("Enter Zip code :");
        int zip = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Phone No : ");
        String phoneNo = scanner.nextLine();
        System.out.println("Enter Email : ");
        String email = scanner.nextLine();

        Contact contact2 = new Contact(firstName, lastName, address, city, state, zip, email, phoneNo);
        System.out.println(contact2);

    }
}
