// // Tess - prøver lige hurtigt at ændre package one til main.one på flere klasser, skifter tilbage med det samme hvis det ikke virker, men jeg kan ikke compile - package one;

package main.one;

public class Timer {

protected void showTime(long startTime){


    long elapsedTime = System.currentTimeMillis() - startTime;
    long elapsedSeconds = elapsedTime / 1000;
    long secondsDisplay = elapsedSeconds % 60;
    long elapsedMinutes = elapsedSeconds / 60;

    System.out.println("Du har brugt så mange sekunder: "+secondsDisplay);


}
}
