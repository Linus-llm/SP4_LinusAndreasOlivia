package one;

import java.util.ArrayList;
import java.util.Scanner;

public class Hostile implements Creature {
    String creatureName;
    String creatureDescription;
    int creatureDamage = 1;
    int creatureHealth = 1;
    String creatureMsg;

    ArrayList<String> actionOptions;

    Scanner scanner = new Scanner(System.in);

    public Hostile(String creatureName, String creatureDescription, ArrayList<String>actionOptions, int creatureHealth){
        this.creatureName = creatureName;
        this.creatureDescription = creatureDescription;
        this.actionOptions = actionOptions;
        this.creatureHealth = creatureHealth;
    }


@Override
public void monsterReward() {}

@Override
public boolean ifPlayerFriendly() { return false; }

@Override
public boolean ifPlayerHostile() { return true; }

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
            //CreatureHealth = -1;
            //remove creature from roomList
            break;
        case 2: //venligsindet option
            //playerHealth -1;
            player.setHealth(-1);
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

