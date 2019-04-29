package model.buff;

import model.Cell;
import model.Enums;

public class Buff {
    private int changeHp;
    private int changeAp;
    private int numberOfTurns;
    private int delay;
    private boolean isDisarmer;
    private boolean isPositive;
    private Cell cell;

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
