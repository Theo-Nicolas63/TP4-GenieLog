package aeroport;

import java.sql.Date;
import java.time.Duration;

public class Etape {
    
    private Date date;

    private Aeroport aeroport;

    private Duration duree;

    public Etape(Date date, Aeroport aeroport, Duration duree) {
        this.date = date;
        this.aeroport = aeroport;
        this.duree = duree;
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

    
}
