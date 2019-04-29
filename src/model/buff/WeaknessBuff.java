package model.buff;

public class WeaknessBuff extends Buff {
    private int healthReduction;
    private int attackPointReduction;

    public WeaknessBuff(int healthReduction, int attackPointReduction){}
    public WeaknessBuff(int healthReduction, int attackPointReduction, int numberOfTurns){}
    public WeaknessBuff(int healthReduction, int attackPointReduction, int numberOfTurns, int numberOfTurnsLater){}

}
