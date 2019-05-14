package model;

import resources.Resources;

public class Hero extends Minion {
    private int coolDown;
    private boolean isSpecialPowerActive = true;

    public boolean isSpecialPowerActive() {
        return isSpecialPowerActive;
    }

    public void setSpecialPowerActive(boolean specialPowerActive) {
        isSpecialPowerActive = specialPowerActive;
    }

    public Hero(String id, String name, int price, int hp, int ap, int mp, int startRange, int endRange,
                int coolDown, boolean isAntiHolyBuff, boolean isAntiDisarm,
                boolean isAntiPoison, boolean isImmortal, boolean isApSuperior,
                Enums.ActivationTypes specialPowerActivationType) {
        super(id, name, price, mp, hp, ap, startRange, endRange, isAntiHolyBuff,
                isAntiDisarm, isAntiPoison, isImmortal, isApSuperior, specialPowerActivationType);
        this.coolDown = coolDown;
    }

    public Hero clone() {
        Hero hero = (Hero) Resources.getSpecificCard(this.getName());
        if (hero == null)
            return null;
        hero.setId(this.getId());
        return hero;
    }

    public int getCoolDown() {
        return coolDown;
    }

    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder()
                .append("Hero:\n")
                .append("Name: ").append(name).append("\n")
                .append("ID : ").append(id).append("\n")
                .append("Cost: ").append(price).append("\n");
        if (!(this.getDescription() == null))
            result.append("Description: ").append(description).append("\n");
        return result;
    }

    @Override
    public StringBuilder infoForDeck() {
        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(this.getName())
                .append(" - ID : ").append(this.getId())
                .append(" - AP : ").append(this.getAttackPoint())
                .append(" - HP : ").append(this.getHealthPoint())
                .append(" - Class : ").append(this.getType());
        if (!(this.getDescription() == null))
            result.append(" - Special power: ").append(this.getSpecialPower().getDescription());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice() {
        return this.infoForDeck().append(" - Sell Cost: ").append(this.getPrice());
    }
}