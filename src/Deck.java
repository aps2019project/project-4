import java.util.HashMap;

public class Deck {
    private String name;
    private HashMap<String, Card> cards;

    public Deck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.getCards().put(card.getName(), card);
    }

    private int getNumOfOtherHeroCards() {
        int i = 0;
        for (Card card : this.getCards().values()) {
            if (!(card instanceof Hero)) {
                i++;
            }
        }
        return i;
    }

}
