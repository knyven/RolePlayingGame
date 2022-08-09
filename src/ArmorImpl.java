abstract class ArmorImpl implements Armor {
    protected String armorName;
    protected String armorAdj;
    protected String armorComboName;
    protected int attackStrength;
    protected int defenceStrength;
    protected ArmorType armorType;


    @Override
    public Armor combineArmor(Armor armor) {
        // if armor passed in is null raise exception
        if (armor == null) {
            throw new IllegalArgumentException("Armor cannot be null");
        }
        // instance of armor class should be the same
        if (!(armor instanceof ArmorImpl)) {
            throw new IllegalArgumentException("Armor must be of type ArmorImpl");
        }
        // if armor passed in is of different type raise exception
        if (armor.getArmorType() != this.armorType) {
            throw new IllegalArgumentException("Armor cannot be of different type");
        }

        String newName = this.armorName;
        String newAdj = this.armorAdj + ", " + armor.getArmorAdj();
        int newAttack = this.attackStrength + armor.getAttackStrength();
        int newDefence = this.defenceStrength + armor.getDefenceStrength();

        return combineArmorParts(newName, newAdj, newAttack, newDefence, this.armorType);

    }
    abstract protected Armor combineArmorParts(String newName, String newAdj, int newAttack, int newDefence, ArmorType armorType);

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
    public ArmorType getArmorType() {
        return this.armorType;
    }

    @Override
    public String toString() {
        return "ArmorImpl{" +
                "armorName='" + armorName + '\'' +
                ", armorAdj='" + armorAdj + '\'' +
                ", armorComboName='" + armorComboName + '\'' +
                ", attackStrength=" + attackStrength +
                ", defenceStrength=" + defenceStrength +
                ", armorType=" + armorType +
                '}';
    }
}