package twp;

public class Quest {
    private String questName;
    private String questDescription;
    protected boolean isQuestCompleted;
    public Quest(String name, String description){
        questName = name;
        questDescription = description;
        isQuestCompleted = false;
    }
   public long checkCompletion(Player player, Room targetRoom){
        if(player.getCurrentRoom()== targetRoom){
            isQuestCompleted = true;
            System.out.println("Quest'en er færdig: " + questName);
            return -5000;

        }else {
            System.out.println("Quest'en er ikke klaret, forsæt din søgning!");
            return 0;
        }
   }

}
