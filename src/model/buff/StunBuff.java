package model.buff;

import model.Enums;

public class StunBuff extends Buff {
    public StunBuff(int numberOfTurns, int delay, Enums.OnCellOrSoldier onCellOrSoldier){
        this.isPositive = false;
        this.isStunner = true;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
        this.onCellOrSoldier = onCellOrSoldier;
    }
}
