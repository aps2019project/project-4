package model;

public class AIPlayer extends Player {
    int stage;

    public AIPlayer(Deck deck) {
        this.setDeck(deck);
        this.stage = -1;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return stage;
    }

    public void handleTurn() {

    }
}
