import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        DecimalFormat currencyFormat = new DecimalFormat("#0.00");
        Scanner scanner = new Scanner(System.in);

        // Athlete
        Athlete athlete = new Athlete();

        System.out.println("What is you name?");
        String athleteName = scanner.nextLine();
        System.out.println();

        athlete.setName(athleteName);

        System.out.println("What is your current weight in kg?");
        double athleteWeight = scanner.nextDouble();
        System.out.println();

        athlete.setCurrentWeight(athleteWeight);


        // TrainingPlan
        TrainingPlan trainingPlan = new TrainingPlan(25, 30, 35);

        trainingPlan.showTrainingPlan();

        double trainingFees = trainingPlan.selectedTrainingPlan();
        String formatTrainingFees = currencyFormat.format(trainingFees) + " $";

        System.out.println();
        System.out.println("Your training fees : " + formatTrainingFees);
        System.out.println();

        // Consume the newline character left in the input buffer
        scanner.nextLine();

        // Weight Category
        WeightCategory weightCategory = new WeightCategory(athlete);

        System.out.println();
        weightCategory.showCompetitionWeight();

        System.out.println(Color.ANSI_YELLOW + weightCategory.compareToCompetitionWeight() + Color.ANSI_RESET);


        // Competition
        System.out.println();
        System.out.println("Do you want to enter competition? (yes/no)");
        String competitionChoice = scanner.nextLine().trim().toLowerCase();

        Competition competition = new Competition();

        String formatCompetitionFees = null;
        
        if (trainingPlan.getSelectedPlan() == 1 && (competitionChoice.equals("yes") || competitionChoice.equals("y"))) {
            System.out.println();
            System.out.println(Color.ANSI_YELLOW + "Beginner Athlete can't enter the competition." + Color.ANSI_RESET);
        } else {
            competition = new Competition(22);

            competition.showCompetitionInfo();

            if (competitionChoice.equals("yes") || competitionChoice.equals("y")) {

                double competitionFees = competition.selectedCompetitionFees();
            
                competition.setFees(competitionFees);
                
                formatCompetitionFees = currencyFormat.format(competitionFees) + " $";
    
                System.out.printf("%nYour Competition Fees : %s%n", formatCompetitionFees);
            } else {
                System.out.println(Color.ANSI_YELLOW + "Athlete didn't want to participate competition." + Color.ANSI_RESET);
            }
        }


        // Private Coaching
        System.out.println();
        System.out.println("Do you want private coaching? (yes/no)");
        String privateCoachingChoice = scanner.nextLine().trim().toLowerCase();

        PrivateCoaching privateCoaching = new PrivateCoaching(9);

        privateCoaching.showPrivateFees();

        String formatePrivateFees = null;

        if (privateCoachingChoice.equals("yes") || privateCoachingChoice.equals("y")) {

            double privateFees = privateCoaching.selectedPrivateCoaching();
            
            privateCoaching.setFees(privateFees);
            
            formatePrivateFees = currencyFormat.format(privateFees) + " $";

            System.out.printf("%nYour Private Coaching Fees : %s%n" , formatePrivateFees);   
        } else {
            System.out.println(Color.ANSI_YELLOW + "Athlete didn't want the private coaching." + Color.ANSI_RESET);
        }


        // Total Fees
        TotalFees totalFees = new TotalFees(trainingPlan, privateCoaching, competition);

        int selectedTrainingPlan = trainingPlan.getSelectedPlan();
        boolean hasPrivateCoaching = privateCoachingChoice.equals("yes") || privateCoachingChoice.equals("y");
        boolean hasCompetition = competitionChoice.equals("yes")|| competitionChoice.equals("y");

        String privateFees = formatePrivateFees == null ? "0" : formatePrivateFees;
        String competitionFees = formatCompetitionFees == null ? "0" : formatCompetitionFees;

        String formatTotalFees = currencyFormat.format(totalFees.calculateTotalFees(selectedTrainingPlan, hasPrivateCoaching, hasCompetition)) + " $";

        System.out.println();
        System.out.println();
        System.out.println(Color.ANSI_GREEN + """
                            ~~ Your Information ~~

                Name                    :   %s

                Weight                  :   %.2f kg

                %s
                
                %s
                
                Private Coaching Hour   :   %d hr/week

                Number of Competition   :   %d

                Training Plan Cost      :   %s

                Competition Cost        :   %s
                
                Private Coaching Cost   :   %s
                
                Total Fees              :   %s            
                """.formatted(athlete.getName(), athlete.getCurrentWeight(), weightCategory.compareToCompetitionWeight(),
                trainingPlan.trainingPlanName(selectedTrainingPlan), privateCoaching.getHours(), competition.getCompetitionCount(),
                formatTrainingFees, competitionFees, privateFees,
                formatTotalFees) + Color.ANSI_RESET);

        scanner.close();
    }
}
