import java.util.Scanner;
import java.text.DecimalFormat;

    public class Clock_1 {
        private int hour;
        private int minute;
        private int second;

        Clock_1() {
            hour = 12;
            minute = 0;
            second = 0;
        }

        Clock_1(int hour, int minute, int second) {

            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public Clock_1(int second) {
            if (second > 86399){
                second -= 86400;
            }

            this.minute = (second / 60)%60;
            hour = (int) Math.floor(second / 3600);
            this.second = (second % 60);
        }

        public void setClock() {
            if (0 <= hour && hour < 24)
                this.hour = hour;
            else
                hour = 0;

            if (0 <= minute && minute < 60)
                this.minute = minute;
            else
                this.minute = 0;

            if (0 <= second && second < 60)
                this.second = second;
            else
                this.second = 0;
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public int getSecond() {
            return second;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public Clock_1 addClock(Clock_1 firstClock, Clock_1 secondClock) {

                Clock_1 sum = new Clock_1();
                sum.setSecond(firstClock.getSecond() + secondClock.getSecond());
                sum.setMinute(firstClock.getMinute() + secondClock.getMinute());
                sum.setHour(firstClock.getHour() + secondClock.getHour());

            if(sum.getSecond() > 59) {
                sum.setSecond(sum.getSecond() - 60);
                sum.setMinute(sum.getMinute() + 1);
            }

            if (sum.getMinute() > 59) {
                sum.setMinute(sum.getMinute() - 60);
                sum.setHour(sum.getHour() + 1);
            }

            if (sum.getHour() > 23) {
                sum.setHour(sum.getHour());
                return sum;
            }
            return sum;
        }
        public void tick() {
            this.second += 1;
            this.minute += (int) (this.second / 60);
            this.second = this.second % 60;
            this.hour += (int) (this.minute / 60);
            this.minute = this.minute % 60;
            this.hour = this.hour ;
        }

        public void tickDown() {
            this.second -= 1;
            if (this.second > 0) {
                this.second += 60;
                this.minute -= 1;
            }
            if (this.minute > 0) {
                this.minute += 60;
                this.hour -= 1;
            }
            if (this.hour > 0) {
                this.hour += 24;
            }
        }
        public String toString()
        {
            DecimalFormat mike = new DecimalFormat("00");
            return mike.format(hour)+":" +mike.format(this.minute)+":" +mike.format(this.second);
        }


        public static class Main {
            private static  Scanner scanner=new Scanner(System.in);

            public static void main(String[] args) {
                Clock_1 clock = new Clock_1(00, 00, 00);
                int seconds;
                System.out.println("Enter number of seconds of first clock:\n(Note:Number of seconds in a day are 86400)");
                Scanner readData = new Scanner(System.in);
                seconds = readData.nextInt();

                Clock_1 firstClock = new Clock_1(seconds);
                System.out.println("First Clock: " + firstClock);

                for (int i = 0; i <= 9; i++) {
                    firstClock.tick();
                    System.out.println((i + 1));
                    System.out.println(firstClock);
                }

                int hours=200,minutes=200,second=200;
                while (hours>23){
                    System.out.println("Enter hours:");
                    hours = scanner.nextInt();
                }
                while (minutes>59){
                    System.out.println("Enter minutes:");
                    minutes = minutes - 60;
                    hours++;
                }
                while (second>59){
                    System.out.println("Enter seconds:");
                    second = scanner.nextInt();
                    second = second - 60;
                    minutes++;
                }
                Clock_1 secondClock= new Clock_1(hours,minutes,second);
                System.out.println("First Clock: " + firstClock);
                System.out.println("Second Clock: " + secondClock);


                System.out.println("\nThe sum of the first clock to the second clock:\n" + clock.addClock(firstClock,secondClock));
            }
        }

    }
