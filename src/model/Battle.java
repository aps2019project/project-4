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

    }
}
