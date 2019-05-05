package model;

import resources.Resources;
import views.Exceptions.*;

import java.util.ArrayList;

public class Shop {

    public static ArrayList<Card> searchCard(String string) {
        ArrayList<Card> cards = new ArrayList<>();
        Resources.getAllCards().forEach(card -> {
            if (card.getName().contains(string)) {
                cards.add(card);
            }
        });
        return cards;
    }

    public static ArrayList<UsableItem> searchItem(String string) {
        ArrayList<UsableItem> usableItems = new ArrayList<>();
        Resources.getAllItems().forEach(usableItem -> {
            if (usableItem.getName().contains(string)) {
                usableItems.add(usableItem);
            }
        });
        return usableItems;
    }

    public static void buyThing(String thingName) throws Exception {
        if (Resources.getSpeceficCard(thingName) == null & Resources.getSpeceficItem(thingName) == null)
            throw new CardAndItemNotAvailabilityException(thingName);
        if (Resources.getSpeceficItem(thingName) != null) {
            UsableItem usableItem = Resources.getSpeceficItem(thingName);
            if (Account.getCurrentAccount().getDrack() <= usableItem.getPrice())
                throw new MoneyIsNotEnoughException();
            buyItem(usableItem);
            return;
        }
        if (Resources.getSpeceficCard(thingName) != null) {
            Card card = Resources.getSpeceficCard(thingName);
            if (Account.getCurrentAccount().getDrack() <= card.getPrice())
                throw new MoneyIsNotEnoughException();
            buyCard(card);
        }
    }

    public static void buyItem(UsableItem item) throws Exception{
        if (Account.getCurrentAccount().getCollection().getUsableItems().size() == 3)
            throw new ThreeItemException();
        Account.getCurrentAccount().changeMoney(-item.getPrice());
        item.setId(Account.getCurrentAccount().getCollection().idGenerator(item));
        Account.getCurrentAccount().getCollection().addItem(item);
    }

    public static void buyCard(Card card) {
        Account.getCurrentAccount().changeMoney(-card.getPrice());
        card.setId(Account.getCurrentAccount().getCollection().idGenerator(card));
        Account.getCurrentAccount().getCollection().addCard(card);
    }
}
