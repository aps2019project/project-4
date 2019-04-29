package model.buff;

public class PowerBuff extends Buff {
    public PowerBuff(int changeHp, int changeAp, int numberOfTurns, int delay) {
        this.isPositive = true;
        this.changeHp += changeHp;
        this.changeAp += changeAp;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
    }
}
