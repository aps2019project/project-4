package model;

import java.util.ArrayList;

public abstract class Item {
    private String name;
    private ArrayList<Cell> cellTargets;

    public void addCellToTargets(Cell cell){}
}
