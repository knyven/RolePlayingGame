public interface Armor {
    // getters for getting gear name, adj and armor combo name
    String getArmorName();
    String getArmorAdj();
    String getArmorComboName();

    // getters for getting defense value and attack value
    int getAttackStrength();
    int getDefenceStrength();

    // getter for getting armor type
    gearType getArmorType();

    // main function to combine armor in either hand or foot armor into combo armor
    Armor combineArmor(Armor armor);

}
