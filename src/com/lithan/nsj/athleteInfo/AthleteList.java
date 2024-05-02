package com.lithan.nsj.athleteInfo;

import java.util.ArrayList;
import java.util.List;

public class AthleteList {
    
    private List<RegisterAthlete> athletes;

    public AthleteList() {
        this.athletes = new ArrayList<>();
    }

    public List<RegisterAthlete> getAthlete() {
        return athletes;
    }

    public void setAthlete(List<RegisterAthlete> athletes) {
        this.athletes = athletes;
    }

    /**
     * This method add the register athlete into the athlete list.
     * 
     * @param athlete (register athlete)
     */
    public void add(RegisterAthlete athlete) {
        athletes.add(athlete);
    }

}