package model;

public class Dispel extends Spell {
    public Dispel(String id, String name, int requiredManas,
                 int price, Enums.FriendOrEnemy target,
                 Enums.WhichCellsType cellsType, int lengthOfSideOfSquare){
        super(id, name, requiredManas, price, target, cellsType, lengthOfSideOfSquare);
    }
}
