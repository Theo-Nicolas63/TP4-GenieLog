package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import converter.ZonedDateConverter;

import java.time.ZonedDateTime;

import reservation.Reservation;

import java.time.ZonedDateTime;

public class Vol {

    private String numero;

    private Trajet trajet; 

    private Compagnie compagnie;

    private List<Reservation> reservations = new ArrayList<>();

    
    public Duration obtenirDuree() {
        ZonedDateTime depart = this.trajet.getSaut().getEtapeDepart().getDate();
        ZonedDateTime arrivee = this.trajet.getLastSaut().getEtapeArrivee().getDate();
        if( depart != null && arrivee != null) {
            return Duration.between(depart, arrivee);
        }
        return null;
    }

    public ZonedDateTime getDateDepart() {
        return trajet.getSaut().getEtapeDepart().getDate();
    }

    //VERIF DATE
    public void setDateDepart(Date dateDepart) {
        ZonedDateTime ZdateDepart = ZonedDateConverter.DateToZonedDateTime(dateDepart, this.trajet.getSaut().getEtapeDepart().getAeroport().getZoneId());
        trajet.getSaut().setDateDepart(ZdateDepart);
    }

    public ZonedDateTime getDateArrivee() {
        return trajet.getLastSaut().getEtapeArrivee().getDate();
    }

    //VERIF DATE
    public void setDateArrivee(Date dateArrivee) {
        ZonedDateTime ZdateDArrivee = ZonedDateConverter.DateToZonedDateTime(dateArrivee, this.trajet.getLastSaut().getEtapeArrivee().getAeroport().getZoneId());
        trajet.getLastSaut().setDateArrivee(ZdateDArrivee);
    }

    //PROTECTED ????
    protected Vol(String numero) {
        this.numero = numero;
    }

    //VERIF DATE ??
    public Vol(String numero, Aeroport depart, Aeroport arrivee, Date dateDepart, Date dateArrivee) {

        ZonedDateTime ZdateDepart = ZonedDateConverter.DateToZonedDateTime(dateDepart, depart.getZoneId());
        ZonedDateTime ZdateArrivee = ZonedDateConverter.DateToZonedDateTime(dateArrivee, arrivee.getZoneId());

        this.numero = numero;
        this.trajet = new Trajet(depart, arrivee, ZdateDepart, ZdateArrivee);
    }

    //Appelle la méthode ajouter Escale de la classe saut
    public void ajouterEscale(Aeroport escale, ZonedDateTime datearrivee, ZonedDateTime datedepart) {
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

    public void ajouterReservation(Reservation reservation) {

        if(reservations.size() < 150)
            this.reservations.add(reservation);
        else {
            throw new IllegalArgumentException("Le vol est complet");
        }
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void fermer(Compagnie compagnie){
        if(this.compagnie.equals(compagnie)){
            this.IsReservable = false;
        }
        else {
            throw new IllegalArgumentException("La compagnie n'est pas autorisée à fermer ce vol");
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
