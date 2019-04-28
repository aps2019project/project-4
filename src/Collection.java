import java.util.HashMap;

public class Collection {
    private HashMap<String, Deck> decks;
    private HashMap<String, Card> freeCards;
    private HashMap<String, Item> usableItems;

    public Collection() {
        this.decks = new HashMap<>();
        this.freeCards = new HashMap<>();
        this.usableItems = new HashMap<>();
    }

    public HashMap<String, Deck> getDecks() {
        return decks;
    }

    public HashMap<String, Card> getFreeCards() {
        return freeCards;
    }

    public HashMap<String, Item> getUsableItems() {
        return usableItems;
    }

    public void removeCard(String cardID) {
        this.getFreeCards().remove(cardID);
    }

    public void removeDeck(String deckName) throws DeckNotAvailabilityException {
        if (!(this.getDecks().containsKey(deckName)))
            throw new DeckNotAvailabilityException(deckName);
        //todo
    }

    public void addDeck(String deckName) throws DeckAvailabilityException {
        if (this.getDecks().containsKey(deckName))
            throw new DeckAvailabilityException(deckName);
        this.getDecks().put(deckName, new Deck(deckName));
    }
}
