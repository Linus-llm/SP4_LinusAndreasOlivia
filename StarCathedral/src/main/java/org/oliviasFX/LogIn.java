package org.oliviasFX;

public class LogIn {
    TextUI ui = new TextUI();
    protected void login(){
        ui.displayMessage("Hej og velkommen til Stjernepræsternes stjernekatedral!");
        int userChoice = ui.promptNumeric("1. Login\n2. Opret konto");

        String username;
        String password;
        switch (userChoice) {
            case 1:
                accountName = ui.promptText("Indtast Brugernavn: ");
                password = ui.promptText("Indtast Kodeord: ");
                loginSucces(accountLogin(accountName, password), password);
                break;

            case 2:
                accountName = ui.promptText("Indtast Brugernavn: ");
                password = ui.promptText("Indtast Kodeord: ");
                loginSucces(createAccount(accountName, password));
                break;

            default:
                ui.displayMessage("Vælg venligst en gyldig valgmulighed: ");
                runChill();
        }
    }
}

