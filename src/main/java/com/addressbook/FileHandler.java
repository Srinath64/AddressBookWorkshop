package com.addressbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    public void readFromFile() {
        Path path = Paths.get("src/main/resources/AddressBook.txt");

        try {
            System.out.println(Files.readAllLines(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void writeIntoFile(String adBookName, AddressBookService adBookHandler) {

        AddressBook adBook = adBookHandler.findAddressBook(adBookName);
        Path path = Paths.get("src/main/resources/AddressBook.txt");

        try {
            Files.write(path, adBook.addressBook.toString().getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Method to write into csv files
    public void writeCSVFile(String adBookName, AddressBookService adBookHandler) {

        AddressBook adBook = adBookHandler.findAddressBook(adBookName);

        try {
            CSVWriter csv = new CSVWriter(new FileWriter("src/main/resources/AddressBook.csv"));
            for (Contact contact : adBook.addressBook) {
                String writer[] = new String[] { contact.getFirstName(), contact.getLastName(), contact.getAddress(),
                        contact.getCity(), contact.getState(), "" + contact.getZip(), "" + contact.getPhone(),
                        contact.getEmail() };
                csv.writeNext(writer);
            }
            csv.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Method to read from csv files
    public void readCSVFile() {

        try {
            CSVReader csv = new CSVReader(new FileReader("src/main/resources/AddressBook.csv"));
            String[] contact;

            while ((contact = csv.readNext()) != null) {
                Contact newContact = new Contact(contact[0], contact[1], contact[2], contact[3], contact[4],
                        Integer.parseInt(contact[5]), Long.parseLong(contact[6]), contact[7]);
                System.out.println(newContact);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Method to write address book into json file
    public void writeJSONFile(String adBookName, AddressBookService adBookHandler) {

        AddressBook adBook = adBookHandler.findAddressBook(adBookName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String output = gson.toJson(adBook.addressBook);

        try {
            FileWriter fw = new FileWriter("src/main/resources/AddressBook.json");
            fw.write(output);
            fw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // Method to read address book data from json file
    public void readJSONFile() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader fr = new FileReader("src/main/resources/AddressBook.json");

            System.out.println(gson.fromJson(fr, Object.class));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
