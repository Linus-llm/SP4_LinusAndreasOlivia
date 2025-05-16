package one;

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
    public void displayCreature(){
        System.out.println(getCreatureDescription());
    }

    @Override
    public void displayActionOptions(){
        ArrayList<String> options = getActionOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Override
    public void proccessAndRewardAction(){

        int option = scanner.nextInt();
        switch(option){
            case 1: //offensiv-deffensiv option
                //tilfoej daarlig karma
                ////remove creature from roomList
                break;
            case 2: //venligsindet option
                // tilfoej god karma
                //evt tilfoej item?
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
