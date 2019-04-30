package model;

import model.buff.Buff;

import java.util.ArrayList;

public class Minion extends Card {
    private int healthPoint;
    private int attackPoint;
    private int startRange;
    private int endRange;
    private Enums.SoldierType type;
    private boolean hasAttackedThisTurn;
    private boolean hasMovedThisTurn;
    private boolean isDisarmed;
    private boolean isStuned;
    private int numberOfTurnsOfDisarm;
    private int numberOfTurnsOfStun;
    private GameBoard gameBoard;
    private Cell cellPlace;
    private Spell specialPower;
    private Enums.ActivationTypes specialPowerActivationType;
    private ArrayList<Buff> positiveBuffs;
    private ArrayList<Buff> negativeBuffs;

    public Minion(String name, int price, int hp, int ap, int mp, int startRange, int endRange) {
        this.name = name;
        this.price = price;
        this.requiredManas = mp;
        this.healthPoint = hp;
        this.attackPoint = ap;
        this.startRange = startRange;
        this.endRange = endRange;
        if (startRange == 1 && endRange == 1)
            type = Enums.SoldierType.MELEE;
        if (startRange > 1)
            type = Enums.SoldierType.RANGED;
        if (startRange == 1 && endRange > 1)
            type = Enums.SoldierType.HYBRID;
    }

    public int getHP() {
        return healthPoint;
    }

    public int getAP() {
        return attackPoint;
    }

    public Enums.SoldierType getType() {
        return type;
    }

    public Spell getSpecialPower() {
        return specialPower;
    }

    public void lockMovement() {
        this.hasMovedThisTurn = true;
    }

    public void lockAttack() {
        this.hasAttackedThisTurn = true;
    }

    public void attack(Minion minion) {
        if (this.isStuned || this.hasAttackedThisTurn) {
            System.out.printf("model.Card with id: %s can't attack\n", this.id);
            return;
        }
        if (cellPlace.getDistance(minion.cellPlace.getX(), minion.cellPlace.getY()) > endRange ||
                cellPlace.getDistance(minion.cellPlace.getX(), minion.cellPlace.getY()) < startRange) {
            System.out.println("Opponent minion or hero is unavailable for attack");
            return;
        }
        minion.changeHp(-this.attackPoint);
        this.lockAttack();
    }

    public void moveTo(Cell cell) {
        if (this.hasMovedThisTurn) {
            System.out.printf("This card with id: %s has moved this turn\n", this.id);
            return;
        }
        if (this.isStuned) {
            System.out.printf("This card with id: %s is stuned\n", this.id);
            return;
        }
        if (cell.getMinion() != null ||
                cellPlace.getDistance(cell.getX(), cell.getY()) > endRange ||
                cellPlace.getDistance(cell.getX(), cell.getY()) < startRange) {
            System.out.println("Invalid target");
            return;
        }
    }

    public void changeHp(int number) {
        this.healthPoint += number;
    }

    public void changeAp(int number) {
        this.attackPoint += number;
    }

    public boolean isMinionsBetween(int x, int y) {
        if (this.cellPlace.getX() == x) {
            if (this.cellPlace.getY() > y) {
                for (int i = y; i < cellPlace.getY(); i++) {
                    if (this.gameBoard.getCell(x, i).getMinion() != null) {
                        System.out.println("Invalid target");
                        return true;
                    }
                }
            }
            if (this.cellPlace.getY() < y) {
                for (int i = y; i < cellPlace.getY(); i--) {
                    if (this.gameBoard.getCell(x, i).getMinion() != null) {
                        System.out.println("Invalid target");
                        return true;
                    }
                }
            }
        }
        if (this.cellPlace.getY() == y) {
            if (this.cellPlace.getX() > x) {
                for (int i = x; i < cellPlace.getX(); i++) {
                    if (this.gameBoard.getCell(i, y).getMinion() != null) {
                        System.out.println("Invalid target");
                        return true;
                    }
                }
            }
            if (this.cellPlace.getX() < x) {
                for (int i = x; i < cellPlace.getX(); i--) {
                    if (this.gameBoard.getCell(i, y).getMinion() != null) {
                        System.out.println("Invalid target");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder()
                .append("model.Minion:\n")
                .append("Name: ").append(name).append("\n")
                .append("HP: ").append(healthPoint + " ").append("AP: ").append(attackPoint + " ")
                .append("MP: ").append(requiredManas).append("\n")
                .append("Range: ").append(type).append(" ");
        if (type != Enums.SoldierType.MELEE) {
            result.append(endRange - startRange)
                    .append("\n");
        }
        result.append("Combo Ability: ").append(specialPowerActivationType).append("\n")
                .append("Cost: ").append(price).append("\n")
                .append("Description: ").append(desc).append("\n");
        return result;
    }

    @Override
    public StringBuilder infoForDeck() {
        StringBuilder result = new StringBuilder()
                .append("Type : Minion - Name : ").append(this.getName()).append(" - Class : ")
                .append(this.getSpecialPower().getName()).append(" - AP : ").append(this.getAP())
                .append(" - HP : ").append(this.getHP())
                .append(" - MP : ").append(this.getRequiredManas())
                .append(" -Special power: ").append(this.getSpecialPower().getDesc());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice() {
        return this.infoForDeck().append(" - Sell Cost : ").append(this.getPrice());
    }

}


