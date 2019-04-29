package model;

public class Buff {
    private int changeHp;
    private int changeAp;
    private int numberOfTurns;
    private int delay;
    private boolean isDisarmer;
    private String targetType;
    private int[] x;
    private int[] y;

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

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public void nutralize(){

    }
}
