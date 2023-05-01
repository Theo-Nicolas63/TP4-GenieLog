package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class Vol {

    private String numero;

    private Trajet trajet; 

    private Compagnie compagnie;

    
    public Duration obtenirDuree() {
        Date depart = this.trajet.getSaut().getEtapeDepart().getDate();
        Date arrivee = this.trajet.getLastSaut().getEtapeArrivee().getDate();
        if( depart != null && arrivee != null) {
            return Duration.of(arrivee.getTime() - depart.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public Date getDateDepart() {
        return trajet.getSaut().getEtapeDepart().getDate();
    }

    public void setDateDepart(Date dateDepart) {
        trajet.getSaut().setDateDepart(dateDepart);
    }

    public Date getDateArrivee() {
        return trajet.getLastSaut().getEtapeArrivee().getDate();
    }

    public void setDateArrivee(Date dateArrivee) {
        trajet.getLastSaut().setDateArrivee(dateArrivee);
    }

    public Vol() {
    }

    //PROTECTED ????
    protected Vol(String numero) {
        this.numero = numero;
    }

    public Vol(String numero, Aeroport depart, Aeroport arrivee, Date dateDepart, Date dateArrivee) {
        this.numero = numero;
        this.trajet = new Trajet(depart, arrivee, dateDepart, dateArrivee);
    }

    //Appelle la méthode ajouter Escale de la classe saut
    public void ajouterEscale(Aeroport escale, Date datearrivee, Date datedepart) {
        this.trajet.getSaut().ajouterEscale(escale, datearrivee, datedepart);
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

    @Override
    public String toString(){
        String aeroportdepartString = trajet.getSaut().getEtapeDepart().getAeroport().getNom();
        String aeroportarriveeString = trajet.getLastSaut().getEtapeArrivee().getAeroport().getNom();
        String escalesString = "";
        List<Etape> escales = trajet.getSaut().getEtapesEscales();

        for (Etape etape : escales) {
            escalesString += " " + etape.getAeroport().getNom();
        }

        if(!escales.isEmpty())
            return "Le vol " + this.numero + " au départ de " + aeroportdepartString + " à destination de " + aeroportarriveeString + "\nfera escale à " + escalesString;

        return "Le vol " + this.numero + " au départ de " + aeroportdepartString + " à destination de " + aeroportarriveeString;
    }
}
