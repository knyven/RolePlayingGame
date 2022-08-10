import static org.junit.Assert.*;

public class PlayerImplTest {

    PlayerImpl player1 = new PlayerImpl("Venya", 10, 10);
    PlayerImpl player2 = new PlayerImpl("Sahil", 10, 10);

    HeadArmor headArmor1 = new HeadArmor("Hat", "Sly", 10, 10);
    HeadArmor headArmor2 = new HeadArmor("HeadArmor2", "HeadArmorAdj2", 10, 10);

    HandArmor handArmor1 = new HandArmor("Sword", "Quick", 10, 10);
    HandArmor handArmor2 = new HandArmor("Shield", "Furious", 10, 10);
    HandArmor handArmor3 = new HandArmor("Gloves", "Temptation", 10, 10);
    HandArmor handArmor4 = new HandArmor("Baton", "Anger", 10, 10);

    FootArmor footArmor1 = new FootArmor("Sneakers", "Lightening", 10, 10);
    FootArmor footArmor2 = new FootArmor("Hoverboard", "Happy", 10, 10);
    FootArmor footArmor3 = new FootArmor("Sandals", "Scurrying", 10, 10);
    FootArmor footArmor4 = new FootArmor("FootArmor4", "FootArmorAdj4", 10, 10);

    @org.junit.Test
    public void getName() {
        assertEquals("Venya", player1.getName());
        assertEquals("Sahil", player2.getName());
    }

    @org.junit.Test
    public void getAttackStrength() {
        assertEquals(10, player1.getAttackStrength());
        assertEquals(10, player2.getAttackStrength());
    }

    @org.junit.Test
    public void getDefenceStrength() {
        assertEquals(10, player1.getDefenceStrength());
        assertEquals(10, player2.getDefenceStrength());
    }



    @org.junit.Test
    public void addArmor() {
        player1.addArmor(headArmor1);
        player1.addArmor(handArmor1);
        player1.addArmor(handArmor2);
        player1.addArmor(footArmor1);
        player1.addArmor(footArmor2);

        player2.addArmor(headArmor2);
        player2.addArmor(handArmor3);
        player2.addArmor(handArmor4);
        player2.addArmor(footArmor3);
        player2.addArmor(footArmor4);

        assertEquals(60, player1.getAttackStrength());
        assertEquals(60, player1.getDefenceStrength());
        System.out.println(player1.toString());

    }

    @org.junit.Test
    public void combiningArmor(){

        player1.addArmor(footArmor1);
        player1.addArmor(footArmor2);
        player1.addArmor(footArmor3);
        assertEquals(
        """ 
        Player: Player1
        Attack Strength: 40
        Defence Strength: 40
        No head armor present!
        Foot Armor: Lightening Sneakers
        Foot Armor: Happy, Scurrying Hoverboard
        """ , player1.toString());
    }


    @org.junit.Test (expected = IllegalArgumentException.class)
    public void combiningArmorException() {


    }




}