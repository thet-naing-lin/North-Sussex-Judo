public class TotalFees {

    private TrainingPlan trainingPlan;
    private PrivateCoaching privateCoaching;
    private Competition competition;

    public TotalFees(TrainingPlan trainingPlan, PrivateCoaching privateCoaching, Competition competition) {
        this.trainingPlan = trainingPlan;
        this.privateCoaching = privateCoaching;
        this.competition = competition;
    }

    public double calculateTotalFees(int selectedTrainingPlan) {

        System.out.println(privateCoaching.getFees());
        System.out.println(competition.getFees());
        System.out.println();

        double totalFees = 0;

        switch (selectedTrainingPlan) {
            case 1:
                totalFees = trainingPlan.getBeginnerFees() + privateCoaching.getFees() + competition.getFees();
                break;
            case 2:
                totalFees = trainingPlan.getIntermediateFees() + privateCoaching.getFees() + competition.getFees();
                break;
            case 3:
                totalFees = trainingPlan.getEliteFees() + privateCoaching.getFees() + competition.getFees();
                break;
        }

        // if (trainingPlan.getIntermediateFees() == 0 || trainingPlan.getEliteFees() ==
        // 0) {
        // double totalFees = trainingPlan.getBeginnerFees() + privateCoaching.getFees()
        // + competition.getFees();
        // return totalFees;
        // } else if (trainingPlan.getBeginnerFees() == 0 || trainingPlan.getEliteFees()
        // == 0) {
        // double totalFees = trainingPlan.getIntermediateFees() +
        // privateCoaching.getFees() + competition.getFees();
        // return totalFees;
        // } else {
        // double totalFees = trainingPlan.getEliteFees() + privateCoaching.getFees() +
        // competition.getFees();
        // return totalFees;
        // }

        return totalFees;
    }

}
