package org.oliviasFX;

public class Game {
    LogIn login = new LogIn();
    DBConnector db = new DBConnector();
    Timer time = new Timer();
    long startTime;
    private Player player;

    public void startGame(){
        db.connect("jdbc:sqlite:game.sqlite");
        login.login();
        startTime = System.currentTimeMillis(); //test for measuring time
        login.login();
        time.showTime(startTime); //test for displaying time in terminal
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

    public boolean goDirection(Direction direction){
        return player.move(direction);
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

}
