package aeroport;

import java.sql.Date;
import java.time.Duration;
import java.util.Date;


public class Etape {
    
    private Date date;

    private Aeroport aeroport;

    private Duration duree;

    public Etape(Date date, Aeroport aeroport) {
        this.date = date;
        this.aeroport = aeroport;
    }

    public Date getDate() {
        return date;
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public Duration getDuree() {
        return duree;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }

    
}
