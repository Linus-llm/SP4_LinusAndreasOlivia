package one;

public interface Creature {

    void monsterReward();

    boolean ifPlayerFriendly();

    boolean ifPlayerHostile();

    public String displayCreature();

    public void displayActionOptions();

    public void proccessAndRewardAction();
}