import java.util.ArrayList;

public class Collection {
    private ArrayList<Deck> decks;
    private Deck selectedDeck;

    public Collection() {
        this.decks = new ArrayList<>();
        this.selectedDeck = null;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public Deck getSelectedDeck() {
        return selectedDeck;
    }

}
