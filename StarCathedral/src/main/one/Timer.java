package one;

public class Timer {
    long secondsDisplay;

protected void showTime(long startTime){


    long elapsedTime = System.currentTimeMillis() - startTime;
    long elapsedSeconds = elapsedTime / 1000;
    secondsDisplay = elapsedSeconds % 60;
    long elapsedMinutes = elapsedSeconds / 60;

    System.out.println("Du har brugt så mange sekunder: "+secondsDisplay);


}
public long getSeconds(){
    return secondsDisplay;
}
}
