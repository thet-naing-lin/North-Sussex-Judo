public class Competition {

    private double fees;
    private int numberOfCompetition;

    public Competition(double fees) {
        this.fees = fees;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public int getNumberOfCompetition() {
        return numberOfCompetition;
    }

    public void setNumberOfCompetition(int numberOfCompetition) {
        this.numberOfCompetition = numberOfCompetition;
    }

    public void showCompetitionInfo() {
        System.out.println();
        System.out.println("""
                                ~~ Competition Information ~~

                    - Only Intermediate and Elite athletes can enter competitions.
                    - Competitions are held once a month on every second Saturday of each month.
                    - Competition Fees - 22 $ per competition
                """);
    }

    public double calculateCompetitionFees(int selectedCompetitionNumber) {

        return selectedCompetitionNumber * fees;
    }
}
