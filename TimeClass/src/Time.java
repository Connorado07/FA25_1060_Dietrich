public class Time {
    // Private data fields
    private int hours;
    private int minutes;
    private int seconds;

    // Default constructor: sets time to midnight
    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    // Constructor with parameters
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Increment function
    public void increment(int sec) {
        seconds += sec;

        minutes += seconds / 60;
        seconds = seconds % 60;

        hours += minutes / 60;
        minutes = minutes % 60;

        hours = hours % 24;
    }

    // Print function
    public void print(boolean military) {
        if (military) {
            System.out.printf("%d:%02d:%02d\n", hours, minutes, seconds);
        } else {
            int displayHour = hours % 12;
            if (displayHour == 0) displayHour = 12;
            String period = (hours < 12) ? "AM" : "PM";
            System.out.printf("%d:%02d:%02d %s\n", displayHour, minutes, seconds, period);
        }
    }
}