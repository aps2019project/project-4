import java.sql.Time;

public class Match {

    private enum  StateOfGame {
        WIN, LOSS, DRAW;
        StateOfGame(){
        }
    }

    private StateOfGame stateOfGame;
    private String opponent;
    private Time timeOfGame;

    public Match(String opponent, int stateOfGame, Time timeOfGame) {
        this.opponent = opponent;
        if (stateOfGame == 1)
            this.stateOfGame = StateOfGame.WIN;
        if (stateOfGame == 0)
            this.stateOfGame = StateOfGame.DRAW;
        if (stateOfGame == -1)
            this.stateOfGame = StateOfGame.LOSS;
        this.timeOfGame = timeOfGame;
    }

    public String getOpponent() {
        return opponent;
    }

    public StateOfGame getStateOfGame() {
        return stateOfGame;
    }

    public Time getTimeOfGame() {
        return timeOfGame;
    }

    @Override
    public String toString() {
        if (stateOfGame == StateOfGame.WIN)
            return opponent + "    " + "wins!" + "   " + timeOfGame + "\n";
        if (stateOfGame == StateOfGame.DRAW)
            return opponent + "    " + "draw!" + "   " + timeOfGame + "\n";
        if (stateOfGame == StateOfGame.LOSS)
            return opponent + "    " + "loss!" + "   " + timeOfGame + "\n";
        return null;
    }
}
