package model.buff;

import model.Cell;
import model.Enums;

public class Buff {
    protected int numberOfTurnsOnTarget;
    protected int changeHp;
    protected int apShield;
    protected int changeAp;
    protected int numberOfTurns;
    protected int delay;
    protected boolean isPoison;
    protected boolean isDisarmer;
    protected boolean isStunner;
    protected boolean isPositive;
    protected Enums.OnCellOrSoldier onCellOrSoldier;
    protected Cell cell;
    protected boolean isActive;

    public int getChangeAp() {
        return changeAp;
    }

    public boolean isPoison() {
        return isPoison;
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

    public void nutralize(Enums.BuffNutralizer buffNutralizer) {
        switch (buffNutralizer) {
            case POSITIVE:
        }
    }

    public void stickBuffTo(Cell cell) {
        if (onCellOrSoldier == Enums.OnCellOrSoldier.SOLDIER) {
            if (isPositive)
                cell.getMinion().getPositiveBuffs().add(this);
            else
                cell.getMinion().getNegativeBuffs().add(this);
            cell.getMinion().applyBuff(this);
        } else {
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

    public void reduceDelay() {
        if (delay > 0)
            delay--;
    }

    public void reduceNumberOfTurns() {
        if (numberOfTurns > 0)
            numberOfTurns --;
        if (numberOfTurnsOnTarget > 0)
            numberOfTurnsOnTarget --;
    }
}
