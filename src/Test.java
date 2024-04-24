import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        DecimalFormat currencyFormat = new DecimalFormat("#0.00");
        Scanner scanner = new Scanner(System.in);

        AthleteList athleteList = new AthleteList();

        List<RegisterAthlete> allAthletes;


        do {

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

            // Weight Category
            WeightCategory weightCategory = new WeightCategory(athlete);

            System.out.println();
            weightCategory.showCompetitionWeight();

            // Show the competition of weight category that user can enter
            System.out.println(Color.ANSI_YELLOW + weightCategory.compareToCompetitionWeight() + Color.ANSI_RESET);

            // Competition
            System.out.println();
            System.out.println("Do you want to enter competition? (yes/no)");

            String competitionChoice;

            Competition competition = new Competition(22);

            String formatCompetitionFees = null;

            do {
                competitionChoice = scanner.nextLine().trim().toLowerCase();

                if ((competitionChoice.equals("yes") || competitionChoice.equals("y"))) {

                    // Restriction for beginner plan athlete
                    if (trainingPlan.getSelectedPlan() == 1) {
                        System.out.println();
                        System.out.println(
                                Color.ANSI_YELLOW + "Beginner Athlete can't enter the competition." + Color.ANSI_RESET);
                        break;
                    }

                    competition.showCompetitionInfo();

                    double competitionFees = competition.selectedCompetitionFees();

                    competition.setTotalFees(competitionFees);

                    formatCompetitionFees = currencyFormat.format(competitionFees) + " $";

                    System.out.printf("%nYour Competition Fees : %s%n", formatCompetitionFees);

                    break;

                } else if ((competitionChoice.equals("no") || competitionChoice.equals("n"))) {

                    System.out.println();
                    System.out.println(
                            Color.ANSI_YELLOW + "Athlete didn't want to participate competition." + Color.ANSI_RESET);

                    break;

                } else {
                    System.out.println();
                    System.out
                            .println(Color.ANSI_RED + "Invalid input. Please enter 'yes' or 'no'." + Color.ANSI_RESET);
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

                if (privateCoachingChoice.equals("yes") || privateCoachingChoice.equals("y")) {
                    privateCoaching.showPrivateFees();

                    double privateFees = privateCoaching.selectedPrivateCoaching();

                    privateCoaching.setTotalFees(privateFees);

                    formatePrivateFees = currencyFormat.format(privateFees) + " $";

                    System.out.printf("%nYour Private Coaching Fees for one month : %s%n", formatePrivateFees);

                    break;

                } else if (privateCoachingChoice.equals("no") || privateCoachingChoice.equals("n")) {

                    System.out.println();
                    System.out.println(
                            Color.ANSI_YELLOW + "Athlete didn't want the private coaching." + Color.ANSI_RESET);

                    break;

                } else {
                    System.out.println();
                    System.out
                            .println(Color.ANSI_RED + "Invalid input. Please enter 'yes' or 'no'." + Color.ANSI_RESET);
                    System.out.println();
                    System.out.println("Do you want private coaching? (yes/no)");
                }
            } while (true);

            // Total Fees
            TotalFees totalFees = new TotalFees(trainingPlan, privateCoaching, competition);

            int selectedTrainingPlan = trainingPlan.getSelectedPlan();
            boolean hasPrivateCoaching = privateCoachingChoice.equals("yes") || privateCoachingChoice.equals("y");
            boolean hasCompetition = competitionChoice.equals("yes") || competitionChoice.equals("y");

            double feesAmount = totalFees.calculateTotalFees(selectedTrainingPlan, hasPrivateCoaching, hasCompetition);

            String formatTotalFees = currencyFormat.format(feesAmount) + " $";

            // To avoid showing null output in the result by using ternary operator
            String privateFees = formatePrivateFees == null ? "0" : formatePrivateFees;
            String competitionFees = formatCompetitionFees == null ? "0" : formatCompetitionFees;

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
                    """.formatted(athlete.getName(),
                    athlete.getCurrentWeight(),
                    weightCategory.compareToCompetitionWeight(),
                    trainingPlan.trainingPlanName(selectedTrainingPlan),
                    privateCoaching.getHours(),
                    competition.getCompetitionCount(),
                    formatTrainingFees,
                    competitionFees,
                    privateFees,
                    formatTotalFees) + Color.ANSI_RESET);


            RegisterAthlete registerAthlete = new RegisterAthlete(athlete.getName(), athlete.getCurrentWeight(),
                    weightCategory.weightCategoryName(), trainingPlan.trainingPlanNameOnly(selectedTrainingPlan),
                    competition.getCompetitionCount(), privateCoaching.getHours());

            athleteList.add(registerAthlete);

            allAthletes = athleteList.getAthlete();

            System.out.println("Want to register more athletes? (yes or no)");
            String addAthlete = scanner.nextLine().trim().toLowerCase();

            if (addAthlete.equals("no") || addAthlete.equals("n")) {
                // If the user doesn't want to register more athletes, break out of the loop
                break;
            }

        } while (true);

        


        System.out.println("""
                                                Athlete Information
                                                
                |   Name     |   Weight      |   Weight Category     |   Training Plan   |   Competition Count   |   Private Hours   |

                """);

        for (RegisterAthlete rAthlete : allAthletes) {
            System.out.println(rAthlete);
        }

        scanner.close();
    }
}