package model.buff;

import model.Enums;

public class FireBuff extends Buff {
    public FireBuff(int changeHp, int numberOfTurns, int delay, Enums.OnCellOrSoldier onCellOrSoldier){
        this.isPositive = false;
        this.changeHp = changeHp;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
        this.onCellOrSoldier = onCellOrSoldier;
    }
}
