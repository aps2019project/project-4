package resources;

import model.Card;
import model.UsableItem;

public class Resources {

    public static void setResources() {
        SpellResources.setSpellResource();
        MinionResources.setMinionResource();
        HeroResources.setHeroResource();
        ItemResources.setItemResource();
    }

    public Card getSpeceficCard(String cardName) {
        if (HeroResources.getSpecificHero(cardName) != null)
            return HeroResources.getSpecificHero(cardName);
        if (SpellResources.getSpecificSpell(cardName) != null)
            return SpellResources.getSpecificSpell(cardName);
        if (MinionResources.getSpecificMinion(cardName) != null)
            return MinionResources.getSpecificMinion(cardName);
        return null;
    }

    public UsableItem getSpeceficItem(String itemName) {
        return ItemResources.getSpecificItem(itemName);
    }
}
