public abstract class ArmorImpl implements Armor{
    protected String armorName;
    protected String armorAdj;
    protected String armorComboName;
    protected int attackStrength;
    protected int defenceStrength;
    protected gearType armorType;



    @Override
    public String getArmorName() {
        return this.armorName;
    }

    @Override
    public String getArmorAdj() {
        return this.armorAdj;
    }

    @Override
    public String getArmorComboName() {
        return this.armorComboName;
    }

    @Override
    public int getAttackStrength() {
        return this.attackStrength;
    }

    @Override
    public int getDefenceStrength() {
        return this.defenceStrength;
    }

    @Override
    public gearType getArmorType() {
        return this.armorType;
    }

    @Override
    public Armor combineArmor(Armor armor) {
        return null;
    }
}
