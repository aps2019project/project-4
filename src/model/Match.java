package model;

public class Match {

    private boolean isWin;
    private String opponent;
    private long endTimeOfGame;

    public Match(String opponent, boolean isWin, long endTimeOfGame) {
        this.opponent = opponent;
        this.isWin = isWin;
        this.endTimeOfGame = endTimeOfGame;
    }

    public String getOpponent() {
        return opponent;
    }

    public boolean isWin() {
        return isWin;
    }

    public long getEndTimeOfGame() {
        return endTimeOfGame;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Opponent or stage: ").append(getOpponent()).append("  ").append(" Result");
        if (isWin) {
            stringBuilder.append("Win!   ");
        } else {
            stringBuilder.append("Loss!  ");
        }
        stringBuilder.append("Time: ").append(timeAgo(getEndTimeOfGame()));
        return stringBuilder.toString();
    }

    private String timeAgo(long endTimeOfGame) {
        if (((System.currentTimeMillis() - endTimeOfGame) / 1000) > 3600) {
             return ((System.currentTimeMillis() - endTimeOfGame) / 3_600_000) + " hours ago";
        }
        if (((System.currentTimeMillis() - endTimeOfGame) / 1000) > 60){
            return  ((System.currentTimeMillis() - endTimeOfGame) / 60_000) + " minutes ago";
        }
        return  ((System.currentTimeMillis() - endTimeOfGame) / 1_000) + " second ago";
    }
}
