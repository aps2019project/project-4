package model;

import views.Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection {
    private HashMap<String, Deck> decks;
    private HashMap<String, Card> allCards;
    private HashMap<String, UsableItem> usableItems;
    //String is id of card and items

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

    public boolean isHaveSpecialHero(String heroName) {
        Card card = this.getAllCards().get(heroName);
        return card instanceof Hero;
    }

    public boolean isHaveSpecialCardNonHero(String cardName) {
        Card card = this.getAllCards().get(cardName);
        return !(card instanceof Hero);
    }

    public boolean isHaveSpecialItem(String itemName) {
        return this.getUsableItems().get(itemName) != null;
    }

    public Enums.TypeOfThing typeOfThing(String thingName) throws ThingNotAvailableInCollectionException {
        if (isHaveSpecialHero(thingName)) return Enums.TypeOfThing.HERO;
        if (isHaveSpecialItem(thingName)) return Enums.TypeOfThing.ITEM;
        if (isHaveSpecialCardNonHero(thingName)) return Enums.TypeOfThing.NONHERO;
        throw new ThingNotAvailableInCollectionException(thingName);
    }

    public void addThingToDeck(String thingName, String deckName) throws Exception {
        if (this.getDecks().get(deckName) == null)
            throw new DeckNotAvailabilityException(deckName);
        switch (typeOfThing(thingName)) {
            case HERO:
                if (this.getDecks().get(deckName).isHaveHero())
                    throw new HeroAvailableInDeckException(deckName);
                this.getDecks().get(thingName).addCard(this.getAllCards().get(thingName));
                break;
            case ITEM:
                if (this.getDecks().get(deckName).getItem() != null)
                    throw new ItemAvailableInDeckException(thingName, deckName);
                this.getDecks().get(deckName).setItem(this.getUsableItems().get(thingName));
                break;
            case NONHERO:
                if (this.getDecks().get(deckName).getCards().get(thingName) != null)
                    throw new CardAvailableInDeckException(thingName, deckName);
                //th
                break;
        }
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


    public void sellCard(String cardID) throws Exception {
        for (Deck deck : this.getDecks().values())
            deck.removeThingWithID(cardID , false);
    }

    public void sellItem(String itemID) throws Exception {
        for (Deck deck : this.getDecks().values())
            deck.removeThingWithID(itemID , false);
    }

    public void removeCard(String thingID, String deckName) throws DeckNotAvailabilityException, IDNotAvailableInDeckException {
        if (!(this.getDecks().containsKey(deckName)))
            throw new DeckNotAvailabilityException(deckName);
        this.getDecks().get(deckName).removeThingWithID(thingID , true);
    }

    public ArrayList<Card> searchCard(String string) {
        ArrayList<Card> cards = new ArrayList<>();
        this.getAllCards().forEach((s, card) -> {
            if (s.contains(string)) {
                cards.add(card);
            }
        });
        return cards;
    }

    public ArrayList<UsableItem> searchItem(String string) {
        ArrayList<UsableItem> usableItems = new ArrayList<>();
        this.getUsableItems().forEach((s, usableItem) -> {
            if (s.contains(string)) {
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
