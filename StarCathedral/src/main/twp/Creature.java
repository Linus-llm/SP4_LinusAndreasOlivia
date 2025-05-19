package twp;

public interface Creature {

    void monsterReward();

    boolean ifPlayerFriendly();

    boolean ifPlayerHostile();

    public String displayCreature();

    public String getCreatureName();

    public void displayActionOptions();

    public void proccessAndRewardAction(Game g,Player player);
}