// Alternative version. Hvis i fortrækker den anden har jeg den liggende :)
// Jeg kan tilføje en funktion der afslører ét bogstav ad gangen? Mine søster nævnte revealNextLetter, da vi lige gennemgik min kode
// Updated riddle with ekstra hints - Tess

// package org.oliviasFX;
import java.util.ArrayList;

public class Riddle {
    // Jeg har tilføjet en ekstra hint istedet for de 3 bogstave hints, kan ændres hvis det er
    private ArrayList<String> extraHintList;
    private ArrayList<String> riddleList;
    private ArrayList<String> answerList;
    private ArrayList<String> hintList;
    loadRiddles();
   //frfr

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
        hintList.add("_N _G_");
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

        riddleList.add("The more of me you take, the more you leave behind. What am I?");
        answerList.add("footsteps");
        hintList.add("F _ _ _ _ _ _ _ S");
        extraHintList.add("You hear me when walking.");

        riddleList.add("What gets wetter the more it dries?");
        answerList.add("a towel");
        hintList.add("A  T _ _ _ _");
        extraHintList.add("Used after a shower.");

        riddleList.add("What comes once in a minute, twice in a moment, but never in a thousand years?");
        answerList.add("the letter m");
        hintList.add("T _ _  _ _ _ _ _  M");
        extraHintList.add("Introducing a letter.");

        riddleList.add("What begins with T, ends with T, and has T in it?");
        answerList.add("a teapot");
        hintList.add("A  T _ _ _ _ T");
        extraHintList.add("Full of hot water aaaand?");

        riddleList.add("What has one eye but can’t see?");
        answerList.add("a needle");
        hintList.add("A  N _ _ _ _ E");
        extraHintList.add("Used in sewing.");

        riddleList.add("What kind of room has no doors or windows?");
        answerList.add("a mushroom");
        hintList.add("A  M _ _ _ _ _ _ _");
        extraHintList.add("A kind of fungus.");

        riddleList.add("What goes up but never comes down?");
        answerList.add("your age");
        hintList.add("Y _ _ _  A _ _");
        extraHintList.add("Increases every year.");

        riddleList.add("What is full of holes but still holds water?");
        answerList.add("a sponge");
        hintList.add("A  S _ _ _ _ _");
        extraHintList.add("Used for cleaning.");

        riddleList.add("Forward I’m heavy, but backward I’m not. What am I?");
        answerList.add("a ton");
        hintList.add("A  T _ _");
        extraHintList.add("One of the words in the riddle spelt backwards.");

        riddleList.add("What invention lets you look right through a wall?");
        answerList.add("a window");
        hintList.add("A  W _ _ _ _ _");
        extraHintList.add("Glass is key.");

        riddleList.add("I’m found in socks, scarves and mittens. What am I?");
        answerList.add("yarn");
        hintList.add("Y _ _ _");
        extraHintList.add("Cats love it.");

        riddleList.add("What belongs to you, but other people use it more than you do?");
        answerList.add("your name");
        hintList.add("Y _ _ _  N _ _ _");
        extraHintList.add("It’s how people call you.");

        riddleList.add("What has words, but never speaks?");
        answerList.add ("a book");
        hintList.add ("A  B _ _ _");
        extraHintList.add("Full of stories.");

    }
}
// For at koble gåderne til room tænkte jeg at jeg ville arbejde lidt på det her indtil vi mødes
// private int riddleIndex = -1;