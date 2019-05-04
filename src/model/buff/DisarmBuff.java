package model.buff;

import model.Enums;

public class DisarmBuff extends Buff {
    public DisarmBuff(int numberOfTurns, int delay, Enums.OnCellOrSoldier onCellOrSoldier){
        this.isPositive = false;
        this.isDisarmer = true;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
        this.onCellOrSoldier = onCellOrSoldier;
    }
}
