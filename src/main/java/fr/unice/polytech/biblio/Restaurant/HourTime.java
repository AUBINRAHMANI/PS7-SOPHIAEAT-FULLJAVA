package fr.unice.polytech.biblio.Restaurant;

import java.util.Objects;

public class HourTime {
    private int hour;
    private int minute;

    public HourTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
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

    public int compareTo(HourTime hourTime) {
        if(this.hour > hourTime.getHour() || (this.hour == hourTime.getHour() && this.minute > hourTime.getMinute())) {
            return 1;
        }
        if(this.hour < hourTime.getHour() || (this.hour == hourTime.getHour() && this.minute < hourTime.getMinute())) {
            return -1;
        }
        return 0;
    }

    public String toString(){
        return hour + " h " + minute + " min";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HourTime hourTime = (HourTime) o;
        return hour == hourTime.hour && minute == hourTime.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }
}
