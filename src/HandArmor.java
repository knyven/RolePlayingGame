public class HandArmor extends ArmorImpl {

    public HandArmor(String armorName, String armorAdj, int attackStrength, int defenceStrength, gearType armorType) {
        this.armorName = armorName;
        this.armorAdj = armorAdj;
        this.armorComboName = armorName + " " + armorAdj;
        this.attackStrength = attackStrength;
        this.defenceStrength = defenceStrength;
        this.armorType = armorType;
    }

    @Override
    protected Armor combineArmorParts(String newName, String newAdj, int newAttack, int newDefence, gearType armorType) {
        return new HandArmor(newName, newAdj, newAttack, newDefence, armorType);
    }
}
