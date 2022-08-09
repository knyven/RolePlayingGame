public interface Player {
    String getName(); //name of the player
    int getAttackStrength(); //starting attack strength of player
    int getDefenceStrength(); //starting defense strength of player

    void addArmor(Armor armor); //adding armor pieces stats to player each time a piece is added


    int getArmorSize();
}
