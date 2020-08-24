import static java.lang.Math.abs;

import java.util.Scanner;

public class clock {
    private int hours;
    private int minutes;
    private int seconds;

    public clock() {
        hours = 12;
        minutes = 0;
        seconds = 0;
    }

    public clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public clock(int seconds) {

        this.hours = (seconds / 3600) % 24;
        this.minutes = (seconds % 3600) / 60;
        this.seconds = seconds % 60;
    }


    public void setClock(int seconds) {

        this.hours = (seconds / 3600) % 24;
        this.minutes = (seconds % 3600) / 60;
        this.seconds = seconds % 60;
    }


    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void incrementSeconds() {
        this.seconds++;
        if (this.seconds > 59) {
            this.seconds = 0;
            incrementMinutes();
        }
    }

    public void incrementMinutes() {
        this.minutes++;
        if (this.minutes > 59) {
            this.minutes = 0;
            incrementHours();
        }
    }

    public void incrementHours() {
        this.hours++;
        if (this.hours > 23)
            this.hours = 0;
    }

    public void decrementHours() {
        this.hours--;
        if (this.hours < 0) {
            this.hours = 23;

        }
    }

    public void decrementMinutes() {
        this.minutes--;
        if (this.minutes < 0) {
            this.minutes = 59;
            decrementHours();
        }
    }

    public void decrementSeconds() {
        this.seconds--;
        if (this.seconds < 0) {
            this.seconds = 59;
            this.decrementMinutes();
        }
    }


    public void tick() {
        this.incrementSeconds();
    }

    public void tickDown() {
        this.decrementSeconds();
    }


    public void addClocks(clock keyboard)// can also be used for set clock
    {
        int totalSeconds;
        totalSeconds = (keyboard.hours * 60 * 60) + (keyboard.minutes * 60) + (keyboard.seconds);
        totalSeconds += (this.hours * 60 * 60) + (this.minutes * 60) + (this.seconds);

        this.setClock(totalSeconds);

        while (totalSeconds >= 0) {
            this.tick();
            totalSeconds--;
        }

    }
    /*public void addclock(Clock secondClocks){
        this.seconds += secondClocks.getSeconds();
        this.minutes += secondClocks.getMinutes();
//add overflow to minutes from seconds
        this.minutes +=(int)(this.seconds/60);
//update seconds
        this.seconds = this.seconds % 60;
        this.hour += secondClocks.gethour();
//add overflow to minutes from seconds
        this.hour +=(int)(this.minutes/60);
//update minutes
        this.minutes = this.minutes % 60;
//adjust hours
        this.hour = this.hour % 24;
    }*/
        public String toString() {
        return this.hours + ":" + this.minutes + ":" + this.seconds;

    }


    public static void main(String[] args) {

        Scanner Read = new Scanner(System.in);
        System.out.println("Enter seconds since midnight: ");
        int TimeSinceMidnight = abs(Read.nextInt());

        clock firstClock = new clock(TimeSinceMidnight);
        System.out.println("Enter hours: ");

        int hours = abs(Read.nextInt());
        System.out.println("Enter minutes: ");

        int minutes = abs(Read.nextInt());
        System.out.println("Enter seconds: ");

        int seconds = abs(Read.nextInt());

        clock secondClock = new clock(hours, minutes, seconds);
        //firstClock.setHours(12);
        //firstClock.setMinutes(23);
        //firstClock.setSeconds(45);
        //firstClock.setClock(12330);

        for (int i = 0; i < 10; i++) {
            firstClock.tick();
            System.out.println(firstClock.toString());
        }
        secondClock.addClocks(firstClock);
        System.out.println("firstClock= " + firstClock.toString());
        System.out.println("secondClock= " + secondClock.toString());

    }


}
