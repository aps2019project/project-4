public class RangedHero extends Hero {
    private int distanceOfAttack;

    public RangedHero(String name, int price, int hp, int ap, int mp, int distanceOfAttack) {
        super(name, price, hp, ap, mp);
        this.distanceOfAttack = distanceOfAttack;
    }
}
