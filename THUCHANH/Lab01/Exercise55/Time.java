public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
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

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //advance by 1 second and return this instance
    public Time nextSecond() {
        ++second;
        if (second == 60) {
            second = 0;
            ++minute;
            if (minute == 60) {
                minute = 0;
                ++hour;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
        return this;
    }
    //rewind by 1 second and return this instance
    public Time previousSecond() {
        --second;
        if (second == -1) {
            second = 59;
            --minute;
            if (minute == -1) {
                minute = 59;
                --hour;
                if (hour == -1) {
                    hour = 23;
                }
            }
        }
        return this;
    }
    //return time in the format "hh:mm:ss" with leading zeros
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    // // Main method to test the class functionality
    // public static void main(String[] args) {
    //     Time time = new Time(23, 59, 59);
    //     System.out.println("Initial time: " + time); // 23:59:59
    //     time.nextSecond();
    //     System.out.println("After nextSecond: " + time); // 00:00:00
    //     time.previousSecond();
    //     System.out.println("After previousSecond: " + time); // 23:59:59
    // }
}
