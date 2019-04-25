import java.util.ArrayList;

public class Minion extends Card {
    private int healthPoint;
    private int attackPoint;
    private int startRange;
    private int endRange;
    private boolean hasAttackedThisTurn;
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

    public void attack(Minion minion) {
        if (this.isStuned == true || this.hasAttackedThisTurn) {
            System.out.printf("Card with id: %s can't attack", this.id);
            return;
        }
        if (cellPlace.getDistance(minion.cellPlace.getX(), minion.cellPlace.getY()) > endRange ||
                cellPlace.getDistance(minion.cellPlace.getX(), minion.cellPlace.getY()) < startRange) {
            System.out.println("Opponent minion is unavailable for attack");
            return;
        }
        minion.changeHp(-this.attackPoint);
    }
    public void moveTo(int x, int y)
    {
        Cell cell = gameBoard.getCell(x, y);
        if (cell.getMinion() != null ||
                cellPlace.getDistance(this.cellPlace.getX(), this.cellPlace.getY()) > endRange ||
                cellPlace.getDistance(this.cellPlace.getX(), this.cellPlace.getY()) < startRange){
            System.out.println("Invalid target");
            return;
        }
        if (x == this.cellPlace.getX()){

        }
    }
    public void changeHp(int number) {
        this.healthPoint += number;
    }

    public void changeAp(int number) {
        this.attackPoint += number;
    }
    public boolean checkMinionsBetween(int x, int y){
        if (this.cellPlace.getY() > y){
            for (int i = y+1; i<= cellPlace.getY(); i++){
                if (gameBoard.getCell(x, i).getMinion() != null){
                    System.out.println("Invalid target");
                    return true;
                }
            }
        }
        return false;
    }
}
