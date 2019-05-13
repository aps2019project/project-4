package resources;

import model.Deck;
import org.jetbrains.annotations.Contract;
import views.View;

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

    public Deck getDeck() {
        return deck;
    }

    public void showStage() {
        View.showDeck(this.getDeck());
    }

    public static void showStages() {
        System.out.println("Stage 1: 500 deck reward , mode 1");
        stageResources.get(0).showStage();
        System.out.println("Stage 2: 1000 deck reward , mode 2");
        stageResources.get(1).showStage();
        System.out.println("Stage 3: 1500 deck reward , mode 3");
        stageResources.get(2).showStage();
    }

    public static StageResources getStage(int number) {
        return stageResources.get(number);
    }

    public static void setStageResource() {
        Deck deck1 = new Deck("stage1");
        deck1.addCardWithSetID(Resources.getSpecificCard("Total Disarm"), "ai_TotalDisarm_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("Lightning Bolt"), "ai_LightningBolt_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("All Disarm"), "ai_AllDisarm_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("All Poison"), "ai_AllPoison_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("Dispel"), "ai_Dispel_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("Shock"), "ai_Shock_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("Sacrifice"), "ai_Sacrifice_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("persian archer"), "ai_persianArcher_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("transoxanian spearsman"), "ai_transoxaninaSpearsman_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("transoxanian maceman"), "ai_transoxanianMaceman_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("transoxanian maceman"), "ai_transoxanianMaceman_2");
        deck1.addCardWithSetID(Resources.getSpecificCard("black devil"), "ai_blackDevil_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("monoeyed giant"), "ai_monoeyedGiant_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("poisonous snake"), "ai_poisonousSnake_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("giant snake"), "ai_giantSnake_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("white wolf"), "ai_whiteWolf_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("grand witch"), "ai_grandWitch_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("queen of winter"), "ai_queenOfWinter_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("siavash"), "ai_siavash_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("arzhang deeve"), "ai_arzhangDeeve_1");
        deck1.addCardWithSetID(Resources.getSpecificCard("white deeve"), "ai_whiteDeeve_1");
        deck1.setItemWithID(Resources.getSpecificItem("Soul Eater"), "stage1");
//        deck1.setItemWithID(Resources.getSpecificItem(/*//todo add item 1*/""), "stage1");
        stageResources.add(new StageResources(1, 500, deck1));
        Deck deck2 = new Deck("stage2");
        deck2.addCardWithSetID(Resources.getSpecificCard("Area Dispel"), "ai_AreaDispel_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("Empower"), "ai_Empower_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("God Strength"), "ai_GodStrength_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("Madness"), "ai_Madness_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("Poison Lake"), "ai_PoisonLake_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("HealthWithProfit"), "ai_HealthWithProfit_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("Kings Guard"), "ai_KingsGuard_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("persian swordsman"), "ai_persianswordsman_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("persian spearsman"), "ai_persian spearsman_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("persian champion"), "ai_persianchampion_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("transoxanian slingman"), "ai_transoxanianslingman_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("transoxanian prince"), "ai_transoxanianprince_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("eagle"), "ai_eagle_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("eagle"), "ai_eagle_2");
        deck2.addCardWithSetID(Resources.getSpecificCard("fiery dragon"), "ai_fierydragon_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("panther"), "ai_panther_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("genii"), "ai_genii_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("geeve"), "ai_geeve_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("iraj"), "ai_iraj_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("giant king"), "ai_giantking_1");
        deck2.addCardWithSetID(Resources.getSpecificCard("zahhak"), "ai_zahhak_1");
        deck2.setItemWithID(Resources.getSpecificItem("Soul Eater"), "stage2");
        stageResources.add(new StageResources(2, 1000, deck2));
        Deck deck3 = new Deck("stage3");
        deck3.addCardWithSetID(Resources.getSpecificCard("arash"), "ai_arash_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("persian commander"), "ai_persiancommander_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("transoxanian archer"), "ai_transoxanianarcher_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("transoxanian spy"), "ai_transoxanianspy_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("stoneman giant"), "ai_stonemangiant_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("swinerider devil"), "ai_swineriderdevil_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("swinerider devil"), "ai_swineriderdevil_2");
        deck3.addCardWithSetID(Resources.getSpecificCard("predator lion"), "ai_predatorlion_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("wolf"), "ai_wolf_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("witch"), "ai_witch_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("wild swine"), "ai_wildswine_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("elder"), "ai_elder_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("bahman"), "ai_bahman_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("big giant"), "ai_biggiant_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("Hell Fire"), "ai_HellFire_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("All Disarm"), "ai_AllDisarm_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("Dispel"), "ai_Dispel_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("PowerUp"), "ai_PowerUp_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("All Power"), "ai_AllPower_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("All Attack"), "ai_AllAttack_1");
        deck3.addCardWithSetID(Resources.getSpecificCard("Weakening"), "ai_Weakening_1");
        deck3.setItemWithID(Resources.getSpecificItem("Terror Hood"),"stage3" );
        stageResources.add(new StageResources(3, 1500, deck3));
    }
}


