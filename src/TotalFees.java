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

        double totalFees = 0;

        switch (selectedTrainingPlan) {
            case 1:
                totalFees += trainingPlan.getBeginnerFees() * trainingPlan.getWeekPerMonth();
                break;
            case 2:
                totalFees += trainingPlan.getIntermediateFees() * trainingPlan.getWeekPerMonth();
                break;
            case 3:
                totalFees += trainingPlan.getEliteFees() * trainingPlan.getWeekPerMonth();
                break;
        }

        if (hasPrivateCoaching) {
            totalFees += privateCoaching.getTotalFees();
        }

        if (hasCompetition) {
            totalFees += competition.getTotalFees();
        }

        return totalFees;
    }

}
