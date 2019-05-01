package model;

public class Enums {
    public enum ActivationTypes{
        ON_ATTACK, COMBO, ON_DEFEND, ON_SPAWN, PASSIVE, ON_DEATH
    }

    public enum GameMode{
        SINGLE_PLAYER, MULTI_PLAYER, STORY, CUSTOM_GAME
    }

    public enum Menus {
        ACCOUNT, MAIN, BATTLE, SHOP, COLLECTION
    }

    public enum SoldierType {
        MELEE, RANGED, HYBRID
    }

    public enum FriendOrEnemy{
        FRIEND, ENEMY, BOTH, ENEMY_HERO
    }

    public enum WhichCellsType{
        MONO_CELL, SQUARE, COLUMN, ROW, ALL
    }

    public enum OnCellOrSoldier{
        CEll, SOLDIER
    }

    public enum TypeOfThing{
        HERO , NONHERO , ITEM
    }

    public enum BuffNutralizer{
        POSITIVE, NEGATIVE, NONE
    }

}

