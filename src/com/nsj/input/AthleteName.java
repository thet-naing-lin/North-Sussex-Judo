package com.nsj.input;

import java.util.Scanner;

import com.nsj.Athlete;

public class AthleteName extends Athlete {

    static Scanner input = new Scanner(System.in);

    // public AthleteName(String athleteName) {
    //     super(athleteName);
    // }

    public void validName() {
        String name;
        System.out.println("\n");
        System.out.print("Enter Your Name : ");
        name = input.nextLine();

        //  checking the user input (valid/invalid)
        if (!isValidName(name)) {
            do {   
                System.out.println("Invalid name, Please try again !");
                name = input.nextLine();
            } while (!isValidName(name));
        }

        setAthleteName(name);
        System.out.println( "Welcome, " + getAthleteName() + ":) \n");
    }

    // public static String validName() {
    //     String name;
    //     System.out.println("\n");
    //     System.out.print("Enter you name: ");
    //     name = input.nextLine();

    //     while (!isValidName(name)) {
    //         System.out.println("Invalid Name. Type again!");
    //         System.out.print("Enter you name: ");
    //         name = input.nextLine();
    //     }

    //     // Using inherited setAthleteName() method
    //     // setAthleteName(name);
    //     // System.out.println("Welcome to `NORTH SUSSEX JUDO` : " + getAthleteName().toUpperCase());
    //     return name;
    // }

    public static boolean isValidName(String name) {

        String check = "([a-zA-Z]+)(\\s[a-zA-Z]+)*";

        // Handling for NullPointerException
        if (name == null) {
            return false;
        }

        return name.matches(check);
    }

    // public void showPlan() {
    //     System.out.println("""
    //                             Training Plan

    //             Beginner (2 sessions per week)      : $25.00 per week
    //             Intermediate (3 sessions per week)  : $30.00 per week
    //             Elite (5 sessions per week)         : $35.00 per week
    //             """);
    // }

}
