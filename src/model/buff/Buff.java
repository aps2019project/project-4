package model.buff;

import model.Cell;
import model.Enums;
import model.Minion;

public class Buff {
    protected int changeHp;
    protected int apShield;
    protected int changeAp;
    protected int numberOfTurns;
    protected int delay;
    protected boolean isDisarmer;
    protected boolean isStunner;
    protected boolean isPositive;
    protected Enums.OnCellOrSoldier cellOrSoldier;
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

    public void nutralize(){

    }
}
