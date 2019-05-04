package resources;

import model.Card;

public class Resources {

    public static void setResources() {
        SpellResources.setSpellResource();
        MinionResources.setMinionResource();
        HeroResources.setHeroResource();
        ItemResources.setItemResource();
    }

    public Card getSpeceficCard(String cardName) {
        //if (ItemResources.getItemResource())
    }
}
