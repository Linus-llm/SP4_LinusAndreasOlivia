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

    //Methode til at hente riddles
    private void loadRiddles(){

        riddleList.add("The more you take away from me, the bigger I get. What am I?");
        answerList.add("a hole");
        hintList.add("_ H__E");
        extraHintList.add("Digging this one might help.");

        riddleList.add("I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?");
        answerList.add("an echo");
        hintList.add("A _  E _ _ O");
        extraHintList.add("Sound bouncing off the walls!");

        riddleList.add("What has to be broken before you can use it?");
        answerList.add("an egg");
        hintList.add("N _G");
        extraHintList.add("Crack one for breakfast.");

        riddleList.add("I’m tall when I’m young and short when I’m old. What am I?");
        answerList.add("a candle");
        hintList.add("_ _A___E");
        extraHintList.add("It melts but gives light.");

        riddleList.add("What can run but never walks, has a bed but never sleeps, has a mouth but never talks?");
        answerList.add("a river");
        hintList.add("A  R _ _ _ _");
        extraHintList.add("It flows endlessly.");

        riddleList.add("What has hands but can’t clap?");
        answerList.add("a clock");
        hintList.add("A  C _ _ _ K");
        extraHintList.add("It tells time.");

        riddleList.add("What has many keys but can’t open a single lock?");
        answerList.add("a piano");
        hintList.add("A  P _ _ _ O");
        extraHintList.add("It makes music.");

        riddleList.add("I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?");
        answerList.add("a map");
        hintList.add("A   M _ _");
        extraHintList.add("You use it to find your way.");

    protected Riddle getRiddle(){
        return this;
    }
}
