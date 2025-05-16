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
                case "look":
                    gui.describeRoom(player.getCurrentRoom());
                    break;
                case "help":
                case "info":
                    gui.showHelp();
                    break;
                case "quit":
                case "exit":
                case "bye":
                    runningGame = false;
                    gui.printMessage("Thank you for playing Adventure");
                    time.showTime(startTime - timeReward);
                    db.saveHighscore(login.getName(),time.getSeconds());
                    break;
                case "go":
                    Direction direction = parseCommand(commandString[1]);
                    goCommand(direction);
                    break;
                case "take":
                    if (player.getItem(secondWord)) {
                        gui.printMessage("You have taken the " + secondWord);
                    } else {
                        gui.printMessage("There is nothing like " + secondWord + " to take around here.");
                    }
                    break;
                default:
                    gui.printMessage("I do not understand that command");

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
            System.out.println("You cannot go in that direction");
        }
        timeReward = quest.check

    Completion(player, targetRoom);
    }

    private Direction parseCommand(String word) {
        Direction requestedDirection = null;

        switch(word){
            case "f", "forward", "forwards":
                requestedDirection = Direction.Forward;
                break;
            case "b", "backwards":
                requestedDirection = Direction.Backwards;
                break;
            case "u", "up":
                requestedDirection = Direction.UP;
                break;
            case "d", "down":
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
