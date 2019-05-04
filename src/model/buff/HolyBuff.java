package model.buff;

import model.Enums;

public class HolyBuff extends Buff {
    public HolyBuff(int apShield, int numberOfTurns, int delay, Enums.OnCellOrSoldier onCellOrSoldier){
    this.isPositive = true;
        this.apShield = apShield;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
        this.onCellOrSoldier = onCellOrSoldier;
    }
}
