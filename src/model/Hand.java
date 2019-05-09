package model;


//todo full hand with new cards

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Hand {
    private HashMap<String, Card> cards = new HashMap<>();
    private Card nextCard;

    public Hand(Deck mutableDeck) {
        for (int i = 0; i <= 5; i++) {
            Card card = new ArrayList<Card>(mutableDeck.getCards().values()).get(i);
            if (i != 5)
                cards.put(card.getId(), card);
            else
                nextCard = card;
            mutableDeck.getCards().remove(card.getId());
        }
    }

    public Card getNextCard() {
        return nextCard;
    }

    public void addCard(Card card) {
        this.cards.put(card.getId(), card);
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }

    public void removeCard(Card card) {
        this.cards.remove(card.getId());
    }

    public void moveNextCardToHand(Deck mutableDeck) {
        if (nextCard != null)
            cards.put(nextCard.getId(), nextCard);
        changeNextCard(mutableDeck);
    }

    public void changeNextCard(Deck mutableDeck) {
        if (!mutableDeck.getCards().isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(mutableDeck.getCards().size());
            nextCard = new ArrayList<Card>(mutableDeck.getCards().values()).get(randomIndex);
            mutableDeck.getCards().remove(nextCard.getId());
        } else
            nextCard = null;
    }

    public Card getCard(String cardId) {
        return cards.get(cardId);
    }
}
