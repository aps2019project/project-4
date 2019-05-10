package model;

import model.buff.Buff;
import resources.Resources;
import views.View;

import java.util.ArrayList;
import java.util.Iterator;

public class Minion extends Card {
    private int healthPoint;
    private int attackPoint;
    private int startRange;
    private int endRange;
    private boolean isAntiHolyBuff;
    private boolean isAntiDisarm;
    private boolean isAntiPoison;
    private boolean isImmortal;
    private boolean isApSuperior;
    private Enums.SoldierType type;
    private boolean hasAttackedThisTurn;
    private boolean hasMovedThisTurn;
    private boolean isDisarmed;
    private boolean isStunned;
    private boolean hasFlag;
    private int numberOfTurnsOfDisarm;
    private int numberOfTurnsOfStun;
    private Cell cellPlace;
    private Spell specialPower;
    private Enums.ActivationTypes specialPowerActivationType;
    private ArrayList<Buff> positiveBuffs = new ArrayList<>();
    private ArrayList<Buff> negativeBuffs = new ArrayList<>();

    public Minion clone() {
        Minion minion = (Minion) Resources.getSpecificCard(this.getName());
        if (minion == null)
            return null;
        minion.setId(this.getId());
        this.negativeBuffs = new ArrayList<>();
        this.positiveBuffs = new ArrayList<>();
        return minion;
    }

    public boolean isHasFlag() {
        return hasFlag;
    }

    public Minion(String id, String name, int price, int mp, int hp, int ap,
                  int startRange, int endRange, boolean isAntiHolyBuff, boolean isAntiDisarm,
                  boolean isAntiPoison, boolean isImmortal, boolean isApSuperior,
                  Enums.ActivationTypes specialPowerActivationType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.healthPoint = hp;
        this.attackPoint = ap;
        this.requiredManas = mp;
        this.startRange = startRange;
        this.endRange = endRange;
        if (startRange == 1 && endRange == 1)
            type = Enums.SoldierType.MELEE;
        if (startRange > 1)
            type = Enums.SoldierType.RANGED;
        if (startRange == 1 && endRange > 1)
            type = Enums.SoldierType.HYBRID;
        this.isAntiHolyBuff = isAntiHolyBuff;
        this.isAntiDisarm = isAntiDisarm;
        this.isAntiPoison = isAntiPoison;
        this.isImmortal = isImmortal;
        this.isApSuperior = isApSuperior;
        this.specialPowerActivationType = specialPowerActivationType;
        this.negativeBuffs = new ArrayList<>();
        this.positiveBuffs = new ArrayList<>();
    }

    public void setSpecialPower(Spell specialPower) {
        this.specialPower = specialPower;
    }

    public Enums.SoldierType getType() {
        return type;
    }

    public Spell getSpecialPower() {
        return specialPower;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public boolean isHasAttackedThisTurn() {
        return hasAttackedThisTurn;
    }

    public boolean isHasMovedThisTurn() {
        return hasMovedThisTurn;
    }

    public boolean getIsDisarmed() {
        return isDisarmed;
    }

    public boolean getIsStunned() {
        return isStunned;
    }

    public int getNumberOfTurnsOfDisarm() {
        return numberOfTurnsOfDisarm;
    }

    public int getNumberOfTurnsOfStun() {
        return numberOfTurnsOfStun;
    }

    public Cell getCellPlace() {
        return cellPlace;
    }

    public void lockMovement() {
        this.hasMovedThisTurn = true;
    }

    public void lockAttack() {
        this.hasAttackedThisTurn = true;
    }

    public void setCellPlace(Cell cellPlace) {
        this.cellPlace = cellPlace;
    }

    public Enums.ActivationTypes getSpecialPowerActivationType() {
        return specialPowerActivationType;
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
        this.hurtMinion(minion);
        this.lockAttack();
        minion.counterAttack(this);
    }

    public void counterAttack(Minion minion) {
        if (!this.isDisarmed || this.isAntiDisarm){
            if (cellPlace.getDistance(minion.cellPlace.getX(), minion.cellPlace.getY()) <= endRange &&
                    cellPlace.getDistance(minion.cellPlace.getX(), minion.cellPlace.getY()) >= startRange){
                hurtMinion(minion);
            }
        }
        else
            System.out.println("Disarmed minion can not do a counter attack");
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
        if (cellPlace.getDistance(cell.getX(), cell.getY()) > endRange ||
                cellPlace.getDistance(cell.getX(), cell.getY()) < startRange) {
            View.showInvalidTargetMessage();
            return;
        }
        this.getCellPlace().setMinion(null);
        this.setCellPlace(cell);
        cell.setMinion(this);
        lockMovement();
        if (cell.getIsFlag()) {
            cell.setFlag(false);
            this.catchFlag();
        }
    }

    public void moveToNoMessageShow(Cell cell) {
        if (this.hasMovedThisTurn) {
            return;
        }
        if (this.isStunned) {
            return;
        }
        if (cellPlace.getDistance(cell.getX(), cell.getY()) > endRange ||
                cellPlace.getDistance(cell.getX(), cell.getY()) < startRange) {
            return;
        }
        if (cell.getIsFlag()) {
            cell.setFlag(false);
            this.catchFlag();
        }
        this.getCellPlace().setMinion(null);
        this.setCellPlace(cell);
        cell.setMinion(this);
    }


    public void changeHp(int number) {
        if (!this.isImmortal)
            this.healthPoint += number;
    }

    public void changeAp(int number) {
        this.attackPoint += number;
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
                .append("ID : ").append(id).append("\n")
                .append("HP: ").append(healthPoint).append(" ")
                .append("AP: ").append(attackPoint + this.lessAttackPoints() + this.moreAttackPoints()).append(" ")
                .append("MP: ").append(requiredManas).append("\n")
                .append("Range: ").append(type).append(" ");
        if (type != Enums.SoldierType.MELEE) {
            result.append(endRange - startRange)
                    .append("\n");
        }
        result.append("Ability: ").append(specialPowerActivationType).append("\n")
                .append("Cost: ").append(price).append("\n")
                .append("Description: ").append(description).append("\n");
        return result;
    }

    @Override
    public StringBuilder infoForDeck() {
        StringBuilder result = new StringBuilder()
                .append("Type : Minion - Name : ").append(this.getName())
                .append(" - Class : ").append(this.getType().toString().toLowerCase())
                .append(" - ID : ").append(this.getId())
                .append(" - AP : ").append(this.getHealthPoint())
                .append(" - HP : ").append(this.getHealthPoint())
                .append(" - MP : ").append(this.getRequiredManas());
        if (this.getSpecialPower() != null)
            result.append(" - Special power: ").append(this.getSpecialPower().getDescription());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice() {
        return this.infoForDeck().append(" - Sell Cost : ").append(this.getPrice());
    }

    @Override
    public StringBuilder infoForShop() {
        return this.infoForDeck().append(" - Buy Cost : ").append(this.getPrice());
    }

    public ArrayList<Buff> getPositiveBuffs() {
        return positiveBuffs;
    }

    public ArrayList<Buff> getNegativeBuffs() {
        return negativeBuffs;
    }

    public void applyBuff(Buff buff) {
        if (buff.getDelay() == 0 && buff.getNumberOfTurns() > 0) {
            if (buff.isDisarmer() && !this.isAntiDisarm) {
                int numberOfTurnsOfDisarm = buff.getNumberOfTurns();
                this.isDisarmed = true;
                Iterator<Buff> iter = negativeBuffs.iterator();
                while (iter.hasNext()) {
                    Buff b = iter.next();
                    if (b.isDisarmer()) {
                        if (b.getNumberOfTurns() < numberOfTurnsOfDisarm)
                            iter.remove();
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
                while (iter.hasNext()) {
                    Buff b = iter.next();
                    if (b.isStunner()) {
                        if (b.getNumberOfTurns() < numberOfTurnsOfStun)
                            iter.remove();
                        else
                            numberOfTurnsOfStun = b.getNumberOfTurns();
                    }
                }
                this.numberOfTurnsOfStun = numberOfTurnsOfStun;
            }
            if (!this.isAntiPoison || !(buff.isPoison()))
                this.changeHp(buff.getChangeHp());
            buff.reduceNumberOfTurns();
        }
    }


    public void catchFlag() {
        this.hasFlag = true;
    }

    public void dropFlag() {
        this.hasFlag = false;
        this.cellPlace.addFlag();
    }

    public void hurtMinion(Minion minion) {
        int finalAttackPoints = this.attackPoint + this.moreAttackPoints() + this.lessAttackPoints();
        if (minion.isApSuperior) {
            if (this.getAttackPoint() > minion.getAttackPoint()) {
                minion.changeHp(-finalAttackPoints + minion.apSheildOfHolyBuffs());
                View.showHurting(minion, finalAttackPoints - minion.apSheildOfHolyBuffs());
                return;
            }
        }
        if (minion.isAntiHolyBuff) {
            minion.changeHp(-finalAttackPoints);
            View.showHurting(minion, finalAttackPoints);
            return;
        }
        if (minion.isAntiPoison) {
            minion.changeHp((-finalAttackPoints - poisonHurts() + minion.apSheildOfHolyBuffs()));
            return;
        }
        minion.changeHp(-finalAttackPoints + minion.holyApShields());
        View.showHurting(minion, finalAttackPoints - minion.apSheildOfHolyBuffs());
    }

    public int poisonHurts() {
        int result = 0;
        for (Buff buff : negativeBuffs) {
            if (buff.isPoison()) {
                result += buff.getChangeAp();
            }
        }
        return result;
    }

    public int holyApShields() {
        int result = 0;
        for (Buff buff : positiveBuffs) {
            result += buff.getApShield();
        }
        return result;
    }

    public int moreAttackPoints() {
        int result = 0;
        for (Buff buff : positiveBuffs)
            result += buff.getChangeAp();
        return result;
    }

    public int lessAttackPoints() {
        int result = 0;
        for (Buff buff : negativeBuffs)
            result += buff.getChangeAp();
        return result;
    }

    public int apSheildOfHolyBuffs() {
        int result = 0;
        for (Buff buff : positiveBuffs)
            result += buff.getApShield();
        for (Buff buff : negativeBuffs)
            result += buff.getApShield();
        return result;
    }

    public void removeAllPositiveBuffs() {
        Iterator<Buff> iterator = positiveBuffs.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public void removeAllNegativeBuffs() {
        Iterator<Buff> iterator = negativeBuffs.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public void nutralizeBuff(boolean isOnEnemy) {
        if (isOnEnemy)
            this.removeAllPositiveBuffs();
        else
            this.removeAllNegativeBuffs();
    }

    public boolean isDead() {
        if (this.getHealthPoint() <= 0)
            return true;
        return false;
    }

    public void removeExpiredBuffs() {
        Iterator<Buff> iterator = negativeBuffs.iterator();
        while (iterator.hasNext()) {
            Buff buff = iterator.next();
            if (buff.getNumberOfTurns() <= 0) {
                iterator.remove();
            }
        }
        iterator = positiveBuffs.iterator();
        while (iterator.hasNext()) {
            Buff buff = iterator.next();
            if (buff.getNumberOfTurns() <= 0) {
                iterator.remove();
            }
        }
    }

    public void unlockMovement() {
        hasMovedThisTurn = false;
    }

    public void unlockAttack() {
        hasAttackedThisTurn = false;
    }

    public void reduceDelays() {
        for (Buff buff : positiveBuffs) {
            buff.reduceDelay();
        }
        for (Buff buff : negativeBuffs) {
            buff.reduceDelay();
        }
    }

    public void reduceNumberOfTurns() {
        if (numberOfTurnsOfStun > 0)
            this.numberOfTurnsOfStun--;
        if (numberOfTurnsOfDisarm > 0)
            this.numberOfTurnsOfDisarm--;
        for (Buff buff : positiveBuffs) {
            buff.reduceNumberOfTurns();
        }
        for (Buff buff : negativeBuffs) {
            buff.reduceNumberOfTurns();
        }
    }
}


