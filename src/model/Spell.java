package model;

import model.buff.Buff;
import resources.Resources;

import java.util.ArrayList;

public class Spell extends Card {
    private Enums.OnCellOrSoldier cellOrSoldier;
    private Enums.FriendOrEnemy target;
    private Enums.WhichCellsType cellsType;
    private int lengthOfSideOfSquare;
    private Enums.BuffNutralizer buffNutralizer;
    private ArrayList<Buff> buffs = new ArrayList<>();
    private ArrayList<Cell> cells = new ArrayList<>();

    public Spell(String id, String name, int requiredManas, int price,
                 Enums.OnCellOrSoldier cellOrSoldier, Enums.FriendOrEnemy target, Enums.WhichCellsType cellsType,
                 Enums.BuffNutralizer buffNutralizer, int lengthOfSideOfSquare) {
        this.id = id;
        this.name = name;
        this.requiredManas = requiredManas;
        this.price = price;
        this.cellOrSoldier = cellOrSoldier;
        this.target = target;
        this.cellsType = cellsType;
        this.buffNutralizer = buffNutralizer;
        this.lengthOfSideOfSquare = lengthOfSideOfSquare;
    }

    public Spell clone() {
        Spell spell = (Spell) Resources.getSpecificCard(this.getName());
        if (spell == null)
            return null;
        spell.setId(this.getId());
        return spell;
    }

    public void addBuff(Buff buff) {
        buffs.add(buff);
    }

    public ArrayList<Buff> getBuffs() {
        return buffs;
    }

    public Enums.OnCellOrSoldier getCellOrSoldier() {
        return cellOrSoldier;
    }

    public Enums.FriendOrEnemy getTarget() {
        return target;
    }

    public Enums.WhichCellsType getCellsType() {
        return cellsType;
    }

    public int getLengthOfSideOfSquare() {
        return lengthOfSideOfSquare;
    }

    public Enums.BuffNutralizer getBuffNutralizer() {
        return buffNutralizer;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    @Override
    public void insert(Cell cell) {
        for (Buff buff : this.buffs)
            buff.stickBuffTo(cell);
    }

    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder()
                .append("Spell:\n")
                .append("Name: ").append(name).append("\n")
                .append("ID : ").append(id).append("\n")
                .append("MP: ").append(requiredManas).append("\n")
                .append("Cost: ").append(price).append("\n")
                .append("Desc: ").append(description).append("\n");
        return result;
    }

    @Override
    public StringBuilder infoForDeck() {
        StringBuilder result = new StringBuilder();
        result.append("Type : Spell - Name : ").append(this.getName())
                .append(" - ID : ").append(this.getId())
                .append(" - MP : ").append(this.getRequiredManas())
                .append(" - Description : ").append(this.getDescription());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice() {
        return this.infoForDeck().append(" - Sell Cost : ").append(this.getPrice());
    }

    @Override
    public StringBuilder infoForShop() {
        return this.infoForDeck().append(" - Buy Cost : ").append(this.getPrice());
    }

    public boolean isPoisonous() {
        for (Buff buff : buffs)
            if (buff.isPoison())
                return true;
        return false;
    }

}
