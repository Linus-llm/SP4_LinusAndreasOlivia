package org.oliviasFX;

public class Game {
    LogIn login = new LogIn();
    DBConnector db = new DBConnector();

    public void startGame(){
        db.connect("jdbc:sqlite:game.sqlite");
        login.login();

    }
}
