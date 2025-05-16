package one;
import java.util.ArrayList;

public class Riddle {
    // Jeg har tilføjet en ekstra hint istedet for de 3 bogstave hints, kan ændres hvis det er
    private ArrayList<String> extraHintList;
    private ArrayList<String> riddleList;
    private ArrayList<String> answerList;
    private ArrayList<String> hintList;
    loadRiddles();


    public Riddle(String description, ArrayList<String> answerOptions){
    this.description = description;
    this.answerOptions = answerOptions;
    }


    protected void processAnswer(){}

    protected Riddle getRiddle(){
        return this;
    }
}
