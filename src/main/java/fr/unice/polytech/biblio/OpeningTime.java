package fr.unice.polytech.biblio;

public class OpeningTime {
    private HourTime openingHour;
    private HourTime closingHour;

    public OpeningTime(HourTime openingHour, HourTime closingHour) {
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
