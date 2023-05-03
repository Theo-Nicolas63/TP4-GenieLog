package aeroport;

import java.util.List;
import java.util.Date;
import java.time.ZonedDateTime;


public class Trajet {

    private Saut saut;

    public Trajet(Aeroport depart, Aeroport arrivee, ZonedDateTime dateDepart, ZonedDateTime dateArrivee) {
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

      //Récupère la liste des escales du vol
      public List<Etape> getEscales(){
        return saut.getEtapesEscales();
    }

}
