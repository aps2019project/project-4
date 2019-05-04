package model;

public class KingsGuard extends Spell {
    public KingsGuard(String id, String name, int requiredManas,
                      int price, Enums.OnCellOrSoldier onCellOrSoldier,  Enums.FriendOrEnemy target,
                      Enums.WhichCellsType cellsType, Enums.BuffNutralizer buffNutralizer, int lengthOfSideOfSquare){
        super(id, name, requiredManas, price, onCellOrSoldier, target, cellsType,  buffNutralizer, lengthOfSideOfSquare);
    }
}
