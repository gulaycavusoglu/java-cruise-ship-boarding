/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cruiseship_git;
        
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Cruiseship_git {

    public static void main(String[] args) {
        
         Scanner input = new Scanner(System.in);

        String viewCabins;
        String cmName = null;
        int cabinNum = 1;
        String option;
        String[] cruiseShip = new String[13];

        initialise(cruiseShip);

        while (cabinNum < 13) {

            System.out.println("----------------------------------------------------------------");
            System.out.println("Press V to see the cabins");
            System.out.println("Press A to add customers to the cabins");
            System.out.println("Press Q to see the main menu");
            System.out.println("----------------------------------------------------------------");
            System.out.println("Please use capital letters. Thanks for your understanding!");

            viewCabins = input.next();

            if ("V".equals(viewCabins)) {
                view(cruiseShip, cmName);
            } else if ("A".equals(viewCabins)) {
                System.out.println();
                System.out.println("Enter a cabin number (1-12)");
                cabinNum = input.nextInt();
                System.out.println();
                System.out.println("Enter a name for cabin " + cabinNum + ":");
                cmName = input.next();
                cruiseShip[cabinNum - 1] = cmName;
                add(cruiseShip, cmName);
                System.out.println();
            } else if ("Q".equals(viewCabins)) {
                System.out.println("----------------------------------------------------------");
                System.out.println("Press E to display the empty cabins");
                System.out.println("Press D to delete a customer from a cabin");
                System.out.println("Press F to find a cabin from a customer name");
                System.out.println("Press O to view passengers ordered alphabetically by name");
                System.out.println("----------------------------------------------------------");
                System.out.println("Enter choice (E-D-F-S-L-O)");

                option = input.next();

                switch (option) {
                    case "E":
                        displayEmptyCabins(cruiseShip);
                        break;
                    case "D":
                        view(cruiseShip, cmName);
                        System.out.println("Enter the cabin number from which you want to remove a passenger:");
                        cabinNum = input.nextInt();
                        cruiseShip[cabinNum - 1] = "empty";
                        deletePassenger(cruiseShip, cmName);
                        System.out.println();
                        break;
                    case "F":
                        findCabin(cruiseShip);
                        break;
                    case "O":
                        displayAlphabetically(cruiseShip);
                        break;
                    default:
                        System.out.println("Incorrect key pressed. Please try again.");
                        break;
                }
            }
        }
    }

    private static void initialise(String[] cruiseShip) {
        Arrays.fill(cruiseShip, "empty");
        System.out.println("Welcome to boarding!");
    }

    public static void view(String[] cruiseShip, String passengers) {
        for (int x = 0; x < 12; x++) {
            String customerName = cruiseShip[x];
            if (customerName.equals("empty")) {
                System.out.println("Cabin " + (x + 1) + " is empty");
            } else {
                System.out.println("Cabin " + (x + 1) + " is occupied by " + customerName);
            }
        }
    }

    public static void add(String[] cruiseShip, String passengers) {
        for (int x = 0; x < 12; x++) {
            String customerName = cruiseShip[x];
            if (customerName.equals("empty")) {
                System.out.println("Cabin " + (x + 1) + " is empty");
            } else {
                System.out.println("Cabin " + (x + 1) + " is occupied by " + customerName);
            }
        }
    }

    public static void displayEmptyCabins(String[] cruiseShip) {
        for (int x = 0; x < 12; x++) {
            if (cruiseShip[x].equals("empty")) {
                System.out.println("Cabin " + (x + 1) + " is empty");
            }
        }
    }

    public static void deletePassenger(String[] cruiseShip, String passengers) {
        for (int x = 0; x < 12; x++) {
            String customerName = cruiseShip[x];
            if (customerName.equals("empty")) {
                System.out.println("Cabin " + (x + 1) + " is empty");
            } else {
                System.out.println("Cabin " + (x + 1) + " is occupied by " + customerName);
            }
        }
    }

    public static void findCabin(String[] cruiseShip) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the customer's name you'd like to search for:");
        String customerName = input.next();
        for (int x = 0; x < 12; x++) {
            if (cruiseShip[x].equals(customerName)) {
                System.out.println(customerName + " is in cabin " + (x + 1));
            }
        }
    }

    public static void displayAlphabetically(String[] cruiseShip) {
        String[] sortedCruiseShip = cruiseShip.clone();
        Arrays.sort(sortedCruiseShip);
        System.out.println(Arrays.toString(sortedCruiseShip));
    }
}
