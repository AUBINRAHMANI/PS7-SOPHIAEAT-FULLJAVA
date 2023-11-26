package fr.unice.polytech.biblio.Restaurant;

public class Schedules {
    private HourTime openingHour;
    private HourTime closingHour;

    public Schedules(HourTime openingHour, HourTime closingHour) {
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    public HourTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(HourTime openingHour) {
        this.openingHour = openingHour;
    }

    public HourTime getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(HourTime closingHour) {
        this.closingHour = closingHour;
    }


}
