package aeroport;

import java.util.List;
import java.util.Date;


public class Trajet {

    private Saut saut;

    public Trajet(Aeroport depart, Aeroport arrivee, Date dateDepart, Date dateArrivee) {
        this.saut = new Saut(depart, arrivee, dateDepart, dateArrivee);
    }

    public Saut getSaut() {
        return saut;
    }

    public void setSaut(Saut saut) {
        this.saut = saut;
    }

    public Saut getLastSaut(){
        return saut.getLastSaut();
    }

}
