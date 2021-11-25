package belote;

public class Team extends Player {
    protected String name;
    protected String cardPlayed;
    protected int cardPoints;
    public int teamNumber;
    protected boolean roundWinner;

    public Team(String name, String cardPlayed, int cardPoints, boolean roundWinner, int teamNumber) {
        this.cardPlayed = cardPlayed;
        this.name = name;
        this.cardPoints = cardPoints;
        this.roundWinner = roundWinner;
        this.teamNumber = teamNumber;
    }

    public String getName() {
        return name;
    }

    public String getCardPlayed() {
        return cardPlayed;
    }

    public int getCardPoints() {
        return cardPoints;
    }

    public boolean isRoundWinner() {
        return roundWinner;
    }

    public int getTeamNumber() {
        return teamNumber;
    }
}
