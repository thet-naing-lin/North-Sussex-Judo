import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        DecimalFormat currencyFormat = new DecimalFormat("#0.00");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        System.out.println("\t\t~~ Welcome to North-Sussex-Judo ~~");
        System.out.println();

        // Athlete
        Athlete athlete = new Athlete();

        athlete.requestAthleteName();

        athlete.requestCurrentWeight();

        // TrainingPlan
        TrainingPlan trainingPlan = new TrainingPlan(25, 30, 35);

        trainingPlan.showTrainingPlan();

        double trainingFees = trainingPlan.selectedTrainingPlan();
        String formatTrainingFees = currencyFormat.format(trainingFees) + " $";

        System.out.println();
        System.out.println("Your training fees for one month : " + formatTrainingFees);
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
        
        String competitionChoice;

        Competition competition = new Competition();

        String formatCompetitionFees = null;

        do {
            competitionChoice = scanner.nextLine().trim().toLowerCase();
            
            if ((competitionChoice.equals("yes") || competitionChoice.equals("y"))) {
                
                if (trainingPlan.getSelectedPlan() == 1) {
                    System.out.println();
                    System.out.println(Color.ANSI_YELLOW + "Beginner Athlete can't enter the competition." + Color.ANSI_RESET);
                    break;
                }

                competition = new Competition(22);

                competition.showCompetitionInfo();

                double competitionFees = competition.selectedCompetitionFees();

                competition.setFees(competitionFees);

                formatCompetitionFees = currencyFormat.format(competitionFees) + " $";

                System.out.printf("%nYour Competition Fees : %s%n", formatCompetitionFees);
                break;
            } else if ((competitionChoice.equals("no") || competitionChoice.equals("n"))) {
                System.out.println(Color.ANSI_YELLOW + "Athlete didn't want to participate competition." + Color.ANSI_RESET);
                break;
            } else {
                System.out.println();
                System.out.println(Color.ANSI_RED + "Invalid input. Please enter 'yes' or 'no'." + Color.ANSI_RESET);
                System.out.println();
                System.out.println("Do you want to enter competition? (yes/no)");
            }

        } while (true);


        // Private Coaching
        System.out.println();
        System.out.println("Do you want private coaching? (yes/no)");

        String privateCoachingChoice;

        PrivateCoaching privateCoaching = new PrivateCoaching(9);

        String formatePrivateFees = null;

        do {
            privateCoachingChoice = scanner.nextLine().trim().toLowerCase();

            if (privateCoachingChoice.equals("yes") || privateCoachingChoice.equals("y"))
            {
                privateCoaching.showPrivateFees();
    
                double privateFees = privateCoaching.selectedPrivateCoaching();
    
                privateCoaching.setFees(privateFees);
    
                formatePrivateFees = currencyFormat.format(privateFees) + " $";
    
                System.out.printf("%nYour Private Coaching Fees for one month : %s%n" , formatePrivateFees);
                
                break;

            } else if(privateCoachingChoice.equals("no") || privateCoachingChoice.equals("n")) {
    
                System.out.println(Color.ANSI_YELLOW + "Athlete didn't want the private coaching." + Color.ANSI_RESET);
                
                break;

            } else {
                System.out.println();
                System.out.println(Color.ANSI_RED + "Invalid input. Please enter 'yes' or 'no'." + Color.ANSI_RESET);
                System.out.println();
                System.out.println("Do you want private coaching? (yes/no)");
            }
        } while (true);


        // Total Fees
        TotalFees totalFees = new TotalFees(trainingPlan, privateCoaching, competition);

        int selectedTrainingPlan = trainingPlan.getSelectedPlan();
        boolean hasPrivateCoaching = privateCoachingChoice.equals("yes") || privateCoachingChoice.equals("y");
        boolean hasCompetition = competitionChoice.equals("yes") || competitionChoice.equals("y");

        // To avoid null output by using ternary operator
        String privateFees = formatePrivateFees == null ? "0" : formatePrivateFees;
        String competitionFees = formatCompetitionFees == null ? "0" : formatCompetitionFees;

        String formatTotalFees = currencyFormat
                .format(totalFees.calculateTotalFees(selectedTrainingPlan, hasPrivateCoaching, hasCompetition)) + " $";

        System.out.println();
        System.out.println();
        System.out.println(Color.ANSI_GREEN + """
                        ~~ Thank You for choosing North Sussex Judo ~~

                    Name                                :   %s

                    Weight                              :   %.2f kg

                    %s

                    %s

                    Private Coaching Hour               :   %d hr/week

                    Number of Competition               :   %d

                    Training Plan Cost for one month    :   %s

                    Competition Cost                    :   %s

                    Private Coaching Cost for one month :   %s

                    Total Fees of one month             :   %s
                """.formatted(athlete.getName(), athlete.getCurrentWeight(),
                weightCategory.compareToCompetitionWeight(),
                trainingPlan.trainingPlanName(selectedTrainingPlan), privateCoaching.getHours(),
                competition.getCompetitionCount(),
                formatTrainingFees, competitionFees, privateFees,
                formatTotalFees) + Color.ANSI_RESET);

        scanner.close();
    }
}
