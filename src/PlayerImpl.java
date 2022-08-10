import java.util.ArrayList;
/**
 * Class representing the players in the game.
 */
public class PlayerImpl implements Player{

    private String name;
    private final int attackStrength;
    private final int defenceStrength;
    private Armor headArmor;
    private final ArrayList<Armor> handArmor;
    private final ArrayList<Armor> footArmor;

    private static final int MAX_HAND_ARMOR = 2;
    private static final int MAX_FOOT_ARMOR = 1;


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
        int totalAttack = this.attackStrength;
        if (this.headArmor != null) {
            totalAttack += this.headArmor.getAttackStrength();
        }

        for (Armor armor : this.handArmor) {
            totalAttack += armor.getAttackStrength();
        }
        for (Armor armor : this.footArmor) {
            totalAttack += armor.getAttackStrength();
        }
        return totalAttack;
    }

    @Override
    public int getDefenceStrength() {
        int totalDefence = this.defenceStrength;
        if (this.headArmor != null) {
            totalDefence += this.headArmor.getAttackStrength();
        }
        for (Armor armor : this.handArmor) {
           totalDefence += armor.getDefenceStrength();
        }
        for (Armor armor : this.footArmor) {
            totalDefence += armor.getDefenceStrength();
        }
        return totalDefence;
    }

    @Override
    public void addArmor(Armor armor) {
        // if no armor is passed in raise exception
        if(armor == null)
        {
            throw new IllegalArgumentException("Armor cannot be null");
        }
        // if armor is headgear check is player has headgear
        if (armor.getArmorType() == ArmorType.headARMOR)
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
        else if (armor.getArmorType() == ArmorType.handARMOR)
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
        else if (armor.getArmorType() == ArmorType.footARMOR)
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
        return this.handArmor.size() == MAX_HAND_ARMOR;
    }

    public boolean isFootFull() {
        return this.footArmor.size() == MAX_FOOT_ARMOR;
    }

    public int getArmorSize(){
        return headArmor == null? handArmor.size() + footArmor.size() : handArmor.size() + footArmor.size() + 1;
    }

    @Override
    public String toString() {


        StringBuilder returnString = new StringBuilder();

        returnString.append("Player: " + this.name + "\n");
        returnString.append("Attack Strength: " + this.getAttackStrength() + "\n");
        returnString.append("Defence Strength: " + this.getDefenceStrength() + "\n");
        if(this.headArmor == null)
        {
            returnString.append("No head armor present!" + "\n");
        }
        else if(this.headArmor != null)
        {
            returnString.append("Head armor: " + this.headArmor.getArmorComboName() + "\n");
        }


        for(Armor armor : this.handArmor)
        {
            returnString.append("Hand Armor: " + armor.getArmorComboName() + "\n");
        }
        for(Armor armor : this.footArmor)
        {
            returnString.append("Foot Armor: " + armor.getArmorComboName() + "\n");
        }
        return returnString.toString();
    }
}
