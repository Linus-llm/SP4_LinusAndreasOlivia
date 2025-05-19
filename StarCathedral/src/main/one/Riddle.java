package main.one;
import java.util.ArrayList;

public class Riddle {
    private final ArrayList<String> extraHintList;
    private final ArrayList<String> riddleList;
    private final ArrayList<String> answerList;
    private final ArrayList<String> hintList;

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
