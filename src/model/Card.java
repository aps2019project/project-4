package model;

public abstract class Card {
    protected String id;
    protected String name;
    protected int requiredManas;
    protected int price;
    protected String description;

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

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract Card clone();

    public abstract StringBuilder info();

    public abstract StringBuilder infoForDeck();

    public abstract StringBuilder infoForDeckWithPrice();

    public abstract StringBuilder infoForShop();

    public abstract void insert(Cell cell);
}
