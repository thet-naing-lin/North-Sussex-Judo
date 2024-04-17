import java.text.DecimalFormat;

public class Test {

    public static void main(String[] args) {

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
        
        privateCoaching.setFees(privateFees);
        
        String formatePrivateFees = currencyFormat.format(privateFees) + " $";

        System.out.printf("%nYour Private Coaching Fees : %s%n" , formatePrivateFees);


        // Competition
        Competition competition = new Competition(22);

        competition.showCompetitionInfo();

        double competitionFees = competition.selectedCompetitionFees();
        
        competition.setFees(competitionFees);
        
        String formatCompetitionFees = currencyFormat.format(competitionFees) + " $";

        System.out.printf("%nYour Competition Fees : %s%n", formatCompetitionFees);


        // Total Fees
        TotalFees totalFees = new TotalFees(trainingPlan, privateCoaching, competition);

        int selectedTrainingPlan = trainingPlan.getSelectedPlan();

        System.out.println("Your Total Cost : " + totalFees.calculateTotalFees(selectedTrainingPlan));
    }
}
