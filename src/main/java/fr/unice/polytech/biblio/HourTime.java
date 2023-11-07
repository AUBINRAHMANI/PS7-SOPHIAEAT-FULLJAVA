package fr.unice.polytech.biblio;

public class HourTime {
    private int hour;
    private int minute;

    public HourTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHours() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
