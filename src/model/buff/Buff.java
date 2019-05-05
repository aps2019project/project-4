package model.buff;

import model.Cell;
import model.Enums;
import model.Minion;

public class Buff {
    protected int numberOfTurnsOnTarget;
    protected int changeHp;
    protected int apShield;
    protected int changeAp;
    protected int numberOfTurns;
    protected int delay;
    protected boolean isDisarmer;
    protected boolean isStunner;
    protected boolean isPositive;
    protected Enums.OnCellOrSoldier onCellOrSoldier;
    protected Minion minion;
    protected Cell cell;
    protected boolean isActive;

    public int getChangeAp() {
        return changeAp;
    }

    public int getChangeHp() {
        return changeHp;
    }

    public int getDelay() {
        return delay;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public Cell getCell() {
        return cell;
    }

    public int getNumberOfTurnsOnTarget() {
        return numberOfTurnsOnTarget;
    }

    public void setNumberOfTurnsOnTarget(int numberOfTurnsOnTarget) {
        this.numberOfTurnsOnTarget = numberOfTurnsOnTarget;
    }

    public void nutralize(){

    }

    public void stickBuff(Cell cell){
        if (onCellOrSoldier == Enums.OnCellOrSoldier.SOLDIER){
            if (isPositive == true)
                cell.getMinion().getPositiveBuffs().add(this);
            else
                cell.getMinion().getPositiveBuffs().add(this);
        }
        else{
            cell.addBuff(this);
        }
    }

    public int getApShield() {
        return apShield;
    }

    public boolean isDisarmer() {
        return isDisarmer;
    }

    public boolean isStunner() {
        return isStunner;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public Enums.OnCellOrSoldier getOnCellOrSoldier() {
        return onCellOrSoldier;
    }

    public Minion getMinion() {
        return minion;
    }

    public boolean isActive() {
        return isActive;
    }
}
