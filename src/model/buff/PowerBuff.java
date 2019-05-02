package model.buff;

public class PowerBuff extends Buff {
    public PowerBuff(int changeHp, int changeAp, int numberOfTurns, int delay) {
        if (changeAp > 0 || changeHp > 0)
            this.isPositive = true;
        if (changeHp < 0 || changeAp < 0)
            this.isPositive = false;
        this.changeHp = changeHp;
        this.changeAp = changeAp;
        this.numberOfTurns = numberOfTurns;
        this.delay = delay;
    }
}
