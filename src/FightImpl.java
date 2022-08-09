import java.util.ArrayList;

/**
 * Class representing the fight occurring between two players.
 */

public class FightImpl {

    private Player player1;
    private Player player2;
    private ArrayList<Armor> armorList = new ArrayList<>();
    private boolean playerTurn;


    private int armorTotal;

    /**
     * Constructor for a FightImpl.
     *
     * @param player1     the first player object involved in fight
     * @param player2     the 2nd player object involved in fight
     * @param armorList   ArrayList of armor pieces for the two combatants to choose from
     */
    public FightImpl(Player player1, Player player2, ArrayList<Armor> armorList) {

        if (player1.getArmorSize() != 0 || player2.getArmorSize() != 0) {
            throw new IllegalArgumentException("Combatants cannot have starting gears");
        }

        if (armorList.size() != 10) {
            throw new IllegalArgumentException("Total pieces of armor must amount to" + armorTotal);
        }
        this.player1 = player1;
        this.player2 = player2;
        this.armorList = armorList;
        this.playerTurn = true;
        this.armorTotal = 10;
    }

    /**
     * Method for two players to fight.
     *
     *
     */

    public void fight() {
        System.out.println("Fight started!");
        //System.out.println("Player 1: " + player1.getName() + " vs Player 2: " + player2.getName());
        //System.out.println("Player 1: " + player1.getAttackStrength() + " vs Player 2: " + player2.getAttackStrength());


        while (!armorList.isEmpty()) {
            pickUpArmor();
        }


        int player1Damage = player2.getAttackStrength() - player1.getDefenceStrength();
        int player2Damage = player1.getAttackStrength() - player2.getDefenceStrength();

        if (player1Damage < player2Damage) {
            System.out.printf("The winner of the fight is %s with %d damage", player1.getName(), player1Damage);
        } else if (player2Damage < player1Damage) {
            System.out.printf("The winner of the fight is %s with %d damage", player2.getName(), player2Damage);
        } else if (player1Damage == player2Damage) {
            System.out.printf("The battle resulted in a tie! %s and %s both did %d damage!", player1.getName(), player2.getName(), player1Damage);
        }
        return;
    }

    /**
     * Method for head armor piece to be picked.
     *
     */
    private Armor pickHeadArmor() {
        for (Armor head : armorList) {
            if (head.getArmorType() == ArmorType.headARMOR) {
                return head;
            }
        }
        return null;
    }

    /**
     * Method for hand armor piece to be picked.
     *
     */
    private Armor pickHandArmor() {
        for (Armor hand : armorList) {
            if (hand.getArmorType() == ArmorType.handARMOR) {
                return hand;
            }
        }
        return null;
    }
    /**
     * Method for foot armor piece to be picked.
     *
     */
    private Armor pickFootArmor() {
        for (Armor foot : armorList) {
            if (foot.getArmorType() == ArmorType.footARMOR) {
                return foot;
            }
        }
        return null;
    }
    /**
     * Method for highest attack stat armor piece to be picked.
     *
     * @return highestAttackGear
     */
    private Armor getHighestAttackArmor() {
        Armor highestAttackGear = armorList.get(0);
        for (Armor armors : armorList) {
            if (armors.getAttackStrength() == highestAttackGear.getAttackStrength()) {
                return null;
            } else if (armors.getAttackStrength() > highestAttackGear.getAttackStrength()) {
                highestAttackGear = armors;
            }
        }
        return highestAttackGear;
    }

    /**
     * Method for highest defensive armor piece to be picked.
     *
     * @return highestDefenseGear
     */

    private Armor getHighestDefenseArmor() {
        Armor highestDefenseGear = armorList.get(0);
        for (Armor armors : armorList) {
            if (armors.getDefenceStrength() == highestDefenseGear.getDefenceStrength()) {
                return null;
            } else if (armors.getAttackStrength() > highestDefenseGear.getAttackStrength()) {
                highestDefenseGear = armors;
            }
        }
        return highestDefenseGear;
    }
    /**
     * Method for random armor piece to be picked from armorList.
     *
     * @return random armor piece
     */
    private Armor getRandomArmor() {
        int random = (int) (Math.random() * armorTotal) % armorTotal;
        while (random >= armorList.size()) {
            random = (int) (Math.random() * armorTotal) % armorTotal;
        }
        return armorList.get(random);
    }
    /**
     * Method for two combatants to pick pieces of armor turn by turn
     *
     *
     */
    private void pickUpArmor() {
        PlayerImpl current = (PlayerImpl) (playerTurn ? player1 : player2);
        Armor newPiece;
        if (!current.hasHeadArmor() && current.isHandFull() && current.isFootFull() && pickHeadArmor() != null) {
            newPiece = pickHeadArmor();
        } else if (current.hasHeadArmor() && !current.isHandFull() && current.isFootFull() && pickHandArmor() != null) {
            newPiece = pickHandArmor();
        } else if (current.hasHeadArmor() && current.isHandFull() && !current.isFootFull() && pickFootArmor() != null) {
            newPiece = pickFootArmor();
        } else if (getHighestAttackArmor() != null) {
            newPiece = getHighestAttackArmor();
        } else if (getHighestDefenseArmor() != null) {
            newPiece = getHighestDefenseArmor();
        } else {
            newPiece = getRandomArmor();
        }

        current.addArmor(newPiece);
        System.out.printf("This round %s picked up %s, which have/has an attack strength of: %d  and defence strength of: %d\n",
                current.getName(), newPiece.getArmorComboName(),newPiece.getAttackStrength() ,newPiece.getDefenceStrength());
        System.out.printf("Now %s has a total attack power of: %d and total defense power of: %d\n",
                current.getName(), current.getAttackStrength(), current.getDefenceStrength());
        armorList.remove(newPiece);
        playerTurn = !playerTurn;
        return;
    }
}