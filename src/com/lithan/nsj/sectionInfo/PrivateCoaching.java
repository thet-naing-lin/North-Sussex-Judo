package com.lithan.nsj.sectionInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lithan.nsj.Color;

public class PrivateCoaching {

    private double hourlyFees;
    private int hours;
    private double totalFees;
    private int weekPerMonth = 4;

    Scanner scanner = new Scanner(System.in);

    public PrivateCoaching(double hourlyFees) {
        this.hourlyFees = hourlyFees;
    }

    public double getHourlyFees() {
        return hourlyFees;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getWeekPerMonth() {
        return weekPerMonth;
    }

    public void setWeekPerMonth(int weekPerMonth) {
        this.weekPerMonth = weekPerMonth;
    }

    /**
     * This method show the information about private coaching.
     */
    public void showPrivateFees() {
        System.out.println("""
                            ~~ Private Coaching Information ~~

                    Private Coaching Fees : $9.00 per hour
                    Note - Each athlete can get only 5 hours maximum per week of private coaching.
                """);
    }

    /**
     * This method request the number of hours of private coach for one week.
     * Checking the hour must be between 1 and 5.
     * Involved checking the input validation.
     * 
     * @return the another method that calculate the private fees method
     */
    public double selectedPrivateCoaching() {

        int selectedHours = 0;

        do {
            try {
                System.out.print("How much hours do you want for private coaching in a week : ");
                selectedHours = scanner.nextInt();

                if (selectedHours > 5 || selectedHours < 0) {
                    System.out.println();
                    System.out.println(Color.ANSI_RED + "Private Coaching hours can't be more than 5 hours or negative number."
                            + Color.ANSI_RESET);
                    System.out.println();
                    continue;   
                }

                setHours(selectedHours);
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Color.ANSI_RED + "Invalid input. Please enter a valid number." + Color.ANSI_RESET);
                System.out.println();
                scanner.next();
                continue; // Skip the rest of the loop and start again.
            }
            break; // Exit the loop if input valid.
        } while (true);

        return calculatePrivateFees(selectedHours);
    }

    /**
     * This method calculate the private fees based on the hours for one month.
     * Also include validation of the input
     * 
     * @param selectedHours (number of hours for private coach)
     * @return double type by multiplying private fees, user selected hour and weekly per month (for one month fees)
     */
    private double calculatePrivateFees(int selectedHours) {

        return hourlyFees * selectedHours * getWeekPerMonth();
    }
}
