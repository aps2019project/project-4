public class HybridHero extends Hero {
    private int distanceOfAttack;

    public HybridHero(String name, int price, int hp, int ap, int mp, int distanceOfAttack) {
        super(name, price, hp, ap, mp);
        this.distanceOfAttack = distanceOfAttack;
    }
}
