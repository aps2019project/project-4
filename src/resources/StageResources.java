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
        Deck deck1 = new Deck("1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("persianArcher"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("transoxanionSpearman"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("1"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("9"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("11"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("11"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("13"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("17"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("18"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("21"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("22"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("26"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("38"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("36"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("40"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("1"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("7"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("10"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard("11"), "stage1");
        deck1.addCardWithSetID(Resources.getSpeceficCard(""), "stage1");
        deck1.setItemWithID(Resources.getSpeceficItem(""), "stage1");
        stageResources.add(new StageResources(1, 500, deck1));
        Deck deck2 = new Deck("2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""),"stage2" );
        deck2.addCardWithSetID(Resources.getSpeceficCard(""),"stage2" );
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""), "stage2");
        deck2.addCardWithSetID(Resources.getSpeceficCard(""),"stage2" );
        deck2.setItemWithID(Resources.getSpeceficItem(""), "stage2");
        stageResources.add(new StageResources(2, 1000, deck1));
        Deck deck3 = new Deck("1");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3" );
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.addCardWithSetID(Resources.getSpeceficCard(""), "stage3");
        deck3.setItemWithID(Resources.getSpeceficItem(""),"stage3" );
        stageResources.add(new StageResources(3, 1500, deck1));
    }
}


