package org.oliviasFX;

public class Game {
    LogIn login = new LogIn();
    DBConnector db = new DBConnector();
    Timer time = new Timer();
    long startTime;
    public void startGame(){
        db.connect("jdbc:sqlite:game.sqlite");
        login.login();
        startTime = System.currentTimeMillis(); //test for measuring time
        login.login();
        time.showTime(startTime); //test for displaying time in terminal
    }

    public boolean goDirection(Direction direction){
        return.player.move(direction);
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

}
