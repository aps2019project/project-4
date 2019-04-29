package model;

import javafx.scene.control.Cell;

import java.util.ArrayList;

public class Spell extends Card {


    private Enums.FriendEnemy target;
    private Enums.WhichCellsType cellsType;
    private ArrayList<Cell> cells = new ArrayList<>();

    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder()
                .append("model.Spell:\n")
                .append("Name: ").append(name).append("\n")
                .append("MP: ").append(requiredManas).append("\n")
                .append("Cost: ").append(price).append("\n")
                .append("Desc: ").append(desc).append("\n");
        return result;
    }

    @Override
    public StringBuilder infoForDeck() {
        StringBuilder result = new StringBuilder();
        result.append("Type : model.Spell - Name : ").append(this.getName())
                .append(" - MP : ").append(this.getRequiredManas())
                .append(" - Desc : ").append(this.getDesc());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice() {
        return this.infoForDeck().append(" - Sell Cost : ").append(this.getPrice());
    }
}
