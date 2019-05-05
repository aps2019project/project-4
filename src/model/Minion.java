package model;

import model.buff.Buff;
import views.View;

import java.util.ArrayList;
import java.util.Iterator;

public class Minion extends Card {
    private int healthPoint;
    private int attackPoint;
    private int startRange;
    private int endRange;
    private Enums.SoldierType type;
    private boolean hasAttackedThisTurn;
    private boolean hasMovedThisTurn;
    private boolean isDisarmed;
    private boolean isStunned;
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
        if (this.isStunned) {
            View.showStunnedCardMessage(this.id);
            return;
        }
        if (this.hasAttackedThisTurn) {
            View.showHasAttackedMessage(this.id);
            return;
        }
        if (cellPlace.getDistance(minion.cellPlace.getX(), minion.cellPlace.getY()) > endRange ||
                cellPlace.getDistance(minion.cellPlace.getX(), minion.cellPlace.getY()) < startRange) {
            View.showOutOfDistanceMessage();
            return;
        }
        minion.changeHp(-this.attackPoint);
        this.lockAttack();
    }

    public void moveTo(Cell cell) {
        if (this.hasMovedThisTurn) {
            View.showCardHasMovedMessage(this.id);
            return;
        }
        if (this.isStunned) {
            View.showStunnedCardMessage(this.id);
            return;
        }
        if (cell.getMinion() != null ||
                cellPlace.getDistance(cell.getX(), cell.getY()) > endRange ||
                cellPlace.getDistance(cell.getX(), cell.getY()) < startRange) {
            View.showInvalidTargetMessage();
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
                        View.showInvalidTargetMessage();
                        return true;
                    }
                }
            }
            if (this.cellPlace.getY() < y) {
                for (int i = y; i < cellPlace.getY(); i--) {
                    if (this.gameBoard.getCell(x, i).getMinion() != null) {
                        View.showInvalidTargetMessage();
                        return true;
                    }
                }
            }
        }
        if (this.cellPlace.getY() == y) {
            if (this.cellPlace.getX() > x) {
                for (int i = x; i < cellPlace.getX(); i++) {
                    if (this.gameBoard.getCell(i, y).getMinion() != null) {
                        View.showInvalidTargetMessage();
                        return true;
                    }
                }
            }
            if (this.cellPlace.getX() < x) {
                for (int i = x; i < cellPlace.getX(); i--) {
                    if (this.gameBoard.getCell(i, y).getMinion() != null) {
                        View.showInvalidTargetMessage();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void insert(Cell cell) {
        if (cell.getMinion() != null) {
            View.showInvalidTargetMessage();
            return;
        }
        cell.setMinion(this);
        this.cellPlace = cell;
        View.showInsertedMinionMessage(this.name, this.id, cell.getX(), cell.getY());
    }

    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder()
                .append("Minion:\n")
                .append("Name: ").append(name).append("\n")
                .append("HP: ").append(healthPoint + " ")
                .append("AP: ").append(attackPoint + " ")
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
                .append("Type : Minion - Name : ").append(this.getName())
                .append(" - Class : ").append(this.getType().toString().toLowerCase())
                .append(" - ID : ").append(this.getId())
                .append(" - AP : ").append(this.getAP())
                .append(" - HP : ").append(this.getHP())
                .append(" - MP : ").append(this.getRequiredManas());
        if (this.getSpecialPower() != null)
                result.append(" -Special power: ").append(this.getSpecialPower().getDesc());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice() {
        return this.infoForDeck().append(" - Sell Cost : ").append(this.getPrice());
    }

    @Override
    public StringBuilder infoForShop(){
        return this.infoForDeck().append(" - Buy Cost : ").append(this.getPrice());
    }

    public ArrayList<Buff> getPositiveBuffs() {
        return positiveBuffs;
    }

    public ArrayList<Buff> getNegativeBuffs() {
        return negativeBuffs;
    }

    public void applyBuff(Buff buff) {
        if (buff.getDelay() == 0) {
            if (buff.isDisarmer()) {
                int numberOfTurnsOfDisarm = buff.getNumberOfTurns();
                this.isDisarmed = true;
                Iterator<Buff> iter = new ArrayList<Buff>().iterator();
                while (iter.hasNext()) {
                    Buff b = iter.next();
                    if (b.isDisarmer()) {
                        if (b.getNumberOfTurns() < numberOfTurnsOfDisarm)
                            negativeBuffs.remove(b);
                        else
                            numberOfTurnsOfDisarm = b.getNumberOfTurns();
                    }
                }
                this.numberOfTurnsOfDisarm = numberOfTurnsOfDisarm;
            }
            if (buff.isStunner()) {
                this.isStunned = true;
                int numberOfTurnsOfStun = buff.getNumberOfTurns();
                Iterator<Buff> iter = new ArrayList<Buff>().iterator();
                while(iter.hasNext()){
                    Buff b = iter.next();
                    if (b.isStunner()){
                        if (b.getNumberOfTurns() < numberOfTurnsOfStun)
                            negativeBuffs.remove(b);
                        else
                            numberOfTurnsOfStun = b.getNumberOfTurns();
                    }
                }
            }
            this.healthPoint += buff.getChangeHp();
            this.attackPoint += buff.getChangeAp();
        }
    }

    public Buff hasDisarmedBefore() {
        for (Buff buff : negativeBuffs) {
            if (buff.isDisarmer()) {
                return buff;
            }
        }
        return null;
    }
}


