package model.buff;

import model.Enums;

public class PoisonBuff extends Buff {
    public PoisonBuff(int changeHp, int numberOfTurnsOnTarget, int numberOfTurns, int delay, Enums.OnCellOrSoldier onCellOrSoldier){
        this.isPositive = false;
        this.changeHp = changeHp;
        this.numberOfTurnsOnTarget = numberOfTurnsOnTarget;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
        this.onCellOrSoldier = onCellOrSoldier;
    }
}
