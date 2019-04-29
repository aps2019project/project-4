package model.buff;

public class StunBuff extends Buff {
    public StunBuff(int numberOfTurns, int delay){
        this.isPositive = false;
        this.isStunner = true;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
    }
}
