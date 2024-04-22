import java.util.Scanner;

public class Competition {

    private double fees;
    private int competitionCount;

    Scanner scanner = new Scanner(System.in);

    // default constructor
    public Competition() {

    }

    public Competition(double fees) {
        this.fees = fees;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public int getCompetitionCount() {
        return competitionCount;
    }

    public void setCompetitionCount(int competitionCount) {
        this.competitionCount = competitionCount;
    }

    public void showCompetitionInfo() {
        System.out.println();
        System.out.println("""
                                ~~ Competition Information ~~

                    - Only Intermediate and Elite athletes can enter competitions.
                    - Competitions are held once a month on every second Saturday of each month.
                    - Competition Fees - 22 $ per competition
                """);
    }

    public double selectedCompetitionFees() {

        int numberOfCompetition = 0;

        do {
            try {
                System.out.print("How many competition do you want to enter in a month : ");
                numberOfCompetition = scanner.nextInt();
                
                setCompetitionCount(numberOfCompetition);
                
            } catch (Exception e) {
                System.out.println();
                System.out.println(Color.ANSI_RED + "Invalid input. Please enter a valid number." + Color.ANSI_RESET);
                System.out.println();
                scanner.next();
                continue; // Skip the rest of the loop and start again.
            }

            break; // Exit the loop if input valid.

        } while (true);

        return calculateCompetitionFees(numberOfCompetition);
    }

    private double calculateCompetitionFees(int selectedCompetitionNumber) {

        return selectedCompetitionNumber * fees;
    }
}
