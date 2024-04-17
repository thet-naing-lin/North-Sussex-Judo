import java.text.DecimalFormat;
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


        // Private Coaching
        PrivateCoaching privateCoaching = new PrivateCoaching(9);

        privateCoaching.showPrivateFees();

        double privateFees = privateCoaching.selectedPrivateCoaching();
        
        String formatePrivateFees = currencyFormat.format(privateFees) + " $";

        System.out.printf("%nYour Private Coaching Fees : %s%n" , formatePrivateFees);


        // Competition
        Competition competition = new Competition(22);

        competition.showCompetitionInfo();

        double competitionFees = competition.selectedCompetitionFees();
        
        String formatCompetitionFees = currencyFormat.format(competitionFees) + " $";

        System.out.printf("%nYour Competition Fees : %s%n", formatCompetitionFees);


        scanner.close();
    }
}
