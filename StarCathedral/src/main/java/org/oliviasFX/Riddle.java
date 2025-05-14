package main.java.org.oliviasFX;
import java.util.ArrayList;

public class Riddle {
    String description;
    ArrayList<String> answerOptions;

    public Riddle(String description, ArrayList<String> answerOptions){
    this.description = description;
    this.answerOptions = answerOptions;
    }


    protected void processAnswer(){}

    protected Riddle getRiddle(){
        return this;
    }
}
