package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class Vol {

    private String numero;

    private Trajet trajet; 

    private Compagnie compagnie;
    
    //private Aeroport depart;

    //private Aeroport arrivee;

    private Date dateDepart;

    private Date dateArrivee;

    public Duration obtenirDuree() {
        if(this.dateDepart != null && this.dateArrivee != null) {
            return Duration.of(dateArrivee.getTime() - dateDepart.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Vol() {
    }

    protected Vol(String numero){
        this.numero = numero;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        if(compagnie!=null) {
            compagnie.addVolWithoutBidirectional(this);
        }
        if(this.compagnie!=null){
            this.compagnie.removeVolWithoutBidirectional(this);
        }
        this.compagnie = compagnie;
    }

    protected void setCompagnieWithoutBidirectional(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

     //Récupère l'aeroport de départ du vol
    public Aeroport getAeroportDepart() {
        return trajet.getSaut().getEtapeDepart().getAeroport();
    }

    //Récupère l'étape de départ du vol puis Set l'aeroport de départ du vol
    public void setDepart(Aeroport depart) {
        trajet.getSaut().getEtapeDepart().setAeroport(depart);
    }

    //Récupère l'aeroport d'arrivée du vol
    public Aeroport getAeroportArrivee() {
        return trajet.getLastSaut().getEtapeArrivee().getAeroport();
    }

    //Récupère l'étape d'arrivée du vol puis set le nouvel aéroport
    public void setArrivee(Aeroport arrivee) {
        trajet.getLastSaut().getEtapeArrivee().setAeroport(arrivee);;
    }

    //Récupère la liste des escales du vol
    public List<Etape> getEscales(){
        return trajet.getEscales();
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return ((Vol) obj).getNumero().equals(this.numero);
        } catch (Exception e){
            return false;
        }
    }
}
