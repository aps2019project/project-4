package model;

public class UsableItem {
    private int price;
    private String name;
    private String description;
    private String id;

    public UsableItem(String name, int price) {
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StringBuilder info() {
        return new StringBuilder("Name : ").append(this.getName())
                .append(" - ID: ").append(this.getId())
                .append(" - Desc: ").append(this.getDescription());
    }

    public StringBuilder infoWithPrice() {
        return this.info().append(" - Sell Cost : ").append(this.getPrice());
    }

    public StringBuilder infoForShop() {
        return this.info().append(" - Buy Cost : ").append(this.getPrice());
    }
}
