import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        DecimalFormat currencyFormat = new DecimalFormat("#0.00");
        Scanner scanner = new Scanner(System.in);

        // TrainingPlan
        TrainingPlan trainingPlan = new TrainingPlan(25, 30, 35);

        trainingPlan.showTrainingPlan();

        double trainingFees = trainingPlan.selectedTrainingPlan();
        String formatTrainingFees = currencyFormat.format(trainingFees);

        System.out.println("Your training fees : " + formatTrainingFees);
        System.out.println();


        // Private Coaching
        System.out.println();
        System.out.println("Do you want private coaching? (yes/no)");
        String privateCoachingChoice = scanner.nextLine().trim().toLowerCase();

        PrivateCoaching privateCoaching = new PrivateCoaching(9);

        privateCoaching.showPrivateFees();

        if (privateCoachingChoice.equals("yes")) {

            double privateFees = privateCoaching.selectedPrivateCoaching();
            
            privateCoaching.setFees(privateFees);
            
            String formatePrivateFees = currencyFormat.format(privateFees) + " $";

            System.out.printf("%nYour Private Coaching Fees : %s%n" , formatePrivateFees);   
        } else {
            System.out.println("Athlete didn't want the private coaching.");
        }        


        // Competition
        System.out.println();
        System.out.println("Do you want to enter competition? (yes/no)");
        String competitionChoice = scanner.nextLine().trim().toLowerCase();

        Competition competition = new Competition(22);

        competition.showCompetitionInfo();

        if (competitionChoice.equals("yes")) {
            double competitionFees = competition.selectedCompetitionFees();
        
            competition.setFees(competitionFees);
            
            String formatCompetitionFees = currencyFormat.format(competitionFees) + " $";

            System.out.printf("%nYour Competition Fees : %s%n", formatCompetitionFees);
        } else {
            System.out.println("Athlete didn't want to participate competition.");
        }
        

        // Total Fees
        TotalFees totalFees = new TotalFees(trainingPlan, privateCoaching, competition);

        int selectedTrainingPlan = trainingPlan.getSelectedPlan();
        boolean hasPrivateCoaching = privateCoachingChoice.equals("yes");
        boolean hasCompetition = competitionChoice.equals("yes");

        String formatTotalFees = currencyFormat.format(totalFees.calculateTotalFees(selectedTrainingPlan, hasPrivateCoaching, hasCompetition)) + " $";

        System.out.println("Your Total Cost : " + formatTotalFees);
    }
}
