public class HandArmor extends ArmorImpl {

    public HandArmor(String armorName, String armorAdj, int attackStrength, int defenceStrength) {
        this.armorName = armorName;
        this.armorAdj = armorAdj;
        this.armorComboName = armorAdj + " " + armorName;
        this.attackStrength = attackStrength;
        this.defenceStrength = defenceStrength;
        this.armorType = ArmorType.handARMOR;
    }

    @Override
    protected Armor combineArmorParts(String newName, String newAdj, int newAttack, int newDefence, ArmorType armorType) {
        return new HandArmor(newName, newAdj, newAttack, newDefence);
    }
}
