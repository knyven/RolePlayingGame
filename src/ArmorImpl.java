public abstract class ArmorImpl implements Armor{
    protected String armorName;
    protected String armorAdj;
    protected String armorComboName;
    protected int attackStrength;
    protected int defenceStrength;
    protected gearType armorType;



    @Override
    public String getArmorName() {
        return null;
    }

    @Override
    public String getArmorAdj() {
        return null;
    }

    @Override
    public String getArmorComboName() {
        return null;
    }

    @Override
    public int getAttackStrength() {
        return 0;
    }

    @Override
    public int getDefenceStrength() {
        return 0;
    }

    @Override
    public gearType getArmorType() {
        return null;
    }

    @Override
    public Armor combineArmor(Armor armor) {
        return null;
    }
}
