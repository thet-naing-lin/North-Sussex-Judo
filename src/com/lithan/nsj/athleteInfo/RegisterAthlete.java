package com.lithan.nsj.athleteInfo;

public class RegisterAthlete {

    String athleteName;
    double athleteWeight;
    String weightCategory;
    String trainingPlan;
    int numOfCompetition;
    int privateHours;

    public RegisterAthlete(String athleteName, double athleteWeight, String weightCategory, String trainingPlan,
            int numOfCompetition, int privateHours) {
        this.athleteName = athleteName;
        this.athleteWeight = athleteWeight;
        this.weightCategory = weightCategory;
        this.trainingPlan = trainingPlan;
        this.numOfCompetition = numOfCompetition;
        this.privateHours = privateHours;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public double getAthleteWeight() {
        return athleteWeight;
    }

    public void setAthleteWeight(double athleteWeight) {
        this.athleteWeight = athleteWeight;
    }

    public int getNumOfCompetition() {
        return numOfCompetition;
    }

    public void setNumOfCompetition(int numOfCompetition) {
        this.numOfCompetition = numOfCompetition;
    }

    public int getPrivateHours() {
        return privateHours;
    }

    public void setPrivateHours(int privateHours) {
        this.privateHours = privateHours;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public String getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(String trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    /**
     * Override the toString method to show output of the register athlete list at the end of program.
     * 
     * @return String formatted with text block
     */
    @Override
    public String toString() {

        return """
                |   %s      | %.2f kg     |   %s        |    %s       | %d                |  %d                 |
                """.formatted(athleteName,
                athleteWeight,
                weightCategory,
                trainingPlan,
                numOfCompetition,
                privateHours);
    }

}
