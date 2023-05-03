package aeroport;

import java.time.Duration;
import java.time.ZonedDateTime;


public class Etape {
    
    private ZonedDateTime date;

    private Aeroport aeroport;

    public Etape(ZonedDateTime date, Aeroport aeroport) {
        this.date = date;
        this.aeroport = aeroport;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    
}
