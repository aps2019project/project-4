package model.buff;

public class PoisonBuff extends Buff {
    public PoisonBuff(int changeHp, int numberOfTurnsOnTarget, int numberOfTurns, int delay){
        this.isPositive = false;
        this.changeHp = changeHp;
        this.numberOfTurnsOnTarget = numberOfTurnsOnTarget;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
    }
}
