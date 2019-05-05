package model;

import resources.Resources;

import java.util.ArrayList;

public class Shop {

    public ArrayList<Card> searchCard(String string) {
        ArrayList<Card> cards = new ArrayList<>();
        Resources.getAllCards().forEach(card -> {
            if (card.getName().contains(string)) {
                cards.add(card);
            }
        });
        return cards;
    }

    public ArrayList<UsableItem> searchItem(String string) {
        ArrayList<UsableItem> usableItems = new ArrayList<>();
        Resources.getAllItems().forEach(usableItem -> {
            if (usableItem.getName().contains(string)) {
                usableItems.add(usableItem);
            }
        });
        return usableItems;
    }

}
