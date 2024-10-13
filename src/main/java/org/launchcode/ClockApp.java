package org.launchcode;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class ClockApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Schedule a task to update the clock every second
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime now = LocalTime.now();
                System.out.println("Current Time: " + now.format(formatter));
            }
        }, 0, 1000);
    }
}