package twp;

public class Game {
    private LogIn login = new LogIn();
    private DBConnector db = new DBConnector();
    private Timer time = new Timer();
    private long startTime;
    private Player player;
    private Map map;
    private GameUserInterface gui = new GameUserInterface();
    private TextUI ui = new TextUI();
    private Quest quest;
    private Room targetRoom;
    private long timeReward;


    public Game(){
        map = new Map();
        map.buildMap();
        player = new Player();
        Room startRoom = map.getStartRoom();
        Room missionRoom = map.fetchMissionRoom();
        targetRoom = missionRoom;

        time = new Timer();
        player.setCurrentRoom(map.getStartRoom());

    }

    public void startGame(){
        db.connect("jdbc:sqlite:game.sqlite");
        login.login();
        startTime = System.currentTimeMillis(); //test for measuring time
        //login.login();
       //time.showTime(startTime); //test for displaying time in terminal

        boolean runningGame = true;
        gui.printWelcome();

        while(runningGame) {
            String[] commandString = gui.readInput();
            String firstWord = commandString[0];
            String secondWord = "";
            if (commandString.length > 1) {
                secondWord = commandString[1];
            }

            switch (firstWord) {
                case "inv":
                case "invent":
                case "inventory":
                    gui.showInventory(player);
                    break;
                case "kig":
                    gui.describeRoom(player.getCurrentRoom());
                    break;
                case "hjælp":
                case "info":
                    gui.showHelp();
                    break;
                case "quit":
                case "exit":
                case "farvel":
                    runningGame = false;
                    gui.printMessage("Tak for at have spillet!");
                    break;
                case "gå":
                    if(!getCurrentRoom().getIsLocked()){
                        Direction direction = parseCommand(commandString[1]);
                        goCommand(direction);
                        if(!getCurrentRoom().getCreatures().isEmpty()){
                            getCurrentRoom().getCreatures().getFirst().displayCreature();
                            getCurrentRoom().getCreatures().getFirst().displayActionOptions();
                            getCurrentRoom().getCreatures().getFirst().proccessAndRewardAction(this,player);
                            if(player.getHealth()<1){
                                runningGame=false;
                                ui.displayMessage("Du blev ramt af "+getCurrentRoom().getCreatures().getFirst().getCreatureName()+" og led en grusom død");
                                break;
                            }
                        }
                        if(getCurrentRoom().getRiddle() != null){
                            getCurrentRoom().getRiddle().displayRiddle();
                            getCurrentRoom().setRiddleToNull();
                        }
                        if(Riddle.getRiddleSolvedCounter()==7){
                            ui.displayMessage("Du har nu adgang til det sidste rum");
                            map.getFinalLockedRoom().setIsLockedFalse();
                        }
                        if(getCurrentRoom().getName().equals(map.getFinalLockedRoom().getName())&&!map.getFinalLockedRoom().getIsLocked()) {
                            runningGame = false;
                            ui.displayMessage("Du tænder den sidste flamme. Et øjeblik sker der ingenting.\n" +
                                    "Så begynder katedralen at vibrere svagt, som om selve stenene trækker vejret. De seks flammer løfter sig – en efter en – fra deres fade og svæver op mod kuplen højt over dig. Du hører stemmen igen. Ikke én, men mange, hviskende i stjernernes sprog.\n" +
                                    "“Syv flammer. Syv prøver. Én vilje.”\n" +
                                    "Midt i rummet åbner gulvet sig, men ikke med larm – det glider væk som tåge. En trappe i stjernesten viser sig. Du går ned. Under katedralen er der ikke mørke – men lys. Et rum bygget af tid og tanke, hvor stjernekortet over hele universet er ætset i væggene.\n" +
                                    "I midten: En skikkelse. Hætteklædt. Ubevægelig.\n" +
                                    "“Du har bragt os tilbage.”\n" +
                                    "Skikkelsen hæver hovedet. Det er dig selv.\n" +
                                    "Men ældre. Eller yngre. Eller uden alder. En version af dig, du kunne være blevet. Eller måske allerede er.\n" +
                                    "“Vi ventede. Og du tændte lyset igen. Nu kan stierne åbnes – ikke kun i denne katedral, men i hele himlens labyrint.”\n" +
                                    "Du rækker hånden ud. Skikkelsen rører ved dig\n + " +
                                    "Katedralen begynder at løfte sig. Ikke styrte sammen – men stige. Du står i centrum, mens hele rummet bliver til himmel.");
                            time.showTime(startTime - timeReward);
                            db.saveHighscore(login.getName(), time.getSeconds());
                        }

                    }



                    break;
                case "tag":
                    if (player.getItem(secondWord)) {
                        gui.printMessage("Du har taget " + secondWord);
                    } else {
                        gui.printMessage("Du kan ikke samle " + secondWord + " op");
                    }
                    break;
                case "use":
                    player.useItem();
                    break;
                default:
                    gui.printMessage("Jeg forstår ikke kommandoen");


            }

        }
    }

    public void goCommand(Direction direction){
        if(goDirection (direction)){
            Room currentRoom = getCurrentRoom();
            String name = currentRoom.getName();
            String line = "-".repeat(name.length());
            System.out.println(line + "\n" + name + "\n" + line);
            System.out.println(currentRoom.getDescription());
        }
        else {
            System.out.println("Du kan ikke gå den vej");
        }
        try {
            if(!quest.getIsQuestCompleted()&&quest != null) {
                timeReward = quest.checkCompletion(player, targetRoom);

            }
        } catch (NullPointerException _){
        }


    }

    private Direction parseCommand(String word) {
        Direction requestedDirection = null;
        switch(word){
            case "f", "fremad":
                requestedDirection = Direction.Forward;
                break;
            case "b", "baglæns":
                requestedDirection = Direction.Backwards;
                break;
            case "o", "op":
                requestedDirection = Direction.UP;
                break;
            case "n", "ned":
                requestedDirection = Direction.DOWN;
                break;
            default:
                word = ui.promptText("Ugyldigt input prøv igen: ");
                return parseCommand(word);
        }
        return requestedDirection;
    }

    public boolean goDirection(Direction direction){
        return player.move(direction);
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }
    public Player getPlayer() {
        return player;
    }
    public void setCurrentQuest(Quest quest){
        this.quest = quest;
    }
    public String getCurrentQuestNameAndDescription(){
        return quest.getQuestNameAndDescription();
    }


}
