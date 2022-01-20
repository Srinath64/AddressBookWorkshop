package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println(" Welcome to the Address Book Program");

        Scanner scan = new Scanner(System.in);

        AddressBook adBook = new AddressBook();

        String ch;
        while (true) {
            System.out.println(" ---- MENU ----");
            System.out.println(" 1. Add contacts\n 2. Display contacts\n 3. Edit contacts\n 4. Exit");
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
                    System.out.println(" Good bye!");
                    return;
                default:
                    System.out.println(" Please enter a valid choice: ");
            }
        }
    }
}
