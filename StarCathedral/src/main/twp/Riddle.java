package twp;

public class Riddle {
    private String riddleText;
    private String answer;
    private String hint;
    private String extraHint;
    private TextUI ui = new TextUI();
    private static int riddleSolvedCounter = 0;

    // Index of the current riddle
    private int currentIndex = 0;

    public Riddle(String riddleText, String answer, String hint, String extraHint) {
        this.riddleText = riddleText;
        this.answer = answer;
        this.hint = hint;
        this.extraHint = extraHint;
    }

    public String getRiddleText(){
        return riddleText;
    }
    public String getAnswer(){
        return answer;
    }
    public String getHint(){
        return hint;
    }
    public String getExtraHint(){
        return extraHint;
    }
    // Checks the answer - asked sister for help with the case equalsIgnoreCase and attempt trim to detuct tries
    public boolean checkAnswer(String attempt){
        return answer.equalsIgnoreCase(attempt.trim());
    }

    public void displayRiddle(){
        System.out.println(getRiddleText());
        System.out.println(getHint());
        boolean userAnswer = checkAnswer(ui.promptText("Skriv dit svar: "));

        if (userAnswer){
            ui.displayMessage("Korrekt du har tændt et lys");
            Riddle.riddleSolvedCounter++;
            ui.displayMessage("Du har tændt et lys du er oppe på: "+ Riddle.getRiddleSolvedCounter() +"/7");


        }else {
            while (!userAnswer) {
                ui.displayMessage("Svaret var ikke korrekt, du får et ekstra hint");
                ui.displayMessage(getExtraHint());
                userAnswer = checkAnswer(ui.promptText("Skriv dit svar: "));
                if(userAnswer){
                    ui.displayMessage("Korrekt du har tændt et lys");
                    Riddle.riddleSolvedCounter++;
                    ui.displayMessage("Du har tændt et lys du er oppe på: "+ Riddle.getRiddleSolvedCounter() +"/7");

                }
            }
        }

    }
    public static int getRiddleSolvedCounter(){
        return riddleSolvedCounter;
    }
}
