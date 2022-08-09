import org.junit.Test;

import java.util.ArrayList;

public class FightImplTest {

    @Test
    public void fightTest() {

        Player player1 = new PlayerImpl("Venya", 10, 10);
        Player player2 = new PlayerImpl("Sahil", 10, 10);
        ArrayList<Armor> armorList = new ArrayList<>();
        armorList.add(new FootArmor("Sneakers", "Lightening", 10, 5));
        armorList.add(new FootArmor("Hoverboard", "Scurrying",35, 2));
        armorList.add(new FootArmor("Sandals", "Sharp", 30, 10));
        armorList.add(new FootArmor("Boots", "Fearful", 40, 0));
        armorList.add(new HandArmor("Sword", "Justice", 40, 10));
        armorList.add(new HandArmor("Shield", "Protection", 0, 75));
        armorList.add(new HandArmor("Gloves", "Righteousness", 0, 50));
        armorList.add(new HandArmor("Blade", "Hateful", 55, 0));

        armorList.add(new HeadArmor("Helmet", "Flurrying", 0, 50));
        armorList.add(new HeadArmor("Hat", "Protection", 0, 50));
        FightImpl fight1 = new FightImpl(player1, player2, armorList);
        fight1.fight();
    }


    @Test
    public void fightTest2() {

        Player player1 = new PlayerImpl("Player1", 10, 10);
        Player player2 = new PlayerImpl("Player2", 10, 10);
        ArrayList<Armor> armorList = new ArrayList<>();
        armorList.add(new FootArmor("Sneakers", "Lightening", 10, 5));
        armorList.add(new FootArmor("Hoverboard", "Scurrying",35, 2));
        armorList.add(new FootArmor("Sandals", "Sharp", 30, 10));
        armorList.add(new FootArmor("Boots", "Fearful", 40, 0));
        armorList.add(new HandArmor("Sword", "Justice", 40, 10));
        armorList.add(new HandArmor("Shield", "Protection", 0, 75));
        armorList.add(new HandArmor("Gloves", "Righteousness", 0, 50));
        armorList.add(new HandArmor("Blade", "Hateful", 55, 0));

        armorList.add(new HeadArmor("Helmet", "Flurrying", 0, 50));
        armorList.add(new HeadArmor("Hat", "Protection", 0, 50));
        FightImpl fight1 = new FightImpl(player1, player2, armorList);
        fight1.fight();

    }


    @Test
    public void fightTest3() {

        Player player1 = new PlayerImpl("Player1", 10, 10);
        Player player2 = new PlayerImpl("Player2", 10, 10);
        ArrayList<Armor> armorList = new ArrayList<>();
        armorList.add(new FootArmor("Sneakers", "Lightening", 10, 5));
        armorList.add(new FootArmor("Hoverboard", "Scurrying",35, 2));
        armorList.add(new FootArmor("Sandals", "Sharp", 30, 10));
        armorList.add(new FootArmor("Boots", "Fearful", 40, 0));
        armorList.add(new HandArmor("Sword", "Justice", 40, 10));
        armorList.add(new HandArmor("Shield", "Protection", 0, 75));
        armorList.add(new HandArmor("Gloves", "Righteousness", 0, 50));
        armorList.add(new HandArmor("Blade", "Hateful", 55, 0));

        armorList.add(new HeadArmor("Helmet", "Flurrying", 0, 50));
        armorList.add(new HeadArmor("Hat", "Protection", 0, 50));
        FightImpl fight1 = new FightImpl(player1, player2, armorList);
        fight1.fight();
    }
}