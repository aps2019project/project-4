package model;

import views.Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection {
    private HashMap<String, Deck> decks;
    private HashMap<String, Card> allCards;
    private HashMap<String, UsableItem> usableItems;
    //String is name of card and items

    public Collection() {
        this.decks = new HashMap<>();
        this.allCards = new HashMap<>();
        this.usableItems = new HashMap<>();
    }

    public HashMap<String, Deck> getDecks() {
        return decks;
    }

    public HashMap<String, Card> getAllCards() {
        return allCards;
    }

    public HashMap<String, Hero> getHeros() {
        HashMap<String, Hero> heros = new HashMap<>();
        for (Card card : getAllCards().values()) {
            if (card instanceof Hero) {
                heros.put(card.getName(), (Hero) card);
            }
        }
        return heros;
    }

    public HashMap<String, Card> getNonHeroCards() {
        HashMap<String, Card> cardHashMap = new HashMap<>();
        this.getAllCards().forEach((s, card) -> {
            if (!(card instanceof Hero)) cardHashMap.put(card.getName(), card);
        });
        return cardHashMap;
    }

    public HashMap<String, UsableItem> getUsableItems() {
        return usableItems;
    }

    public void removeCard(String thingID , String deckName) throws DeckNotAvailabilityException , IDNotAvailableInDeckException{
        if (!(this.getDecks().containsKey(deckName)))
            throw new DeckNotAvailabilityException(deckName);
        this.getDecks().get(deckName).removeThingWithID(thingID);
    }

    public ArrayList<Card> searchCard(String string) {
        ArrayList<Card> cards = new ArrayList<>();
        this.getAllCards().forEach((s, card) -> {
            if (s.contains(string)){
                cards.add(card);
            }
        });
        return cards;
    }

    public ArrayList<UsableItem> searchItem(String string){
        ArrayList<UsableItem> usableItems = new ArrayList<>();
        this.getUsableItems().forEach((s, usableItem) -> {
            if (s.contains(string)){
                usableItems.add(usableItem);
            }
        });
        return usableItems;
    }

    public void removeDeck(String deckName) throws DeckNotAvailabilityException {
        if (!(this.getDecks().containsKey(deckName)))
            throw new DeckNotAvailabilityException(deckName);
        this.getDecks().remove(deckName);
    }

    public void addDeck(String deckName) throws DeckAvailabilityException {
        if (this.getDecks().containsKey(deckName))
            throw new DeckAvailabilityException(deckName);
        this.getDecks().put(deckName, new Deck(deckName));
    }
}
