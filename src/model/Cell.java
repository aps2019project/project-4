package model;

import model.buff.Buff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cell {
    private int x;
    private int y;
    private ArrayList<Buff> buffs;
    private Minion minion;
    private boolean isFlag;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public int getDistance(int x, int y) {
        return Math.abs(x - this.x) + Math.abs(y - this.y);
    }

    public void addBuff(Buff buff) {
        buffs.add(buff);
    }

    public ArrayList<Buff> getBuffs() {
        return buffs;
    }

    public void applyBuffs() {
        for (Buff buff : buffs){
            minion.applyBuff(buff);
        }
        for (Buff buff : minion.getNegativeBuffs())
            minion.applyBuff(buff);
        for (Buff buff : minion.getPositiveBuffs())
            minion.applyBuff(buff);
    }

    public void addFlag() {
        isFlag = true;
    }

    public boolean isEmpty(){
        if (minion == null)
            return true;
        return false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void removeExpiredBuffs(){
        Iterator<Buff> iterator = buffs.iterator();
        while (iterator.hasNext()){
            Buff buff = iterator.next();
            if (buff.getNumberOfTurns() <= 0)
                iterator.remove();
        }
    }
}
