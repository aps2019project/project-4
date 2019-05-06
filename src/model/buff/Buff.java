package model.buff;

import model.Cell;
import model.Enums;

public abstract class Buff {
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
    protected Cell cell;
    protected boolean isActive;

    public Buff clone(){
            Buff buff = new Buff(){};
            buff.numberOfTurnsOnTarget = this.numberOfTurnsOnTarget;
            buff.changeHp = this.changeHp;
            buff.apShield = this.apShield;
            buff.changeAp = this.changeAp;
            buff.numberOfTurns = this.numberOfTurns;
            buff.delay = this.delay;
            buff.isDisarmer = this.isDisarmer;
            buff.isStunner = this.isStunner;
            buff.isPositive = this.isPositive;
            buff.onCellOrSoldier = this.onCellOrSoldier;
            buff.cell = null;
            buff.isActive = this.isActive;
            return buff;
    }

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

    public void stickBuffTo(Cell cell){
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

    public boolean isActive() {
        return isActive;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }
}
