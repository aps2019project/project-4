package model;

public class KingsGuard extends Spell {
    public KingsGuard(String id, String name, int requiredManas,
                  int price, Enums.FriendOrEnemy target,
                  Enums.WhichCellsType cellsType, int lengthOfSideOfSquare){
        super(id, name, requiredManas, price, target, cellsType, lengthOfSideOfSquare);
    }
}
