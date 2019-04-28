import java.util.ArrayList;
import java.util.HashMap;

public class Collection {
    private ArrayList<Deck> decks;
    private HashMap<String, Card> freeCards;
    private HashMap<String, Item> usableItems;

    public Collection() {
        this.decks = new ArrayList<>();
        this.freeCards = new HashMap<>();
        this.usableItems = new HashMap<>();
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public HashMap<String, Card> getFreeCards() {
        return freeCards;
    }

    public HashMap<String, Item> getUsableItems() {
        return usableItems;
    }

    public void removeCard (String cardID){
        this.getFreeCards().remove(cardID);
    }
}
