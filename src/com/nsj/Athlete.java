package com.nsj;

public class Athlete {

    private String athleteName, trainingPlan, weightCategory;
    private double currentWeight;
    private int numberOfComepetiton, hoursOfPrivateCoaching;

    // default constructor
    public Athlete() {

    }

    public Athlete(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(String trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getNumberOfComepetiton() {
        return numberOfComepetiton;
    }

    public void setNumberOfComepetiton(int numberOfComepetiton) {
        this.numberOfComepetiton = numberOfComepetiton;
    }

    public int getHoursOfPrivateCoaching() {
        return hoursOfPrivateCoaching;
    }

    public void setHoursOfPrivateCoaching(int hoursOfPrivateCoaching) {
        this.hoursOfPrivateCoaching = hoursOfPrivateCoaching;
    }

}
