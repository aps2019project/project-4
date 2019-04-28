import java.util.HashMap;

public class Deck {
    private String name;
    private HashMap<String, Card> cards;
    private UsabelItem item;

    public Deck(String name) {
        this.name = name;
        this.cards = new HashMap<>();
        this.item = null;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }

    public void setItem(UsabelItem item) {
        this.item = item;
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

    private boolean isHaveHero() {
        for (Card card : this.getCards().values()) {
            if (card instanceof Hero) {
                return true;
            }
        }
        return false;
    }

    public boolean validateDeck(){
        if (this.isHaveHero() & this.getNumOfOtherHeroCards() == 20)
            return true;
        return false;
    }
}
