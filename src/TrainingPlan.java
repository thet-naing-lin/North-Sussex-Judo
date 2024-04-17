import java.util.Scanner;

public class TrainingPlan {

    private double beginnerFees;
    private double intermediateFees;
    private double eliteFees;

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

    public void showTrainingPlan() {
        System.out.println("""
                                    ~~ Training Plan ~~

                    1. Beginner (2 sessions per week)      : $25.00 per week
                    2. Intermediate (3 sessions per week)  : $30.00 per week
                    3. Elite (5 sessions per week)         : $35.00 per week
                """);
    }

    public double selectedTrainingPlan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose your training plan (1 or 2 or 3) : ");
        int selectedTrainingPlan = scanner.nextInt();
        System.out.println();
        
        return handleTrainingPlanSelection(selectedTrainingPlan);
    }

    private double handleTrainingPlanSelection(int trainingPlan) {
        switch (trainingPlan) {
            case 1:
                System.out.println("Athlete choose the beginner plan.");
                return beginnerFees;
            case 2:
                System.out.println("Athlete choose the intermediate plan.");
                return intermediateFees;
            case 3:
                System.out.println("Athlete choose the elite plan.");
                return eliteFees;
            default:
                System.out.println("There has only 3 plans. Choose only between 1 to 3.");
                System.out.println();
                return selectedTrainingPlan();
        }
    }

    // public double selectedTrainingPlan(int trainingPlan) {
    //     switch (trainingPlan) {
    //         case 1:
    //             System.out.println("Athlete choose the beginner plan.");
    //             return beginnerFees;
    //         case 2:
    //             System.out.println("Athlete choose the intermediate plan.");
    //             return intermediateFees;
    //         case 3:
    //             System.out.println("Athlete choose the elite plan.");
    //             return eliteFees;
    //         default:
    //             System.out.println("There has only 3 plans. Choose only between 1 to 3.");
    //             return 0;
    //     }
    // }
}
