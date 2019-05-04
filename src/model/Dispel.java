package model;

public class Dispel extends Spell {
    public Dispel(String id, String name, int requiredManas,
                  int price, Enums.OnCellOrSoldier cellOrSoldier, Enums.FriendOrEnemy target,
                  Enums.WhichCellsType cellsType, Enums.BuffNutralizer buffNutralizer, int lengthOfSideOfSquare){
        super(id, name, requiredManas, price, cellOrSoldier, target, cellsType, buffNutralizer, lengthOfSideOfSquare);
    }
}
