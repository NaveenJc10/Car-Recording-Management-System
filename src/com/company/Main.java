package com.company;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    // Main class scope variables
    private static final int MAX_SIZE = 100; // for setting record limit

    public static void main(String[] args) {
        // Menu variables
        ArrayList<Car> carArrayList = new ArrayList<Car>();
        int menuInput = 0;
        char exitInput;
        boolean hasError = false, isEnded = false;
        Scanner scanner = new Scanner(System.in);

        // Prompt user to log in
        Login login = new Login();
        System.out.println("\nWelcome to Car Inventory Management System.");

        // Menu loop
        do {
            // Print menu header
            System.out.println();
            System.out.print(String.format("%44s", "=\n").replace(' ', '='));
            System.out.print(String.format("%24s", "MENU\n"));
            System.out.print(String.format("%44s", "=\n").replace(' ', '='));
            // Print menu options
            System.out.print(String.format("%12s", "") + "1. Add record\n");
            System.out.print(String.format("%12s", "") + "2. Delete record\n");
            System.out.print(String.format("%12s", "") + "3. Edit record\n");
            System.out.print(String.format("%12s", "") + "4. Search record\n");
            System.out.print(String.format("%12s", "") + "5. Display all records\n");
            System.out.print(String.format("%12s", "") + "6. Exit\n\n");

            // Get user's selection input
            do {
                // Catch InputMismatchException (invalid data type input)
                try {
                    System.out.print("Selection: ");
                    menuInput = scanner.nextInt();
                    if (menuInput < 1 || menuInput > 6)
                        System.out.println("Invalid input, please choose from 1 - 6.");
                    else
                        hasError = false;
                } catch (InputMismatchException e) {
                    hasError = true;
                    System.out.println("Invalid input, please choose from 1 - 6.");
                    scanner.nextLine();
                }
            } while (menuInput < 1 || menuInput > 6 || hasError);
            System.out.println();

            // Process input, redirect user to selected function
            if (menuInput == 1) {
                createRecord(carArrayList);
            } else if (menuInput == 2) {
                deleteRecord(carArrayList);
            } else if (menuInput == 3) {
                editRecord(carArrayList);
            } else if (menuInput == 4) {
                searchRecord(carArrayList);
            } else if (menuInput == 5) {
                displayRecords(carArrayList);
            } else if (menuInput == 6) {
                // Exit confirmation
                do {
                    System.out.print("Are you sure? (Y/N): ");
                    exitInput = Character.toUpperCase(scanner.next().charAt(0));
                    if (exitInput != 'Y' && exitInput != 'N')
                        System.out.println("Invalid input, please enter 'Y' or 'N'.");
                } while (exitInput != 'Y' && exitInput != 'N');
                // Exit if 'Y', return to menu if 'N'
                if (exitInput == 'Y')
                    isEnded = true;
                else if (exitInput == 'N')
                    isEnded = false;
            }
        } while (!isEnded);
    }

    public static void createRecord(ArrayList<Car> cars) {
        // Variable declarations
        String plateNumber, brand, model, type, colour, status;
        double price = 0;
        boolean isUnique = true, hasError = false;
        // Instantiate Scanner object
        Scanner scanner = new Scanner(System.in);

        // If Car array is full, cancel, else continue
        if (cars.size() >= MAX_SIZE) {
            System.out.println("* * * Maximum amount of records reached, unable to add new record. * * *");
        } else {
            // Prompt user for input
            System.out.println("Please enter details of the car.");
            System.out.print(String.format("%50s", "-\n").replace(' ', '-'));
            // Ensure plateNumber is unique
            do {
                plateNumber = getString("Plate Number", 12);
                // Cancel checking if there are no existing records yet
                if (cars.size() == 0)
                    isUnique = true;
                // Check if plateNumber already exists
                for (int i = 0; i < cars.size(); i++) {
                    if (plateNumber.equals(cars.get(i).getPlateNumber())) {
                        System.out.println("Invalid input, there is an existing car record with this plate number.");
                        isUnique = false;
                        break;
                    }
                    // Set isUnique to true if input passes the checking
                    if (i == cars.size() - 1)
                        isUnique = true;
                }
            } while (!isUnique);

            brand = getString("Brand", 16);
            model = getString("Model", 16);
            type = getString("Type", 16);
            colour = getString("Colour", 16);
            status = getString("Status", 16);

            do {
                // Catch InputMismatchException (invalid data type input)
                try {
                    System.out.print("Price: ");
                    price = scanner.nextDouble();
                    if (price < 0)
                        System.out.println("Invalid input, Price cannot be negative.");
                    else
                        hasError = false;
                } catch (InputMismatchException e) {
                    hasError = true;
                    System.out.println("Invalid input, please enter numbers only.");
                    scanner.nextLine(); // next() discards the token(input)
                }
            } while (price < 0 || hasError);

            // Prompt user to confirm new record
            char confInput;
            System.out.println();
            do {
                System.out.print("Confirm new Car record? (Y/N): ");
                confInput = Character.toUpperCase(scanner.next().charAt(0));
                if (confInput != 'Y' && confInput != 'N')
                    System.out.println("Invalid input, please enter 'Y' or 'N'.");
            } while (confInput != 'Y' && confInput != 'N');

            // Add car record into array if Y, cancel if N
            if (confInput == 'Y') {
                Car carObj = new Car(plateNumber, brand, model, type, colour, status, price);
                cars.add(carObj);
                System.out.println("\n+ + + New Car record has been added. + + +");
                // Notify user if Car array is full
                if (cars.size() == MAX_SIZE)
                    System.out.println("\n* * * MAXIMUM AMOUNT OF RECORDS HAS BEEN REACHED * * *");
            } else if (confInput == 'N') {
                System.out.println("\n* * * Process cancelled, returning to menu. * * *");
            }
        }
    }

    public static void deleteRecord(ArrayList<Car> cars) {
        // Variable declarations
        String plateNumber;
        char delInput;
        int delIndex = 0;
        boolean isFound = false;
        // Instantiate Scanner object
        Scanner scanner = new Scanner(System.in);

        // Check if car array is empty
        if (cars.size() == 0) {
            System.out.println("There are no existing car records in the system for you to delete.");
        } else {
            // Get plateNumber
            System.out.println("Please enter the Plate Number of the car you want to delete.");
            System.out.print(String.format("%70s", "-\n").replace(' ', '-'));
            plateNumber = getString("Plate Number", 12);
            // Check for car with matching plateNumber
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getPlateNumber().compareToIgnoreCase(plateNumber) == 0) {
                    System.out.println("\nCar with Plate Number " + "\"" + plateNumber + "\"" + " found." +
                            " Displaying its details: ");
                    System.out.print(String.format("%70s", "-\n").replace(' ', '-'));
                    System.out.print(String.format("%-30s", "Brand: " + cars.get(i).getBrand()));
                    System.out.print(String.format("%-30s", "Model: " + cars.get(i).getModel()));
                    System.out.println();
                    System.out.print(String.format("%-30s", "Type: " + cars.get(i).getType()));
                    System.out.print(String.format("%-30s", "Colour: " + cars.get(i).getColour()));
                    System.out.println();
                    System.out.print(String.format("%-30s", "Status: " + cars.get(i).getStatus()));
                    System.out.printf("Price: %.2f\n", cars.get(i).getPrice());
                    delIndex = i;
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                // Ask user if they want to delete the chosen car record
                do {
                    System.out.print("\nAre you sure you want to delete this car record? (Y/N): ");
                    delInput = Character.toUpperCase(scanner.next().charAt(0));
                    if (delInput != 'Y' && delInput != 'N')
                        System.out.println("Invalid input, please enter 'Y' or 'N'.");
                } while (delInput != 'Y' && delInput != 'N');
                // Delete if 'Y', cancel if 'N'
                if (delInput == 'Y') {
                    cars.remove(delIndex);
                    System.out.println("\n- - - The car record of " + plateNumber + " has been deleted. - - -");
                } else if (delInput == 'N') {
                    System.out.println("\n* * * Process cancelled, returning to menu. * * *");
                }
            } else {
                System.out.println("\nNo such car record found, returning to menu.");
            }
        }
    }

    public static void editRecord(ArrayList<Car> cars) {
        // Variable declarations
        String plateNumber, brand, model, type, colour, status;
        double price = 0;
        int editChoice = 0, matchedIndex = 0;
        boolean isFound = false;
        // Instantiate Scanner object
        Scanner scanner = new Scanner(System.in);

        // Check if Car array is empty
        if (cars.size() == 0) {
            System.out.println("There are no existing car records in the system for you to edit.");
        } else {
            // Get plateNumber input
            System.out.println("Please enter the Plate Number of the car you want to edit.");
            System.out.print(String.format("%70s", "-\n").replace(' ', '-'));
            plateNumber = getString("Plate Number", 12);
            // Check for car with matching plateNumber
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getPlateNumber().compareToIgnoreCase(plateNumber) == 0) {
                    matchedIndex = i;
                    isFound = true;
                }
            }
            // If matching plateNumber is found, allow user to edit the car record
            if (!isFound) {
                System.out.println("\nNo such car record found, returning to menu.");
            } else {
                // Display current details of the car record
                System.out.println("\nCar with Plate Number " + "\"" + plateNumber + "\"" + " found." +
                        " Displaying its details: ");
                System.out.print(String.format("%70s", "-\n").replace(' ', '-'));
                System.out.print(String.format("%-30s", "Brand: " + cars.get(matchedIndex).getBrand()));
                System.out.print(String.format("%-30s", "Model: " + cars.get(matchedIndex).getModel()));
                System.out.println();
                System.out.print(String.format("%-30s", "Type: " + cars.get(matchedIndex).getType()));
                System.out.print(String.format("%-30s", "Colour: " + cars.get(matchedIndex).getColour()));
                System.out.println();
                System.out.print(String.format("%-30s", "Status: " + cars.get(matchedIndex).getStatus()));
                System.out.printf("Price: %.2f\n", cars.get(matchedIndex).getPrice());

                // Loop for edit record
                System.out.println("\nPlease select the data that you want to edit.");
                System.out.print(String.format("%70s", "-\n").replace(' ', '-'));
                do {
                    // Submenu for edit record
                    System.out.print(String.format("%-20s", "1. Plate Number"));
                    System.out.println("5. Colour");
                    System.out.print(String.format("%-20s", "2. Brand"));
                    System.out.println("6. Status");
                    System.out.print(String.format("%-20s", "3. Model"));
                    System.out.println("7. Price");
                    System.out.print(String.format("%-20s", "4. Type"));
                    System.out.println("8. Back to main menu\n");
                    // Get input for user's choice
                    do {
                        try {
                            System.out.print("Selection: ");
                            editChoice = scanner.nextInt();
                            System.out.println();
                            if (editChoice < 1 || editChoice > 8)
                                System.out.println("Invalid input, please choose from 1 - 8.");
                        } catch (InputMismatchException e) {
                            editChoice = 0; // setting editChoice to a value outside 1 - 8 continues the loop
                            System.out.println("Invalid input, please enter numbers only.");
                            scanner.nextLine();
                        }
                    } while (editChoice < 1 || editChoice > 8);

                    // Allow user to edit selected data
                    if (editChoice == 1) {
                        // Edit plate number
                        // Ensure plateNumber is unique
                        boolean isUnique = false;
                        do {
                            plateNumber = getString("Plate Number", 12);
                            for (int i = 0; i < cars.size(); i++) {
                                if (cars.get(i).getPlateNumber().equals(plateNumber)) {
                                    System.out.println("Invalid input, there is an existing car record with this plate number.");
                                    isUnique = false;
                                    break;
                                }
                                if (i == cars.size() - 1)
                                    isUnique = true;
                            }
                        } while (!isUnique);
                        // Set new plateNumber
                        cars.get(matchedIndex).setPlateNumber(plateNumber);
                        System.out.println("\n+ + + Plate Number successfully changed. + + +\n");
                    } else if (editChoice == 2) {
                        // Edit brand
                        brand = getString("Brand", 16);
                        cars.get(matchedIndex).setBrand(brand);
                        System.out.println("\n+ + + Brand successfully changed. + + +\n");
                    } else if (editChoice == 3) {
                        // Edit model
                        model = getString("Model", 16);
                        cars.get(matchedIndex).setModel(model);
                        System.out.println("\n+ + + Model successfully changed. + + +\n");
                    } else if (editChoice == 4) {
                        // Edit type
                        type = getString("Type", 16);
                        cars.get(matchedIndex).setType(type);
                        System.out.println("\n+ + + Type successfully changed. + + +\n");
                    } else if (editChoice == 5) {
                        colour = getString("Colour", 16);
                        cars.get(matchedIndex).setColour(colour);
                        System.out.println("\n+ + + Colour successfully changed. + + +\n");
                    } else if (editChoice == 6) {
                        status = getString("Status", 16);
                        cars.get(matchedIndex).setStatus(status);
                        System.out.println("\n+ + + Status successfully changed. + + +\n");
                    } else if (editChoice == 7) {
                        // Edit price
                        do {
                            // Catch InputMismatchException (invalid data type input)
                            try {
                                System.out.print("Price: ");
                                price = scanner.nextDouble();
                                if (price < 0)
                                    System.out.println("Invalid input, Price cannot be negative.");
                            } catch (InputMismatchException e) {
                                price = -69; // setting price to a negative integer continues the loop
                                System.out.println("Invalid input, please enter numbers only.");
                                scanner.nextLine();
                            }
                        } while (price < 0);
                        cars.get(matchedIndex).setPrice(price);
                        System.out.println("\n+ + + Price successfully changed. + + +\n");
                    } else if (editChoice == 8) {
                        // Back to main menu
                        System.out.println("Returning to main menu.");
                        break;
                    }
                } while(true);
            }
        }
    }

    public static void searchRecord(ArrayList<Car> cars) {
        // Variable declarations
        String plateNumber;
        char contInput;
        boolean isFound = false, isStopped = false;
        Scanner scanner = new Scanner(System.in);

        // Check if cars array is empty
        if (cars.size() == 0) {
            System.out.println("There are no existing car records in the system for you to search.");
        } else {
            do {
                // Get plateNumber input
                System.out.println("\nPlease enter the Plate Number of the car you want to search.");
                System.out.print(String.format("%70s", "-\n").replace(' ', '-'));
                plateNumber = getString("Plate Number", 12);

                // Check for car with matching plateNumber in array
                for (int i = 0; i < cars.size(); i++) {
                    // Print the car details if found
                    if (cars.get(i).getPlateNumber().compareToIgnoreCase(plateNumber) == 0) {
                        System.out.println("\nCar with Plate Number " + "\"" + plateNumber + "\"" + " found." +
                                " Displaying its details: ");
                        System.out.print(String.format("%70s", "-\n").replace(' ', '-'));
                        System.out.print(String.format("%-30s", "Brand: " + cars.get(i).getBrand()));
                        System.out.print(String.format("%-30s", "Model: " + cars.get(i).getModel()));
                        System.out.println();
                        System.out.print(String.format("%-30s", "Type: " + cars.get(i).getType()));
                        System.out.print(String.format("%-30s", "Colour: " + cars.get(i).getColour()));
                        System.out.println();
                        System.out.print(String.format("%-30s", "Status: " + cars.get(i).getStatus()));
                        System.out.printf("Price: %.2f\n", cars.get(i).getPrice());
                        isFound = true;
                        break;
                    } else {
                        isFound = false;
                    }
                }
                if (!isFound)
                    System.out.println("\nNo such car record found.");

                // Ask user if they want to continue searching
                do {
                    System.out.print("\nDo you want to continue searching? (Y/N): ");
                    contInput = Character.toUpperCase(scanner.next().charAt(0));
                    if (contInput == 'Y')
                        isStopped = false;
                    else if (contInput == 'N')
                        isStopped = true;
                    else
                        System.out.println("Invalid input, please enter 'Y' or 'N'.\n");
                } while (contInput != 'Y' && contInput != 'N');
            } while (!isStopped);
        }
    }

    public static void displayRecords(ArrayList<Car> cars) {
        Scanner scanner = new Scanner(System.in);
        // If cars array is not empty, print records
        if (cars.size() != 0) {
            // Print table header
            System.out.println(String.format("%140s", "=").replace(' ', '='));
            System.out.print("No.   "); // numbering
            System.out.print(String.format("%-16s", "Plate Number"));
            System.out.print(String.format("%-20s", "Brand"));
            System.out.print(String.format("%-20s", "Model"));
            System.out.print(String.format("%-20s", "Type"));
            System.out.print(String.format("%-20s", "Colour"));
            System.out.print(String.format("%-20s", "Status"));
            System.out.print(String.format("%-16s", "Price"));
            System.out.println();
            System.out.println(String.format("%140s", "=").replace(' ', '='));
            // Print table contents
            for (int i = 0; i < cars.size(); i++) {
                System.out.print((i+1) + "     "); // numbering
                System.out.print(String.format("%-16s", cars.get(i).getPlateNumber()));
                System.out.print(String.format("%-20s", cars.get(i).getBrand()));
                System.out.print(String.format("%-20s", cars.get(i).getModel()));
                System.out.print(String.format("%-20s", cars.get(i).getType()));
                System.out.print(String.format("%-20s", cars.get(i).getColour()));
                System.out.print(String.format("%-20s", cars.get(i).getStatus()));
                System.out.print(String.format("%-16.2f", cars.get(i).getPrice()));
                System.out.println();
            }
        } else {
            // Display no records if array is empty
            System.out.println(String.format("%70s", "=").replace(' ', '='));
            System.out.format("%40s", "NO RECORDS\n");
            System.out.println(String.format("%70s", "=").replace(' ', '='));
        }
        System.out.print("\nPRESS ENTER TO RETURN TO MAIN MENU");
        scanner.nextLine();
    }

    // Helper method for getting String inputs with checking and validation
    public static String getString(String text, int limit) {
        String strInput;
        boolean hasChars;
        // Instantiate Scanner object
        Scanner scanner = new Scanner(System.in);
        do {
            hasChars = false;
            System.out.print(text + ": ");
            strInput = scanner.nextLine();
            // Check if the string has any characters excluding spaces
            for (int i = 0; i < strInput.length(); i++) {
                if (strInput.charAt(i) != ' ') {
                    hasChars = true;
                    break;
                }
            }
            // Check if the string is valid
            if (strInput.isEmpty() || !hasChars)
                System.out.println("Invalid input, " + text + " cannot be empty.");
            else if (strInput.length() > limit)
                System.out.println(text + " cannot be longer than " + limit + " characters, please try again.");
        } while (strInput.isEmpty() || !hasChars || strInput.length() > limit);

        return strInput.trim();
    }
}