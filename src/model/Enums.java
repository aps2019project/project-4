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
        Friend, ENEMY, BOTH, ENEMY_HERO, FRIEND_HERO, FRIEND_MINION, ENEMY_MINION
    }

    public enum WhichCellsType{
        MONO_CELL, SQUARE, COLUMN, ROW, ALL, RANDOM_MINION_AROUND_HERO
    }

    public enum OnCellOrSoldier{
        CEll, SOLDIER
    }

    public enum TypeOfThing{
        HERO , NONHERO , ITEM
    }

    public enum BuffNutralizer{
        POSITIVE, NEGATIVE, BOTH, NONE
    }

}

