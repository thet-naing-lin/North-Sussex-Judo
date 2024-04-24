import java.util.InputMismatchException;
import java.util.Scanner;

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

    public void showPrivateFees() {
        System.out.println("""
                            ~~ Private Coaching Information ~~

                    Private Coaching Fees : $9.00 per hour
                    Note - Each athlete can get only 5 hours maximum per week of private coaching.
                """);
    }

    public double selectedPrivateCoaching() {

        int selectedHours = 0;

        do {
            try {
                System.out.print("How much hours do you want for private coaching in a week : ");
                selectedHours = scanner.nextInt();
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

    private double calculatePrivateFees(int selectedHours) {

        while (selectedHours > 5 || selectedHours < 0) {
            System.out.println();
            System.out.println(Color.ANSI_RED + "Private Coaching hours can't be more than 5 hours or negative number."
                    + Color.ANSI_RESET);
            System.out.println();
            // For Invalid Input
            do {
                try {
                    System.out.print("Enter the hours that you want in a week (maximum 5 hours/week) : ");
                    selectedHours = scanner.nextInt();
                    setHours(selectedHours);
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out
                            .println(Color.ANSI_RED + "Invalid input. Please enter a valid number." + Color.ANSI_RESET);
                    System.out.println();
                    scanner.next();
                    continue; // Skip the rest of the loop and start again.
                }
                break; // Exit the loop if input valid.
            } while (true);
        }

        return hourlyFees * selectedHours * getWeekPerMonth();
    }
}
