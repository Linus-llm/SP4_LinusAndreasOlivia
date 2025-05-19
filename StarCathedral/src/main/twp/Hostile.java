package twp;

import java.util.ArrayList;
import java.util.Scanner;

public class Hostile implements Creature {
    String creatureName;
    String creatureDescription;
    int creatureDamage = 1;
    int creatureHealth = 1;
    String creatureMsg;
    Player player = new Player();

    ArrayList<String> actionOptions;

    Scanner scanner = new Scanner(System.in);

    public Hostile(String creatureName, String creatureDescription, ArrayList<String> actionOptions, int creatureHealth) {
        this.creatureName = creatureName;
        this.creatureDescription = creatureDescription;
        this.actionOptions = actionOptions;
        this.creatureHealth = creatureHealth;
    }


    @Override
    public void monsterReward() {
    }

    @Override
    public boolean ifPlayerFriendly() {
        return false;
    }

    @Override
    public boolean ifPlayerHostile() {
        return true;
    }

    @Override
    public String displayCreature() {
        return getCreatureDescription() + " og det/de hedder " + getCreatureName();
    }

    @Override
    public void displayActionOptions() {
        ArrayList<String> options = getActionOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Override
    public void proccessAndRewardAction(Game g, Player player) {
        while (true) {
            System.out.print("Tryk 1 for offensiv/deffensiv handling eller 2 for venlig handling: ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                g.getCurrentRoom().getCreatures().remove(0);
                System.out.println(creatureName + " er forsvundet fra rummet..");
                break;
            } else if (input.equals("2")) {
                player.decreaseHealth(1);
                System.out.println("Du mistede et liv");
                break;
            } else {
                System.out.println("Ugyldigt valg. Skriv venligst 1 eller 2.");
            }
        }
    }


    public String getCreatureName() {
        return creatureName;
    }

    public String getCreatureDescription() {
        return creatureDescription;
    }

    public ArrayList getActionOptions() {
        return actionOptions;
    }

    public int getCreatureHealth() {
        return creatureHealth;
    }
}

