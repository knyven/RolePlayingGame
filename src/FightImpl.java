import java.util.ArrayList;
import java.util.List;

public class FightImpl {

    private Player player1;
    private Player player2;
    private ArrayList<Armor> armorList = new ArrayList<>();
    private boolean playerTurn;


    private int armorTotal;

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
    }

    public void fight() {
        System.out.println("Fight started!");
        System.out.println("Player 1: " + player1.getName() + " vs Player 2: " + player2.getName());
        System.out.println("Player 1: " + player1.getAttackStrength() + " vs Player 2: " + player2.getAttackStrength());

        while (armorList.isEmpty()) {
            pickUpArmor();
        }

        int player1Damage = player2.getAttackStrength() - player1.getDefenceStrength();
        int player2Damage = player1.getAttackStrength() - player2.getDefenceStrength();

        if (player1Damage < player2Damage) {
            System.out.printf("The winner of the fight is %s with %d damage dealt to %s", player1.getName(), player1Damage, player2.getName());
        } else if (player2Damage < player1Damage) {
            System.out.printf("The winner of the fight is %s with %d damage dealt to %s", player2.getName(), player2Damage, player1.getName());
        } else if (player1Damage == player2Damage) {
            System.out.printf("The battle resulted in a tie! %s and %s both did %d damage!", player1.getName(), player2.getName(), player1Damage);
        }
        return;
    }

    private Armor pickHeadGear() {
        for (Armor head : armorList) {
            if (head.getArmorType() == gearType.headGear) {
                return head;
            }
        }
        return null;
    }

    private Armor pickHandGear() {
        for (Armor hand : armorList) {
            if (hand.getArmorType() == gearType.handGear) {
                return hand;
            }
        }
        return null;
    }

    private Armor pickFootGear() {
        for (Armor foot : armorList) {
            if (foot.getArmorType() == gearType.footGear) {
                return foot;
            }
        }
        return null;
    }

    private Armor getHighestAttackGear() {
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

    private Armor getHighestDefenseGear() {
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

    private Armor getRandomGear() {
        int random = (int) Math.random() * armorTotal % armorTotal;
        while (random >= armorList.size()) {
            random = (int) Math.random() * armorTotal % armorTotal;
        }
        return armorList.get(random);
    }

    private void pickUpArmor() {
        PlayerImpl current = (PlayerImpl) (playerTurn ? player1 : player2);
        Armor newPiece;
        if (!current.hasHeadArmor() && current.isHandFull() && current.isFootFull() && pickHeadGear() != null) {
            newPiece = pickHeadGear();
        } else if (current.hasHeadArmor() && !current.isHandFull() && current.isFootFull() && pickHandGear() != null) {
            newPiece = pickHandGear();
        } else if (current.hasHeadArmor() && current.isHandFull() && !current.isFootFull() && pickFootGear() != null) {
            newPiece = pickFootGear();
        } else if (getHighestAttackGear() != null) {
            newPiece = getHighestAttackGear();
        } else if (getHighestDefenseGear() != null) {
            newPiece = getHighestDefenseGear();
        } else {
            newPiece = getRandomGear();
        }

        current.addArmor(newPiece);
        System.out.printf("The current combatant %s got %d attack and %d defense in this turn\n",
                current.getName(), newPiece.getAttackStrength(), current.getDefenceStrength());
        System.out.printf("The current player total attack is %d and total defense is %d",
                current.getAttackStrength(), current.getDefenceStrength());
        armorList.remove(newPiece);
        playerTurn = !playerTurn;
        return;
    }
}