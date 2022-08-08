import java.util.ArrayList;
import java.util.List

public class FightImpl {

    private Player player1;
    private Player player2;
    private List<Armor> armors = new ArrayList<>();
    private int armorTotal;

    public FightImpl(Player player1, Player player2, List<Armor> armors){

        //if(player1.getSize())

        if (armors.size() != 10){
            throw new IllegalArgumentException("Total pieces of armor must amount to" + armorTotal);

        }


    }
}
