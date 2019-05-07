package resources;

import model.*;

import java.util.ArrayList;

public class Resources {

    public static void setResources() {
        SpellResources.setSpellResource();
        MinionResources.setMinionResource();
        HeroResources.setHeroResource();
        ItemResources.setItemResource();
        StageResources.setStageResource();
    }

    public static Card getSpecificCard(String cardName) {
        if (HeroResources.getSpecificHero(cardName) != null)
            return HeroResources.getSpecificHero(cardName);
        if (SpellResources.getSpecificSpell(cardName) != null)
            return SpellResources.getSpecificSpell(cardName);
        if (MinionResources.getSpecificMinion(cardName) != null)
            return MinionResources.getSpecificMinion(cardName);
        return null;
    }

    public static UsableItem getSpecificItem(String itemName) {
        return ItemResources.getSpecificItem(itemName);
    }

    public static ArrayList<UsableItem> getAllItems() {
        return ItemResources.getAllItems();
    }

    public static ArrayList<Hero> getAllHero() {
        return HeroResources.getAllHeros();
    }

    public static ArrayList<Minion> getAllMinions() {
        return MinionResources.getAllMinions();
    }

    public static ArrayList<Spell> getAllSpells() {
        return SpellResources.getAllSpells();
    }

    public static ArrayList<Card> getAllCards() {
        ArrayList<Card> cards = new ArrayList<>(getAllSpells());
        cards.addAll(getAllHero());
        cards.addAll(getAllMinions());
        return cards;
    }
}
