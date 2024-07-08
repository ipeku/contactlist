# contactlist
This is a simple contact management code written in Java. It allows users to add, delete, update, list, search, and save contacts. The contacts are saved to a file using serialization for persistence.

## Features

- **Add Contact**: 
  - **Name Validation**: Ensures the name is not empty and contains only valid characters.
  - **Phone Number Validation**: Accepts only 10-digit numbers to ensure consistency.
  - **Email Validation**: Checks the email format to ensure it is valid.
- **Delete Contact**: 
  - **By Name**: Remove a contact by providing the exact name. Case-sensitive.
- **Update Contact**: 
  - **Flexible Update**: Allows updating of the name, phone number, and email of an existing contact.
  - **Validation**: Ensures new details are valid before updating.
- **List Contacts**: 
  - **Display All**: Shows a list of all contacts with their details (name, phone number, and email).
  - **Formatted Output**: Neatly formatted for easy reading.
- **Search Contact**: 
  - **By Name or Phone Number**: Allows searching by either name or phone number.
  - **Partial Matches**: Supports partial matches to find contacts easily.
- **Save Contacts**: 
  - **Serialization**: Saves the current list of contacts to a file (`contacts.ser`) using Java serialization.
  - **Error Handling**: Ensures that errors during the save process are caught and reported.
- **Load Contacts**: 
  - **Startup Load**: Loads the list of contacts from a file (`contacts.ser`) at startup.
  - **Error Handling**: Ensures that errors during the load process are caught and reported.
