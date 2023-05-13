package aeroport;

import java.util.List;
import java.util.Date;
import java.time.ZonedDateTime;


public class Trajet {

    private Saut saut; // attribut saut

    /** 
    * Constructeur de Trajet
    *  
    * @param depart Aerport de départ
    * @param arrivee Aeroport d'arrivée
    * @param dateDepart Date de départ en ZonedDateTime
    * @param dateArrivee Aeriport d'arrivée en ZonedDateTime
    */
    public Trajet(Aeroport depart, Aeroport arrivee, ZonedDateTime dateDepart, ZonedDateTime dateArrivee) {
        try {
            this.saut = new Saut(depart, arrivee, dateDepart, dateArrivee);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public Saut getSaut() {
        return saut;
    }

    public void setSaut(Saut saut) {
        this.saut = saut;
    }

    /** 
    * Méthode qui permet de récupérer le dernier saut d'un trajet dans le cas où il y a des escales
    *  
    * @return retourne le dernier saut du trajet
    */
    public Saut getLastSaut(){
        return saut.getLastSaut();
    }

      //Récupère la liste des escales du vol
      public List<Etape> getEscales(){
        return saut.getEtapesEscales();
    }

}
