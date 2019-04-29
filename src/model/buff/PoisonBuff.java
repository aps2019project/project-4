package model.buff;

public class PoisonBuff extends Buff {
    public PoisonBuff(int changeHp, int numberOfTurns, int delay){
        this.isPositive = false;
        this.changeHp += changeHp;
    }
}
