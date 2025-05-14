package main.java.org.oliviasFX;

import main.java.org.oliviasFX.*;

public class Game {
    LogIn login = new LogIn();
    DBConnector db = new DBConnector();
    Timer time = new Timer();
    long startTime;
    private Player player;
    private Map map;
    private GameUserInterface gui = new GameUserInterface();

    public Game(){
        map = new Map();
        map.buildMap();
        player = new Player();
        player.setCurrentRoom(map.getStartRoom());
    }

    public void startGame(){
        db.connect("jdbc:sqlite:game.sqlite");
        login.login();
        startTime = System.currentTimeMillis(); //test for measuring time
        login.login();
        time.showTime(startTime); //test for displaying time in terminal

        boolean runningGame = true;
        gui.printWelcome();

        while(runningGame) {
            String[] commandString = ui.readInput();
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
                    break;
                case "go":
                    Direction direction = parseCommand(commandString[1]);
                    goCommand(direction);
                    break;
                case "take":
                    if (player.getItem(secondWord)) {
                        ui.printMessage("You have taken the " + secondWord);
                    } else {
                        ui.printMessage("There is nothing like " + secondWord + " to take around here.");
                    }
                    break;
                default:
                    ui.printMessage("I do not understand that command.");
            }
        }
    }

    public void goCommand(){
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
    }

    private Direction parseCommand(String word) {
        Direction requestedDirection = null;

        switch(word){
            case "f":
                requestedDirection = Direction.Forward;
                break;
            case "b":
                requestedDirection = Direction.Backwards;
                break;
            case "u":
                requestedDirection = Direction.UP;
                break;
            case "d":
                requestedDirection = Direction.DOWN;
                break;
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
