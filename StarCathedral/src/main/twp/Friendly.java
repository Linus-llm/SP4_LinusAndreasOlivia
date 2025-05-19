package twp;

import java.util.ArrayList;
import java.util.Scanner;

public class Friendly implements Creature {
    String creatureName;
    String creatureDescription;
    String creatureMsg;
    int creatureHealth = 1;

    ArrayList<String> actionOptions;

    Scanner scanner = new Scanner(System.in);

    public Friendly(String creatureName, String creatureDescription, ArrayList<String>actionOptions, int creatureHealth){
        this.creatureName = creatureName;
        this.creatureDescription = creatureDescription;
        this.actionOptions = actionOptions;
        this.creatureHealth = creatureHealth;
    }

    @Override
    public void monsterReward() {}

    @Override
    public boolean ifPlayerFriendly() { return true; }

    @Override
    public boolean ifPlayerHostile() { return false; }

    @Override
    public String displayCreature(){
        return getCreatureDescription();
    }

    @Override
    public void displayActionOptions(){
        ArrayList<String> options = getActionOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Override
    public void proccessAndRewardAction(Game g, Player player) {
        System.out.print("tryk 1 for offensiv/defensiv handling eller 2 for venlig handling\n");
        int option = scanner.nextInt();
        switch (option) {
            case 1: //offensiv-deffensiv option
                //tilfoej daarlig karma
                ////remove creature from roomList
                g.getCurrentRoom().getCreatures().remove(0);
                System.out.println(creatureName + " er forsvundet fra rummet..");
                break;
            case 2: //venligsindet option
                // tilfoej god karma
                //evt tilfoej item?
                System.out.println(creatureName + " giver dig et venligt blik og giver dig en quest...");

                    g.setCurrentQuest(new Quest("Nå til rummet", "Gå til det korrekte rum på anden sal, for at gennemføre quest'en"));
                    System.out.println(g.getCurrentQuestNameAndDescription());
                    break;
                }
        }

    public String getCreatureName(){
        return creatureName;
    }

    public String getCreatureDescription(){
        return creatureDescription;
    }
    public ArrayList getActionOptions(){
        return actionOptions;
    }

    public int getCreatureHealth(){
        return creatureHealth;
    }
}
