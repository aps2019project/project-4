import java.util.ArrayList;

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

    public int getDistance(int x, int y){
        return Math.abs(x - this.x) + Math.abs(y - this.y);
    }
}
