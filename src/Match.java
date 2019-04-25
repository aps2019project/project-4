import java.sql.Time;

public class Match {

    private boolean isWin;
    private String opponent;
    private Time timeOfGame;

    public Match(String opponent, boolean isWin, Time timeOfGame) {
        this.opponent = opponent;
        this.isWin = isWin;
        this.timeOfGame = timeOfGame;
    }

    public String getOpponent() {
        return opponent;
    }

    public boolean isWin() {
        return isWin;
    }

    public Time getTimeOfGame() {
        return timeOfGame;
    }

    @Override
    public String toString() {
        if (isWin)
            return opponent + "    " + "wins!" + "   " + timeOfGame + "\n";
        else
            return opponent + "    " + "loss!" + "   " + timeOfGame + "\n";
    }
}
