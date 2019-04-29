package model;

public class PoisonBuff extends NegativeBuff {
    private int healthReduction;

    public PoisonBuff(int healthReduction){}
    public PoisonBuff(int healthReduction, int numberOfTurns){}
    public PoisonBuff(int healthReduction, int numberOfTurns, int numberOfTurnsLater){}
}
