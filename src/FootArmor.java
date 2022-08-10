/**
 * Class representing the Foot armor for the Role Playing game
 */

public class FootArmor extends ArmorImpl {

    /**
     * Constructor for a piece of FootArmor.
     *
     * @param armorName  the primary name of the armor piece
     * @param armorAdj the adjective part of the name of the armor piece
     * @param attackStrength   the attack stat of the armor piece
     * @param defenceStrength the defense stat of the armor piece
     */
    public FootArmor(String armorName, String armorAdj, int attackStrength, int defenceStrength) {

        if(armorName == null || armorAdj == null)
        {
            throw new IllegalArgumentException("Armor name and adjective cannot be null");
        }
        if(attackStrength < 0 || defenceStrength < 0)
        {
            throw new IllegalArgumentException("Attack and defence strength cannot be negative");
        }

        this.armorName = armorName;
        this.armorAdj = armorAdj;
        this.armorComboName = armorAdj + " " + armorName;
        this.attackStrength = attackStrength;
        this.defenceStrength = defenceStrength;
        this.armorType = ArmorType.footARMOR;
    }


    @Override
    protected Armor combineArmorParts(String newName, String newAdj, int newAttack, int newDefence, ArmorType armorType) {
        return new FootArmor(newName, newAdj, newAttack, newDefence);
    }
}