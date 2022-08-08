import static org.junit.Assert.*;

public class PlayerImplTest {

    PlayerImpl player1 = new PlayerImpl("Player1", 10, 10);
    PlayerImpl player2 = new PlayerImpl("Player2", 10, 10);

    HeadArmor headArmor1 = new HeadArmor("HeadArmor", "HeadArmorAdj", 10, 10, gearType.headGear);
    HeadArmor headArmor2 = new HeadArmor("HeadArmor2", "HeadArmorAdj2", 10, 10, gearType.headGear);

    HandArmor handArmor1 = new HandArmor("HandArmor1", "HandArmorAdj1", 10, 10, gearType.handGear);
    HandArmor handArmor2 = new HandArmor("HandArmor2", "HandArmorAdj2", 10, 10, gearType.handGear);
    HandArmor handArmor3 = new HandArmor("HandArmor3", "HandArmorAdj3", 10, 10, gearType.handGear);
    HandArmor handArmor4 = new HandArmor("HandArmor4", "HandArmorAdj4", 10, 10, gearType.handGear);

    FootArmor footArmor1 = new FootArmor("Sneakers", "Lightening", 10, 10, gearType.footGear);
    FootArmor footArmor2 = new FootArmor("Hoverboard", "Happy", 10, 10, gearType.footGear);
    FootArmor footArmor3 = new FootArmor("Sandals", "Scurrying", 10, 10, gearType.footGear);
    FootArmor footArmor4 = new FootArmor("FootArmor4", "FootArmorAdj4", 10, 10, gearType.footGear);

    @org.junit.Test
    public void getName() {
        assertEquals("Player1", player1.getName());
        assertEquals("Player2", player2.getName());
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
        System.out.println(player1.toString());
        player1.addArmor(footArmor3);
        System.out.println(player1.toString());
    }
}