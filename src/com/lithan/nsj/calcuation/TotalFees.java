package com.lithan.nsj.calcuation;

import com.lithan.nsj.sectionInfo.Competition;
import com.lithan.nsj.sectionInfo.PrivateCoaching;
import com.lithan.nsj.sectionInfo.TrainingPlan;

public class TotalFees {

    private TrainingPlan trainingPlan;
    private PrivateCoaching privateCoaching;
    private Competition competition;

    public TotalFees(TrainingPlan trainingPlan, PrivateCoaching privateCoaching, Competition competition) {
        this.trainingPlan = trainingPlan;
        this.privateCoaching = privateCoaching;
        this.competition = competition;
    }

    /**
     * This method calculate the total fees for one month including training plan fees, private coach fees and
     * competition fees.
     * 
     * @param selectedTrainingPlan (user selected training plan fees)
     * @param hasPrivateCoaching (want private coaching or not for user)
     * @param hasCompetition (participate competition or not for the user)
     * @return double data type, by adding of all fees
     */
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
