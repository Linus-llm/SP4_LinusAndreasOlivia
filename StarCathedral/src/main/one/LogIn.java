package one;

public class LogIn {
    private TextUI ui = new TextUI();
    private DBConnector db = new DBConnector();
    private String username;
    private String password;
    protected void login(){
        ui.displayMessage("Hej og velkommen til Stjernepræsternes stjernekatedral!");
        int userChoice = ui.promptNumeric("1. Login\n2. Opret konto");
        switch (userChoice) {
            case 1:
                username = ui.promptText("Indtast Brugernavn: ");
                password = ui.promptText("Indtast Kodeord: ");
                db.connect("jdbc:sqlite:game.sqlite");
                db.checkIfCredentialsMatch(username,password);
                break;

            case 2:
                username = ui.promptText("Indtast Brugernavn: ");
                password = ui.promptText("Indtast Kodeord: ");
                db.connect("jdbc:sqlite:game.sqlite");
                db.checkIfUsernameExistsAndPutIntoDB(username,password);
                break;

            default:
                ui.displayMessage("Vælg venligst en gyldig valgmulighed: ");

        }
    }
    public String getName(){
        return username;
    }
}

