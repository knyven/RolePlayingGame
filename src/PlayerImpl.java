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
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (attackStrength < 0 || defenceStrength < 0) {
            throw new IllegalArgumentException("Attack strength or defence strength " +
                    "cannot be negative");
        }
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

    @Override
    public void addArmor(Armor armor) {
        // if no armor is passed in raise exception
        if(armor == null)
        {
            throw new IllegalArgumentException("Armor cannot be null");
        }
        // if armor is headgear check is player has headgear
        if (armor.getArmorType() == gearType.headGear)
        {
            // if player has headgear combine the pieces
            if(hasHeadArmor())
            {
                Armor newHeadArmor = this.headArmor.combineArmor(armor);
                this.headArmor = newHeadArmor;
            }
            else
            {
                this.headArmor = armor;
            }
        }
        else if (armor.getArmorType() == gearType.handGear)
        {
            if(isHandFull())
            {
                Armor newHandArmor = this.handArmor.get(1).combineArmor(armor);
                this.handArmor.set(1, newHandArmor);
            }
            else
            {
               this.handArmor.add(armor);
            }
        }
        else if (armor.getArmorType() == gearType.footGear)
        {
           if(isFootFull())
           {
               Armor newFootArmor = this.footArmor.get(1).combineArmor(armor);
               this.footArmor.set(1, newFootArmor);
           }
           else
           {
               this.footArmor.add(armor);
           }
        }
    }

    public boolean hasHeadArmor() {
        return this.headArmor != null;
    }

    public boolean isHandFull() {
        return this.handArmor.size() == 2;
    }

    public boolean isFootFull() {
        return this.footArmor.size() == 2;
    }


}
