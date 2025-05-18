package one;

public class Game {
    LogIn login = new LogIn();
    DBConnector db = new DBConnector();
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
        quest = new Quest("Nå til rummet","Gå til det korrekte rum på anden sal, for at gennemføre quest'en");
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
                    time.showTime(startTime - timeReward);
                    db.saveHighscore(login.getName(),time.getSeconds());
                    break;
                case "gå":
                    Direction direction = parseCommand(commandString[1]);
                    goCommand(direction);
                    break;
                case "tag":
                    if (player.getItem(secondWord)) {
                        gui.printMessage("Du har taget " + secondWord);
                    } else {
                        gui.printMessage("There is nothing like " + secondWord + " to take around here.");
                    }
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
        timeReward = quest.checkCompletion(player,targetRoom);


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

}
