package model;

import resources.Resources;

import java.util.ArrayList;

public class Stage {
    public static ArrayList<Stage> stages = new ArrayList<>();
    private int mode;
    private int gift;
    private Deck deck;

    public Stage(int mode, int gift, Deck deck) {
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

    public static Stage getStage(int number){
        return stages.get(number);
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
        stages.add(new Stage(1, 500, deck1));
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
        stages.add(new Stage(2, 1000, deck1));
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
        stages.add(new Stage(3, 1500, deck1));
    }
}


