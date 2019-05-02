package model.buff;

public class HolyBuff extends Buff {
    public HolyBuff(int apShield, int numberOfTurns, int delay){
    this.isPositive = true;
        this.apShield = apShield;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
    }
}
