package one;

import java.util.ArrayList;
import java.util.Scanner;

public class Hostile implements Creature {
    String creatureName;
    String creatureDescription;
    int creatureDamage = 1;
    Game g = new Game();
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
        return getCreatureDescription();
    }

    @Override
    public void displayActionOptions() {
        ArrayList<String> options = getActionOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Override
    public void proccessAndRewardAction() {
        System.out.print("tryk 1 for offesiv/deffensiv handling eller 2 for venlig handling");
        int option = scanner.nextInt();
        switch (option) {
            case 1: //offensiv-deffensiv option
                //remove creature from roomList
                g.getCurrentRoom().getCreatures().remove(0);
                System.out.println(creatureName + " er forsvundet fra rummet..");
                break;
            case 2: //venligsindet option
                //playerHealth -1;
                player.decreaseHealth(1);
                System.out.println("du mistede et liv");
                break;
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

