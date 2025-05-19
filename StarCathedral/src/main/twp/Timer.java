package twp;

public class Timer {
    long secondsDisplay;
    long elapsedSeconds;
    long elapsedMinutes;
protected void showTime(long startTime){


    long elapsedTime = System.currentTimeMillis() - startTime;
    elapsedSeconds = elapsedTime / 1000;
    secondsDisplay = elapsedSeconds % 60;
    elapsedMinutes = elapsedSeconds / 60;

    System.out.println("Du har brugt så mange minutter: "+elapsedMinutes+" og så mange sekunder: "+secondsDisplay);


}
public long getSeconds(){
    return elapsedMinutes+elapsedSeconds;
}
}
