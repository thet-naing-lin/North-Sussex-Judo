package com.lithan.nsj.athleteInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lithan.nsj.Color;

public class Athlete {

    private String name;
    private double currentWeight;

    Scanner scanner = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    /**
     * This method request the user name.
     * Within this method, the user name input will get validation from another method.
     * 
     * @return void method
     */
    public void requestAthleteName() {

        System.out.println("What is you name?");
        String athleteName = scanner.nextLine();
        System.out.println();

        //  checking the user input (valid/invalid)
        if (!isValidName(athleteName)) {
            do {   
                System.out.println(Color.ANSI_RED + "Invalid name, Please try again !" + Color.ANSI_RESET);
                System.out.println();
                System.out.println("What is you name?");
                athleteName = scanner.nextLine();
                System.out.println();
            } while (!isValidName(athleteName));
        }

        // save the athleteName into name
        setName(athleteName);
    }

    /**
     * This method request the user weight.
     * The input validation is handle by catching InputMismatchException.(using try-catch)
     * 
     * @return void method
     */
    public void requestCurrentWeight() {

        do {
            try {
                System.out.println("What is your current weight?");
                double athleteWeight = scanner.nextDouble();
                System.out.println();

                if (athleteWeight <= 0) {
                    System.out.println(Color.ANSI_RED + "Invalid Input. Please enter a non-negative number." + Color.ANSI_RESET);
                    System.out.println();
                    continue; // Restart the loop to prompt the user again
                }
                
                setCurrentWeight(athleteWeight);
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Color.ANSI_RED + "Invalid Input. Please enter number only." + Color.ANSI_RESET);
                System.out.println();
                scanner.next();
                continue; // Skip the rest of the loop and start again.
            }

            break; // Exit the loop if input valid.
            
        } while (true);
    }

    /**
     * This method is checking name input.
     * Doesn't want any number in the input.
     * 
     * @param name check the input name
     * @return true if the name is valid
     */
    // check validation of the input name
    private boolean isValidName(String name) {

        String check = "([a-zA-Z]+)(\\s[a-zA-Z]+)*";

        // Handling for NullPointerException
        if (name == null) {
            return false;
        }

        return name.matches(check);
    }

}
