package model.buff;

public class FireBuff extends Buff {
    public FireBuff(int changeHp, int numberOfTurns, int delay){
        this.isPositive = false;
        this.changeHp = changeHp;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
    }
}
