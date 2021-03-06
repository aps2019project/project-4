package model.buff;

import model.Enums;

public class WeaknessBuff extends Buff {
    public WeaknessBuff(int changeHp, int changeAp, int numberOfTurnsOnTarget, int numberOfTurns, int delay, Enums.OnCellOrSoldier onCellOrSoldier){
        this.changeAp = changeAp;
        this.changeHp = changeHp;
        this.numberOfTurns = numberOfTurns;
        this.numberOfTurnsOnTarget = numberOfTurnsOnTarget;
        this.delay = delay;
        this.onCellOrSoldier = onCellOrSoldier;
    }
}
