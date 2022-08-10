/**
 * Class representing the Foot armor for the Role Playing game
 */


public class HeadArmor extends ArmorImpl {

    /**
     * Constructor for a piece of HeadArmor.
     *
     * @param armorName  the primary name of the armor piece
     * @param armorAdj the adjective part of the name of the armor piece
     * @param attackStrength   the attack stat of the armor piece
     * @param defenceStrength the defense stat of the armor piece
     */
    public HeadArmor(String armorName, String armorAdj, int attackStrength, int defenceStrength) {
        this.armorName = armorName;
        this.armorAdj = armorAdj;
        this.armorComboName = armorAdj + " " + armorName;
        this.attackStrength = attackStrength;
        this.defenceStrength = defenceStrength;
        this.armorType = ArmorType.headARMOR;
    }

    @Override
    protected Armor combineArmorParts(String newName, String newAdj, int newAttack, int newDefence, ArmorType armorType) {
        return new HeadArmor(newName, newAdj, newAttack, newDefence);
    }
}