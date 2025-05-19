// Tess - prøver lige hurtigt at ændre package one til main.one på flere klasser, skifter tilbage med det samme hvis det ikke virker, men jeg kan ikke compile - package one;
package main.one;

public class LogIn {
    TextUI ui = new TextUI();
    DBConnector db = new DBConnector();
    protected void login(){
        ui.displayMessage("Hej og velkommen til Stjernepræsternes stjernekatedral!");
        int userChoice = ui.promptNumeric("1. Login\n2. Opret konto");

        String username;
        String password;
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
}

