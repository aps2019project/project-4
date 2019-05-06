package resources;

import model.Deck;

import java.util.ArrayList;

public class StageResources {
    public static ArrayList<StageResources> stageResources = new ArrayList<>();
    private int mode;
    private int gift;
    private Deck deck;

    public StageResources(int mode, int gift, Deck deck) {
        this.mode = mode;
        this.gift = gift;
        this.deck = deck;
    }

    public int getMode() {
        return mode;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getGift() {
        return gift;
    }

    public void showStage() {

    }

    public static void showStages() {

    }

    public static StageResources getStage(int number){
        return stageResources.get(number);
    }

    public static void setStageResource() {
        Deck deck1 = new Deck("stage1");
        deck1.addCardWithSetID(Resources.getSpecificCard("TotalDisarm"), "ai_TotalDisarm_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("LightningBolt"), "ai_LightningBolt_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("AllDisarm"), "ai_AllDisarm_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("AllPoison"), "ai_AllPoison_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("Dispel"), "ai_Dispel_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("Shock"), "ai_Shock_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("Sacrifice"), "ai_Sacrifice_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("persianArcher"), "ai_persianArcher_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("transoxaninaSpearsman"), "ai_transoxaninaSpearsman_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("transoxanianMaceman"), "ai_transoxanianMaceman_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("transoxanianMaceman"), "ai_transoxanianMaceman_2");
        deck1.addCardWithSetID(Resources.getSpecificCard("blackDevil"), "ai_blackDevil_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("monoeyedGiant"), "ai_monoeyedGiant_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("poisonousSnake"), "ai_poisonousSnake_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("giantSnake"), "ai_giantSnake_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("whiteWolf"), "ai_whiteWolf_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("grandWitch"), "ai_grandWitch_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("queenOfWinter"), "ai_queenOfWinter_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("siavash"), "ai_siavash_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("arzhangDeeve"), "ai_arzhangDeeve_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("whiteDeeve"), "ai_whiteDeeve_1");
//        deck1.setItemWithID(Resources.getSpecificItem(/*//todo add item 1*/""), "stage1");
        stageResources.add(new StageResources(1, 500, deck1));
        Deck deck2 = new Deck("stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard("AreaDispel"), "ai_AreaDispel_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("Empower"), "ai_Empower_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("GodStrength"), "ai_GodStrength_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("Madness"), "ai_Madness_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("PoisonLake"), "ai_PoisonLake_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("HealthWithProfit"), "ai_HealthWithProfit_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("KingsGuard"), "ai_KingsGuard_1");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""),"stage2" );
        deck2.addCardWithSetID(Resources.getSpecificCard(""),"stage2" );
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard(""),"stage2" );
//        deck2.setItemWithID(Resources.getSpecificItem(""), "stage2");
        stageResources.add(new StageResources(2, 1000, deck1));
        Deck deck3 = new Deck("stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3" );
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard(""), "stage3");
  //      deck3.setItemWithID(Resources.getSpecificItem(""),"stage3" );
        stageResources.add(new StageResources(3, 1500, deck1));
    }
}


