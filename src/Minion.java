import java.util.ArrayList;

public class Minion extends Card {
    private int healthPoint;
    private int attackPoint;
    private int startRange;
    private int endRange;
    private boolean hasAttackedThisTurn;
    private boolean hasMovedThisTurn;
    private boolean isDisarmed;
    private boolean isStuned;
    private boolean numberOfTurnsOfDisarm;
    private GameBoard gameBoard;
    private Cell cellPlace;
    private Spell specialPower;
    private Enums.ActivationTypes specialPowerActivationType;
    private ArrayList<Buff> positiveBuffs;
    private ArrayList<Buff> negativeBuffs;

    public Minion(String name, int price, int hp, int ap, int mp, int startRange, int endRange) {
        this.name = name;
        this.price = price;
        this.healthPoint = hp;
        this.attackPoint = ap;
        this.requiredManas = mp;
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public int getHP() {
        return healthPoint;
    }

    public int getAP() {
        return attackPoint;
    }

    public void lockMovement() {
        this.hasMovedThisTurn = true;
    }

    public void lockAttack() {
        this.hasAttackedThisTurn = true;
    }

    public void attack(Minion minion) {
        if (this.isStuned == true || this.hasAttackedThisTurn) {
            System.out.printf("Card with id: %s can't attack\n", this.id);
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

    public void moveTo(int x, int y) {
        Cell cell = gameBoard.getCell(x, y);
        if (this.hasMovedThisTurn) {
            System.out.printf("This card with id: %s has moved this turn\n", this.id);
            return;
        }
        if (this.isStuned) {
            System.out.printf("This card with id: %s is stuned\n", this.id);
            return;
        }
        if (cell.getMinion() != null ||
                cellPlace.getDistance(this.cellPlace.getX(), this.cellPlace.getY()) > endRange ||
                cellPlace.getDistance(this.cellPlace.getX(), this.cellPlace.getY()) < startRange) {
            System.out.println("Invalid target");
            return;
        }
        if (!this.isMinionsBetween(x, y)) {
            this.cellPlace.setMinion(null);
            this.cellPlace = cell;
            this.lockMovement();
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

    //todo write toString
}
