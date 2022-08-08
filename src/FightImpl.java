import java.util.ArrayList;
import java.util.List;

public class FightImpl {

    private Player player1;
    private Player player2;
    private List<Armor> armors = new ArrayList<>();
    private int armorTotal;

    public FightImpl(Player player1, Player player2, List<Armor> armors){

        if(player1.getArmorSize() != 0 || player2.getArmorSize() != 0 ){
            throw new IllegalArgumentException("Combatants cannot have starting gears")
        }

        if (armors.size() != 10){
            throw new IllegalArgumentException("Total pieces of armor must amount to" + armorTotal);
        }
        this.player1 = player1;
        this.player2 = player2;
        this.armors = armors;
        this.armorTotal = 10;
    }
}
