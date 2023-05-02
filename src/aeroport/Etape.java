package aeroport;

import java.time.Duration;
import java.time.ZonedDateTime;


public class Etape {
    
    private ZonedDateTime date;

    private Aeroport aeroport;

    public Etape(Zoned date, Aeroport aeroport) {
        this.date = date;
        this.aeroport = aeroport;
    }

    public Date getDate() {
        return date;
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
