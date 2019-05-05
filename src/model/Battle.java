package model;

public class Battle {
    private Player player1;
    private Player player2;
    private Player whoseTurn;
    private Player whoseNext;
    private Player winner;
    private int seconds;
    private GameBoard gameBoard;
    private Enums.GameMode gameMode;
    private int numOfFlags;
    private int numOfAllFlags;

    public Player getWhoseTurn() {
        return whoseTurn;
    }

    public Battle(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public StringBuilder gameInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        if (gameMode == Enums.GameMode.MULTI_PLAYER){
            stringBuilder.append("player 1's hero health: ").append(player1.getDeck().getHero().getHP()).append("\n");
            stringBuilder.append("player 2's hero health: ").append(player2.getDeck().getHero().getHP()).append("\n");
        }
        if(gameMode == Enums.GameMode.MONO_FLAG){
            Minion m1 = player1.getDeck().whoHasFlag();
            if (m1 != null)
                stringBuilder.append("minion: ").append(m1.getName()).append(" of player1 in cell ").
                        append(m1.getCellPlace().getX()).append(" and ").append(m1.getCellPlace().getY()).
                        append("has flag\n");
            Minion m2 = player2.getDeck().whoHasFlag();
            if (m2 != null)
                stringBuilder.append("minion: ").append(m2.getName()).append(" of player2 in cell ").
                        append(m2.getCellPlace().getX()).append(" and ").append(m2.getCellPlace().getY()).
                        append("has flag\n");
        }
        return new StringBuilder();

    }
}
