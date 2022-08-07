public class FootArmor extends ArmorImpl {

    public FootArmor(String armorName, String armorAdj, int attackStrength, int defenceStrength, gearType armorType) {
        this.armorName = armorName;
        this.armorAdj = armorAdj;
        this.armorComboName = armorName + " " + armorAdj;
        this.attackStrength = attackStrength;
        this.defenceStrength = defenceStrength;
        this.armorType = armorType;
    }
}