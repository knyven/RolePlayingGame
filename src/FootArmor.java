public class FootArmor extends ArmorImpl {

    public FootArmor(String armorName, String armorAdj, int attackStrength, int defenceStrength, gearType armorType) {

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
        this.armorType = armorType;
    }


    @Override
    protected Armor combineArmorParts(String newName, String newAdj, int newAttack, int newDefence, gearType armorType) {
        return new FootArmor(newName, newAdj, newAttack, newDefence, armorType);
    }
}