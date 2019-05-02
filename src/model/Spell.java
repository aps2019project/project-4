package model;

import model.buff.Buff;

import java.util.ArrayList;

public class Spell extends Card {

    private Enums.FriendOrEnemy target;
    private Enums.WhichCellsType cellsType;
    private int lengthOfSideOfSquare;
    private Enums.BuffNutralizer buffNutralizer;
    private ArrayList<Buff> buffs = new ArrayList<>();
    private ArrayList<Cell> cells = new ArrayList<>();

    public Spell(String id, String name, int requiredManas,
                 int price, Enums.FriendOrEnemy target, Enums.WhichCellsType cellsType,
                 Enums.BuffNutralizer buffNutralizer, int lengthOfSideOfSquare) {
        this.id = id;
        this.name = name;
        this.requiredManas = requiredManas;
        this.price = price;
        this.target = target;
        this.cellsType = cellsType;
        this.buffNutralizer = buffNutralizer;
        this.lengthOfSideOfSquare = lengthOfSideOfSquare;
    }
    public void addBuff(Buff buff){
        buffs.add(buff);
    }

    @Override
    public void insert(Cell cell){

    }
    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder()
                .append("Spell:\n")
                .append("Name: ").append(name).append("\n")
                .append("MP: ").append(requiredManas).append("\n")
                .append("Cost: ").append(price).append("\n")
                .append("Desc: ").append(desc).append("\n");
        return result;
    }

    @Override
    public StringBuilder infoForDeck() {
        StringBuilder result = new StringBuilder();
        result.append("Type : Spell - Name : ").append(this.getName())
                .append(" - MP : ").append(this.getRequiredManas())
                .append(" - Desc : ").append(this.getDesc());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice() {
        return this.infoForDeck().append(" - Sell Cost : ").append(this.getPrice());
    }
}
