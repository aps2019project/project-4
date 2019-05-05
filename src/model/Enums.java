package model;

public class Enums {
    public enum ActivationTypes{
        NONE, ON_ATTACK, COMBO, ON_DEFEND, ON_SPAWN, PASSIVE, ON_DEATH
    }

    public enum GameMode{
        SINGLE_PLAYER, MULTI_PLAYER, STORY, CUSTOM_GAME, MONO_FLAG, MULTIPLE_FLAG
    }

    public enum Menus {
        ACCOUNT, MAIN, BATTLE, SHOP, COLLECTION , GRAVEYARD
    }

    public enum SoldierType {
        MELEE, RANGED, HYBRID
    }

    public enum FriendOrEnemy{
        Friend, ENEMY, BOTH, ENEMY_HERO, FRIEND_HERO, FRIEND_MINION, ENEMY_MINION
    }

    public enum WhichCellsType{
        MONO_CELL, SQUARE, COLUMN, ROW, ALL, RANDOM_MINION_AROUND_HERO, RANDOM_MINION_AROUND,
        ALL_MINIONS_AROUND, ALL_MINIONS_AROUND_DISTANCE_2, ALL_MINIONS_AROUND_AND_ITSELF
    }

    public enum OnCellOrSoldier{
        CEll, SOLDIER
    }
    //todo add OnCellOrSoldier to buffs of spells

    public enum TypeOfThing{
        HERO , NONHERO , ITEM
    }

    public enum BuffNutralizer{
        POSITIVE, NEGATIVE, BOTH, NONE
    }

}

