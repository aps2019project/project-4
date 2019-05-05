package model.buff;

import model.Enums;

public class DisarmBuff extends Buff {
    public DisarmBuff(int numberOfTurns, int delay){
        this.isPositive = false;
        this.isDisarmer = true;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
        this.onCellOrSoldier = Enums.OnCellOrSoldier.SOLDIER;
    }
}
