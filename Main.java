package contactapp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = PhoneBook.loadContactsFromFile("contacts.ser");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. List Contacts");
            System.out.println("5. Search Contact");
            System.out.println("6. Save Contacts");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    String phoneNumber;
                    do {
                        System.out.print("Enter phone number (10 digits): ");
                        phoneNumber = scanner.nextLine();
                    } while (!isValidPhoneNumber(phoneNumber));
                    String email;
                    do {
                        System.out.print("Enter email: ");
                        email = scanner.nextLine();
                    } while (!isValidEmail(email));
                    Contact contact = new Contact(name, phoneNumber, email);
                    phoneBook.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter the name of the contact to delete: ");
                    String nameToDelete = scanner.nextLine();
                    phoneBook.deleteContact(nameToDelete);
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to update: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    String newPhoneNumber;
                    do {
                        System.out.print("Enter new phone number (10 digits): ");
                        newPhoneNumber = scanner.nextLine();
                    } while (!isValidPhoneNumber(newPhoneNumber));
                    String newEmail;
                    do {
                        System.out.print("Enter new email: ");
                        newEmail = scanner.nextLine();
                    } while (!isValidEmail(newEmail));
                    Contact newContact = new Contact(newName, newPhoneNumber, newEmail);
                    phoneBook.updateContact(nameToUpdate, newContact);
                    break;
                case 4:
                    phoneBook.listContacts();
                    break;
                case 5:
                    System.out.print("Enter name or phone number to search: ");
                    String searchTerm = scanner.nextLine();
                    Contact foundContact = phoneBook.searchContact(searchTerm);
                    if (foundContact != null) {
                        System.out.println("Contact found: " + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 6:
                    phoneBook.saveContactsToFile("contacts.ser");
                    break;
                case 7:
                    System.out.println("Exiting Phone Book. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
