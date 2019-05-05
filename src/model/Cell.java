package model;

import model.buff.Buff;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int x;
    private int y;
    private ArrayList<Buff> buffs;
    private Minion minion;
    private boolean isFlag;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getIsFlag() {
        return isFlag;
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }

    public int getDistance(int x, int y){
        return Math.abs(x - this.x) + Math.abs(y - this.y);
    }
    public void addBuff(Buff buff){
        buffs.add(buff);
    }

    public ArrayList<Buff> getBuffs() {
        return buffs;
    }

    public void applyBuff(Buff buff){

    }

    public void addFlag() {
        isFlag = true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
