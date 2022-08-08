import java.util.ArrayList;
import java.util.List;

public class FightImpl {

    private Player player1;
    private Player player2;
    private ArrayList<Armor> armorList = new ArrayList<>();
    private boolean playerTurn;


    private int armorTotal;

    public FightImpl(Player player1, Player player2, ArrayList<Armor> armorList){

        if(player1.getArmorSize() != 0 || player2.getArmorSize() != 0 ){
            throw new IllegalArgumentException("Combatants cannot have starting gears")
        }

        if (armorList.size() != 10){
            throw new IllegalArgumentException("Total pieces of armor must amount to" + armorTotal);
        }
        this.player1 = player1;
        this.player2 = player2;
        this.armorList = armorList;
        this.playerTurn = true;
    }

    public void fight()
    {
        System.out.println("Fight started!");
        System.out.println("Player 1: " + player1.getName() + " vs Player 2: " + player2.getName());
        System.out.println("Player 1: " + player1.getAttackStrength() + " vs Player 2: " + player2.getAttackStrength());

        while(armorList.isEmpty()){
            pickUpArmor();
        }
    }

    private void pickUpArmor() {
    }


}
