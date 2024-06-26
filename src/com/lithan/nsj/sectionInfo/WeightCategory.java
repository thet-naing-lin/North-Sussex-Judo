package com.lithan.nsj.sectionInfo;

import com.lithan.nsj.athleteInfo.Athlete;

public class WeightCategory {

    private Athlete athlete;

    public WeightCategory(Athlete athlete) {
        this.athlete = athlete;
    }

    /**
     * This method is showing category of competition weight info.
     */
    public void showCompetitionWeight() {
        System.out.println("""
                            ~~ Competition Weight Category ~~

                    Flyweight           - People who has 66 kg and lower weight
                    Lightweight         - People who has between 67 and 73 kg weight
                    Light-Middleweight  - People who has between 74 and 81 kg weight
                    Middleweight        - People who has between 82 and 90 kg weight
                    Light-Heavyweight   - People who has between 91 and 100 kg weight
                    Heavyweight         - People who has over 100 kg weight
                """);
    }

    /**
     * This method return the competition category statement based on user weight
     * 
     * @return String, statement
     */
    // according to input weight, decide which category of competition that can enter
    public String compareToCompetitionWeight() {

        double athleteWeight = athlete.getCurrentWeight();

        if (athleteWeight <= 66) {
            return "You can participate 'Flyweight' category for competition.";
        }

        if (athleteWeight > 66 && athleteWeight <= 73) {
            return "You can participate 'Lightweight' category for competition.";
        }

        if (athleteWeight > 74 && athleteWeight <= 81) {
            return "You can participate 'Light-Middleweight' category for competition.";
        }

        if (athleteWeight > 82 && athleteWeight <= 90) {
            return "You can participate 'Middleweight' category for competition.";
        }

        if (athleteWeight > 91 && athleteWeight <= 100) {
            return "You can participate 'Light-Heavyweight' category for competition.";
        }

        if (athleteWeight > 100) {
            return "You can participate 'Heavyweight' category for competition.";
        }

        return "Athlete didn't input current weight.";
    }

    /**
     * This method return just the name of competition category
     * based on user current weight.
     * 
     * @return String
     */
    public String weightCategoryName() {
        
        double athleteWeight = athlete.getCurrentWeight();
    
            if (athleteWeight <= 66) {
                return "Flyweight";
            }
    
            if (athleteWeight > 66 && athleteWeight <= 73) {
                return "Lightweight";
            }
    
            if (athleteWeight > 74 && athleteWeight <= 81) {
                return "Light-Middleweight";
            }
    
            if (athleteWeight > 82 && athleteWeight <= 90) {
                return "Middleweight";
            }
    
            if (athleteWeight > 91 && athleteWeight <= 100) {
                return "Light-Heavyweight";
            }
    
            if (athleteWeight > 100) {
                return "Heavyweight";
            }
    
            return "Athlete didn't input current weight.";
        }

}
