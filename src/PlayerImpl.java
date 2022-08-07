import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player{

    private String name;
    private int attackStrength;
    private int defenceStrength;
    private Armor headArmor;
    private ArrayList<Armor> handArmor;
    private ArrayList<Armor> footArmor;


    // initialize player to have a name and no gear and no attack or defence strength
    public PlayerImpl(String name, int attackStrength, int defenceStrength) {
        this.name = name;
        this.attackStrength = attackStrength;
        this.defenceStrength = defenceStrength;
        this.headArmor = null;
        this.handArmor = new ArrayList<>();
        this.footArmor = new ArrayList<>();
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAttackStrength() {
        this.attackStrength = this.attackStrength + this.headArmor.getAttackStrength();

        for (Armor armor : this.handArmor) {
            this.attackStrength += armor.getAttackStrength();
        }
        for (Armor armor : this.footArmor) {
            this.attackStrength += armor.getAttackStrength();
        }
        return this.attackStrength;
    }

    @Override
    public int getDefenceStrength() {
        this.defenceStrength = this.defenceStrength + this.headArmor.getDefenceStrength();

        for (Armor armor : this.handArmor) {
            this.defenceStrength += armor.getDefenceStrength();
        }
        for (Armor armor : this.footArmor) {
            this.defenceStrength += armor.getDefenceStrength();
        }
        return this.defenceStrength;
    }


}
