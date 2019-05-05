package model.buff;

import model.Enums;

public class HolyBuff extends Buff {
    public HolyBuff(int apShield, int numberOfTurns, int delay, Enums.OnCellOrSoldier onCellOrSoldier) {
        if (apShield > 0)
            this.isPositive = true;
        if (apShield < 0)
            this.isPositive = false;
        this.apShield = apShield;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
        this.onCellOrSoldier = onCellOrSoldier;
    }
}
