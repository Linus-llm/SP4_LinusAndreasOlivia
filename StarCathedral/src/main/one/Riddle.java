package one;
import java.util.ArrayList;

public class Riddle {
    // Jeg har tilføjet en ekstra hint istedet for de 3 bogstave hints, kan ændres hvis det er
    private ArrayList<String> extraHintList;
    private ArrayList<String> riddleList;
    private ArrayList<String> answerList;
    private ArrayList<String> hintList;

    // Index of the current riddle
    private int currentIndex = 0;

    public Riddle(){
        extraHintList = new ArrayList<>();
        riddleList = new ArrayList<>();
        answerList = new ArrayList<>();
        hintList = new ArrayList<>();
        loadRiddles();
    }


    protected void processAnswer(){}

    protected Riddle getRiddle(){
        return this;
    }
}
