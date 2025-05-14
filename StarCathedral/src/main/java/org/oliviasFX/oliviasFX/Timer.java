package main.java.org.oliviasFX.oliviasFX;

public class Timer {

protected void showTime(long startTime){


    long elapsedTime = System.currentTimeMillis() - startTime;
    long elapsedSeconds = elapsedTime / 1000;
    long secondsDisplay = elapsedSeconds % 60;
    long elapsedMinutes = elapsedSeconds / 60;

    System.out.println("Du har brugt så mange sekunder: "+secondsDisplay);


}
}
