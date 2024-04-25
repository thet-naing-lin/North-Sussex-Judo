import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainingPlan {

    private double beginnerFees;
    private double intermediateFees;
    private double eliteFees;
    private int selectedPlan;
    private int weekPerMonth = 4;

    Scanner scanner = new Scanner(System.in);

    public TrainingPlan(double beginnerFees, double intermediateFees, double eliteFees) {
        this.beginnerFees = beginnerFees;
        this.intermediateFees = intermediateFees;
        this.eliteFees = eliteFees;
    }

    public double getBeginnerFees() {
        return beginnerFees;
    }

    public void setBeginnerFees(double beginnerFees) {
        this.beginnerFees = beginnerFees;
    }

    public double getIntermediateFees() {
        return intermediateFees;
    }

    public void setIntermediateFees(double intermediateFees) {
        this.intermediateFees = intermediateFees;
    }

    public double getEliteFees() {
        return eliteFees;
    }

    public void setEliteFees(double eliteFees) {
        this.eliteFees = eliteFees;
    }

    public int getWeekPerMonth() {
        return weekPerMonth;
    }

    public void setWeekPerMonth(int weekPerMonth) {
        this.weekPerMonth = weekPerMonth;
    }

    // getter method for selected plan
    public int getSelectedPlan() {
        return selectedPlan;
    }

    /**
     * This method showing the training plan info.
     */
    public void showTrainingPlan() {
        System.out.println("""
                                    ~~ Training Plan ~~

                    1. Beginner (2 sessions per week)      : $25.00 per week
                    2. Intermediate (3 sessions per week)  : $30.00 per week
                    3. Elite (5 sessions per week)         : $35.00 per week
                """);
    }

    /**
     * This method request training plan in a form of number from user.
     * Also involved checking the validation input.
     * the selectedTrainingPlan will be stored in the selectedPlan, private attribute of this class.
     * 
     * @return the method that will calculate the training plan fees for one month.
     */
    public double selectedTrainingPlan() {

        int selectedTrainingPlan = 0;

        do {
            try {
                System.out.print("Choose your training plan (1 or 2 or 3) : ");
                selectedTrainingPlan = scanner.nextInt();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(Color.ANSI_RED + "Invalid Input. Please enter number only." + Color.ANSI_RESET);
                System.out.println();
                scanner.next();
                continue;
            }
            break;
        } while (true);

        // Stored the selected plan
        this.selectedPlan = selectedTrainingPlan;

        return calculateFees(selectedTrainingPlan);
    }

    /**
     * This method is for showing output in the athlete information
     * 
     * @param trainingPlan (output will vary depending on selected training plan)
     * @return String showing what training plan that user choose
     */
    // For showing output at the end of registration
    public String trainingPlanName(int trainingPlan) {
        switch (trainingPlan) {
            case 1:
                return "Athlete choose the beginner plan. (2 sessions per week)";
            case 2:
                return "Athlete choose the intermediate plan. (3 sessions per week)";
            case 3:
                return "Athlete choose the elite plan. (5 sessions per week)";
            default:
                return "Athlete didn't choose any plan";
        }
    }

    /**
     * This method is changing the number form of training plan into string form.
     * 
     * @param trainingPlan
     * @return String
     */
    public String trainingPlanNameOnly(int trainingPlan) {
        switch (trainingPlan) {
            case 1:
                return "Beginner Plan";
            case 2:
                return "Intermediate Plan";
            case 3:
                return "Elite Plan";
            default:
                return "Athlete didn't choose any plan";
        }
    }

    /**
     * This method calculate the training plan fees that user choose for one month
     * by multiplying with weekly per month.
     * 
     * @param trainingPlan (that value will get from the selectedTrainingPlan() method)
     * @return double data type, multiply with training plan fees and weekly per month
     */
    // calculate the weekly training plan fees multiply with 4
    private double calculateFees(int trainingPlan) {
        switch (trainingPlan) {
            case 1:
                System.out.println(Color.ANSI_YELLOW + "Athlete choose the beginner plan. (2 sessions per week)" + Color.ANSI_RESET);
                return beginnerFees * getWeekPerMonth();
            case 2:
                System.out.println(Color.ANSI_YELLOW + "Athlete choose the intermediate plan. (3 sessions per week)" + Color.ANSI_RESET);
                return intermediateFees * getWeekPerMonth();
            case 3:
                System.out.println(Color.ANSI_YELLOW + "Athlete choose the elite plan. (5 sessions per week)" + Color.ANSI_RESET);
                return eliteFees * getWeekPerMonth();
            default:
                System.out.println(
                        Color.ANSI_RED + "There has only 3 plans. Choose only between 1 to 3." + Color.ANSI_RESET);
                System.out.println();
                return selectedTrainingPlan();
        }
    }
}
