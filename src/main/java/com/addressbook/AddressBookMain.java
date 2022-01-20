package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println(" Welcome to the Address Book Program");

        Scanner scan = new Scanner(System.in);

        AddressBookService adBook = new AddressBookService();

        // The choice is stored in this variable
        String ch;

        // This will display the menu in a loop until the user stops it
        while (true) {
            System.out.println(" ---- MENU ----");
            System.out.println(" 1. Add contacts\n 2. Display contacts\n 3. Edit contacts\n 4. Delete contact\n"
                    + " 5. Add address book\n 6. Search for contact\n 7. Exit");
            System.out.print("\n Please enter your choice: ");

            ch = scan.next();

            switch (ch) {

                case "1":
                    adBook.addContact();
                    break;

                case "2":
                    adBook.displayContacts();
                    break;

                case "3":
                    adBook.editContact();
                    break;

                case "4":
                    adBook.deleteContact();
                    break;

                case "5":
                    adBook.addAddressBook();
                    break;

                case "6":
                    System.out.print(" Please enter the name of the contact you want to find: ");
                    String name = scan.next();

                    System.out.print(" Please enter to search by city or state(city/state): ");
                    String choice = scan.next();

                    System.out.print(" Please enter the location: ");
                    String location = scan.next();

                    adBook.searchCityState(name, location, choice);

                case "7":
                    System.out.println(" Good bye!");
                    return;

                default:
                    System.out.println(" Please enter a valid choice: ");
            }
        }
    }
}