package model;

public abstract class Card {
    protected String id;
    protected String name;
    protected int requiredManas;
    protected int price;
    protected String desc;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRequiredManas() {
        return requiredManas;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public abstract StringBuilder info();

    public abstract StringBuilder infoForDeck();

    public abstract StringBuilder infoForDeckWithPrice();

    public abstract void insert(Cell cell);
}
