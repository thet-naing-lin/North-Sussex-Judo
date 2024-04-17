public class TotalFees {

    private TrainingPlan trainingPlan;
    private PrivateCoaching privateCoaching;
    private Competition competition;

    public TotalFees(TrainingPlan trainingPlan, PrivateCoaching privateCoaching, Competition competition) {
        this.trainingPlan = trainingPlan;
        this.privateCoaching = privateCoaching;
        this.competition = competition;
    }

    public double calculateTotalFees(int selectedTrainingPlan, boolean hasPrivateCoaching, boolean hasCompetition) {

        System.out.println(privateCoaching.getFees());
        System.out.println(competition.getFees());
        System.out.println();

        double totalFees = 0;

        switch (selectedTrainingPlan) {
            case 1:
                totalFees += trainingPlan.getBeginnerFees();
                break;
            case 2:
                totalFees += trainingPlan.getIntermediateFees();
                break;
            case 3:
                totalFees += trainingPlan.getEliteFees();
                break;
        }

        if (hasPrivateCoaching) {
            totalFees += privateCoaching.getFees();
        }

        if (hasCompetition) {
            totalFees += competition.getFees();
        }

        return totalFees;
    }

}
