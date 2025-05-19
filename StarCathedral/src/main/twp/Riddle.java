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

    //Methode til at hente riddles
    /*
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

        riddleList.add("What has a head, a tail, is brown, and has no legs?");
        answerList.add("a penny");
        hintList.add("_ _NNY");
        extraHintList.add("You find me in your pocket.");

        riddleList.add("David's father has three sons: Snap, Crackle, and _____?");
        answerList.add("david");
        hintList.add("D _ V _ D");
        extraHintList.add("Just read the first word.");

        riddleList.add("Can you name three consecutive days without using the words Monday through Sunday?");
        answerList.add("yesterday today tomorrow");
        hintList.add("_ESTERDAY _ ODAY _OMORROW");
        extraHintList.add("They’re all relative to 'now'.");

        riddleList.add("I have no mouth, so I cannot lie. I see the truth without use of eyes. What am I?");
        answerList.add("a reflection");
        hintList.add("_ _FLECTI _ N");
        extraHintList.add("Look into a mirror.");

        riddleList.add("I come in different shapes but my use is same... I remember things and then I don't. What am I?");
        answerList.add("a calculator");
        hintList.add("A  C _ _L _ L _ T _ R");
        extraHintList.add("You press my buttons.");

        riddleList.add("I go up and then come down; rhymes with mountain; a state of matter. What am I?");
        answerList.add("water fountain");
        hintList.add("W _ T _ R  F _ U _ T _ I N");
        extraHintList.add("Often found in malls.");

        riddleList.add("What's the coolest letter in the alphabet?");
        answerList.add("b");
        hintList.add("B");
        extraHintList.add("It’s surrounded by AC.");

        riddleList.add("What has six faces but does not wear makeup, has twenty-one eyes but cannot see?");
        answerList.add("a die");
        hintList.add("A  D _");
        extraHintList.add("You roll it.");

        riddleList.add("What is shaped like a box, has no feet, and runs up and down?");
        answerList.add("an elevator");
        hintList.add("A _  E _ _ V _ T _ R");
        extraHintList.add("You push a button to call me.");

        riddleList.add("Little Tommy Tittletat took two Ts… How many Ts in all of that?");
        answerList.add("two");
        hintList.add("_ W O");
        extraHintList.add("Read the phrase literally.");

        riddleList.add("What do you call a bear with no teeth?");
        answerList.add("a gummy bear");
        hintList.add("A  G U _ M Y  B _ A _");
        extraHintList.add("It’s candy.");

        riddleList.add("What did the triangle say to the circle?");
        answerList.add("you’re pointless");
        hintList.add("Y _ U’R _  P _ I _ T L _ _ S");
        extraHintList.add("Polygons only.");

        riddleList.add("A father's child, a mother's child, yet no one's son. Who am I?");
        answerList.add("a daughter");
        hintList.add("A  D _ U G H T _ R");
        extraHintList.add("Not male.");

        riddleList.add("I have a heart that never beats, a home but never sleeps. Who am I?");
        answerList.add("the king of hearts");
        hintList.add("T _ E  K _ N G  O F  H _ A R T S");
        extraHintList.add("A playing-card royal.");

        riddleList.add("A cloud was my mother, the wind is my father, my son is the cool stream… What am I?");
        answerList.add("rain");
        hintList.add("R _ I _ N");
        extraHintList.add("Drops from the sky.");

        riddleList.add("What has a thumb and four fingers but is not alive?");
        answerList.add("a glove");
        hintList.add("A  G L _ V _");
        extraHintList.add("You wear me.");

        riddleList.add("I’m always in front of you but you can never see me. What am I?");
        answerList.add("the future");
        hintList.add("T H _  F U T _ R E");
        extraHintList.add("Time-related.");

        riddleList.add("What can you catch but not throw?");
        answerList.add("a cold");
        hintList.add("A  C _ L D");
        extraHintList.add("It’s viral.");

        riddleList.add("What is light as a feather but even the world’s strongest man can’t hold it for more than a minute?");
        answerList.add("breath");
        hintList.add("B R _ _ T H");
        extraHintList.add("You take me in and out.");

        riddleList.add("What starts with E, ends with E, but only contains one letter?");
        answerList.add("an envelope");
        hintList.add("A N  E N V E L _ P E");
        extraHintList.add("You mail me.");

        riddleList.add("What has four wheels and flies, but is not an aircraft?");
        answerList.add("a garbage truck");
        hintList.add("A  G _ R B G E  T R _ C K");
        extraHintList.add("It comes for your trash.");

        riddleList.add("What kind of running always means walking?");
        answerList.add("running out of gas");
        hintList.add("R U N N _ N G  O U T  O F  G A S");
        extraHintList.add("Vehicle related.");

        riddleList.add("What kind of candy would a prisoner want before he is executed?");
        answerList.add("a lifesaver");
        hintList.add("A  L I F E S A V _ R");
        extraHintList.add("It’s minty.");

        riddleList.add("What has a neck but no head?");
        answerList.add("a bottle");
        hintList.add("A  B O T T L E");
        extraHintList.add("You pour from me.");

        riddleList.add("What can travel around the world while staying in a corner?");
        answerList.add("a stamp");
        hintList.add("A  S T _ M P");
        extraHintList.add("You stick me on an envelope.");

        riddleList.add("What has many teeth but cannot eat?");
        answerList.add("a comb");
        hintList.add("A  C O M B");
        extraHintList.add("You run me through hair.");

        riddleList.add("What building has the most stories?");
        answerList.add("a library");
        hintList.add("A  L I B R A R Y");
        extraHintList.add("Books abound.");

        riddleList.add("What can fill a room but takes up no space?");
        answerList.add("light");
        hintList.add("L I G H T");
        extraHintList.add("You flip a switch.");

        riddleList.add("What has words but never speaks?");
        answerList.add("a book");
        hintList.add("A  B _ O K");
        extraHintList.add("Full of pages.");

        riddleList.add("What has legs but doesn't walk?");
        answerList.add("a table");
        hintList.add("A  T _ B L E");
        extraHintList.add("You dine on me.");

        riddleList.add("What is more useful when broken?");
        answerList.add("a promise");
        hintList.add("A  P R O M I S E");
        extraHintList.add("Words you keep.");

        riddleList.add("What has a bed but never sleeps and a mouth but never eats?");
        answerList.add("a river");
        hintList.add("A  R I V E R");
        extraHintList.add("It flows.");

        riddleList.add("What can you catch but cannot see?");
        answerList.add("a cold");
        hintList.add("A  C O L D");
        extraHintList.add("Typically in winter.");

        riddleList.add("What has a heart that doesn’t beat?");
        answerList.add("an artichoke");
        hintList.add("A N  A R T I C H O K E");
        extraHintList.add("A prickly vegetable.");

        riddleList.add("What do you call a fake noodle?");
        answerList.add("an impasta");
        hintList.add("A N  I M P A S T A");
        extraHintList.add("Don’t serve me with sauce.");

        riddleList.add("Why did the scarecrow win an award?");
        answerList.add("he was outstanding in his field");
        hintList.add("H E  W _ S  O U T S T _ N D I N G");
        extraHintList.add("Corny joke.");

        riddleList.add("What do you call cheese that isn't yours?");
        answerList.add("nacho cheese");
        hintList.add("N A C H O  C H E E S E");
        extraHintList.add("Ask for my dip.");

        riddleList.add("What has a ring but no finger?");
        answerList.add("a telephone");
        hintList.add("A  T E L E P H O N E");
        extraHintList.add("You hear me ring.");
    }
*/

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

    public boolean displayRiddle(){
        System.out.println(getRiddleText());
        System.out.println(getHint());
        boolean userAnswer = checkAnswer(ui.promptText("Skriv dit svar: "));

        if (userAnswer){
            ui.displayMessage("Korrekt du har tændt et lys");
            riddleSolvedCounter++;
            return true;
        }else {
            while (!userAnswer) {
                ui.displayMessage("Svaret var ikke korrekt, du får et ekstra hint");
                ui.displayMessage(getExtraHint());
                userAnswer = checkAnswer(ui.promptText("Skriv dit svar: "));
            }
        }
        return false;
    }
    public static int getRiddleSolvedCounter(){
        return riddleSolvedCounter;
    }


/*

    // Return current riddle pattern
    public String getCurrentRiddle(){
        return riddleList.get(currentIndex);
    }
    // Return the current hint pattern
    public String getCurrentClue(){
        return hintList.get(currentIndex);
    }
    // Return current ekstra hint pattern
    public String getCurrentExtraClue() {
        return extraHintList.get(currentIndex);
    }

    // Goes to next riddle
    public void nextRiddle(){
        currentIndex = (currentIndex +1) % riddleList.size();
    }

 */
}
