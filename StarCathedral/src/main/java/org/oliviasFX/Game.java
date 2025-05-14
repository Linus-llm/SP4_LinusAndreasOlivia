package org.oliviasFX;

public class Game {
    LogIn login = new LogIn();
    DBConnector db = new DBConnector();

    public void startGame(){
        login.login();
        db.connect("jdbc:sqlite:game.sqlite");
    }

    public boolean goDirection(Direction direction){
        return.player.move(direction);
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

}
