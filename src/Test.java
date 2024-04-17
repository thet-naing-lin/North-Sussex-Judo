import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat currencyFormat = new DecimalFormat("#0.00");

        // TrainingPlan
        TrainingPlan trainingPlan = new TrainingPlan(25, 30, 35);

        trainingPlan.showTrainingPlan();

        double trainingFees = trainingPlan.selectedTrainingPlan();
        String formatTrainingFees = currencyFormat.format(trainingFees);

        System.out.println("Your training fees : " + formatTrainingFees);
        System.out.println();

        //Private Coaching
        PrivateCoaching privateCoaching = new PrivateCoaching(9);

        privateCoaching.showPrivateFees();

        // double privateFees = 0;

        double privateFees = privateCoaching.selectedPrivateCoaching();

        // do {
        //     try {
        //         privateFees = privateCoaching.selectedPrivateCoaching();
        //     } catch (InputMismatchException e) {
        //         System.out.println("Invalid input. Please enter number only.");
        //         System.out.println();
        //         scanner.next();
        //         continue; // Skip the rest of the loop and start again.
        //     }

        //     break; // Exit the loop if input valid.

        // } while (true);
        
        String formatePrivateFees = currencyFormat.format(privateFees) + " $";

        System.out.printf("%nYour Private Coaching Fees : %s%n" , formatePrivateFees);

        // Competition
        Competition competition = new Competition(22);

        competition.showCompetitionInfo();

        int selectedCompetitionNumber = 0;

        do {
            try {
                System.out.print("How many competition do you want to enter in a month : ");
                selectedCompetitionNumber = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.println();
                scanner.next();
                continue; // Skip the rest of the loop and start again.
            }

            break; // Exit the loop if input valid.

        } while (true);

        // while (!validInput) {
        //     try {
        //         System.out.print("How many competition do you want to enter in a month : ");
        //         selectedCompetitionNumber = scanner.nextInt();
        //         validInput = true;
        //     } catch (Exception e) {
        //         System.out.println("Invalid input. Please enter a valid number.");
        //         System.out.println();
        //         scanner.next();
        //     }
        // }

        double competitionFees = competition.calculateCompetitionFees(selectedCompetitionNumber);
        String formatCompetitionFees = currencyFormat.format(competitionFees) + " $";

        System.out.printf("%nYour Competition Fees : %s%n", formatCompetitionFees);


        scanner.close();
    }

    // public static void showTrainingPlan() {
    // TrainingPlan trainingPlan = new TrainingPlan(25, 30, 35);
    // trainingPlan.showTrainingPlan();
    // }
}
