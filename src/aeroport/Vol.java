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

    private boolean IsReservable = false;

    private List<Reservation> reservations = new ArrayList<>();


    //PROTECTED 
    protected Vol(String numero) {
        this.numero = numero;
    }
    
     /** 
    * Constructeur de Vol
    *  
    * @param depart Aerport de départ
    * @param arrivee Aeroport d'arrivée
    * @param dateDepart Date de départ 
    * @param dateArrivee Aeriport d'arrivée
    */
    public Vol(Aeroport depart, Aeroport arrivee, Date dateDepart, Date dateArrivee) {
    
        ZonedDateTime ZdateDepart = ZonedDateConverter.DateToZonedDateTime(dateDepart, depart.getZoneId()); // Conversion en ZonedDateTime avec classe converter
        ZonedDateTime ZdateArrivee = ZonedDateConverter.DateToZonedDateTime(dateArrivee, arrivee.getZoneId()); // Conversion en ZonedDateTime avec classe converter
    
        this.trajet = new Trajet(depart, arrivee, ZdateDepart, ZdateArrivee); // Instanciation du trajet 
    }

    /** 
    * Méthode permettant de récuprér la durée d'un vol en type Duration
    *  
    * @return la durée d'un vol
    */
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

    /** 
    * Permet de set la date de départ du vol et donc du premier saut
    *  
    * @param dateDepart date de départ 
    */
    public void setDateDepart(Date dateDepart) {
        ZonedDateTime ZdateDepart = ZonedDateConverter.DateToZonedDateTime(dateDepart, this.trajet.getSaut().getEtapeDepart().getAeroport().getZoneId());

        try {

            if(this.trajet.getSaut().isDateDepartValid(ZdateDepart)) // Vérifie si la date de départ que l'on veut setter est bien avant la date d'arrivée
                trajet.getSaut().setDateDepart(ZdateDepart);
            else {
                throw new IllegalArgumentException("Date invalide");
             }
        }
        catch (Exception e)  {
            System.out.println(e.getMessage());
        }

    }

    public ZonedDateTime getDateArrivee() {
        return trajet.getLastSaut().getEtapeArrivee().getDate();
    }

    public void setDateArrivee(Date dateArrivee) {
        ZonedDateTime ZdateDArrivee = ZonedDateConverter.DateToZonedDateTime(dateArrivee, this.trajet.getLastSaut().getEtapeArrivee().getAeroport().getZoneId());

        try {
            if(this.trajet.getLastSaut().isDateArriveeValid(ZdateDArrivee)) // Vérifie si la date que l'on veut setter est bien apres la date de départ du saut en question
                trajet.getLastSaut().setDateArrivee(ZdateDArrivee);
            else
                throw new IllegalArgumentException("Date invalide !");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Appelle la méthode ajouter Escale de la classe saut
    public void ajouterEscale(Aeroport escale, Date datearrivee, Date datedepart) {
        ZonedDateTime ZdateDepart = ZonedDateConverter.DateToZonedDateTime(datedepart, escale.getZoneId());
        ZonedDateTime ZdateArrivee = ZonedDateConverter.DateToZonedDateTime(datearrivee, escale.getZoneId());

        this.trajet.getSaut().ajouterEscale(escale, ZdateArrivee, ZdateDepart);
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnieWithBidirectional(Compagnie compagnie) {

        this.compagnie = compagnie;

        if(this.numero == null)
            this.setNumero(); // set le numéro de vol lors de l'affectation à une compagnie

        if(!compagnie.getVols().contains(this)) {
            this.compagnie.addVolWithBidirectional(this);
        }
    }

    //pas utilisée
    protected void setCompagnieWithoutBidirectional(Compagnie compagnie) {
        this.compagnie = compagnie;
        if(this.numero == null)
            this.setNumero(); // set le numéro de vol lors de l'affectation à une compagnie
    }

    public String getNumero() {
        return numero;
    }


    //Génère un numéro de vol lors de l'affectation à une compagnie
    private void setNumero() {
        this.numero = this.compagnie.getGeneratorNumeroVol().next();
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

    //Ajout d'une reservation à la liste des réservation avec Bidirectional
    public void ajouterReservationWithBidirectional(Reservation reservation) {
        
        if(reservations.size() < 150){ // Limite de passagers
            this.reservations.add(reservation);
            
            if(!reservation.getVol().equals(this)) //IMPOSSIBLE DE CREER UNE RESERVATION SANS VOL DONC INUTILE OU DE CHANGER DE VOL SUR LA MEME RESERVATION
                reservation.setVolWithBidirectional(this); 
        } 
        else {
            throw new IllegalArgumentException("Le vol est complet");
        }
    }

    //Annulation d'une reservation à la liste des réservation avec Bidirectional
    public void annulerReservationWithBidirectional(Reservation reservation) {
        this.reservations.remove(reservation);

        if(reservation.getVol().equals(this))
            reservation.annulerWithBidirectional();
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    //Supprime la compagnie avec bidirectional
    public void removeCompagnieWithBidirectional() {

        this.compagnie = null;

        if(this.compagnie.getVols().contains(this))
            this.compagnie.removeVolWithBidirectional(this);

    }

    public void fermer(Compagnie compagnie){

        try {
            if(this.compagnie.equals(compagnie)){
                this.IsReservable = false;
            }
            else {
                throw new IllegalArgumentException("La compagnie n'est pas autorisée à fermer ce vol");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ouvrir(Compagnie compagnie){

        try {
            if(this.compagnie.equals(compagnie)){
                this.IsReservable = true;
            }
            else {
                throw new IllegalArgumentException("La compagnie n'est pas autorisée à ouvrir ce vol");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isReservable(){
        return this.IsReservable;
    }

    /** 
     * Permet de décler le depart d'un vol qui ne possède pas d'escale
     * @param delais : durée du décalage
     * */ 
    public void decaler(Duration delais){
        if(this.trajet.getSaut().getEtapesEscales().isEmpty()){
            this.trajet.getLastSaut().getEtapeArrivee().setDate(this.trajet.getLastSaut().getEtapeArrivee().getDate().plus(delais));
            this.trajet.getSaut().getEtapeDepart().setDate(this.trajet.getSaut().getEtapeDepart().getDate().plus(delais));
        }
        else {
            throw new IllegalArgumentException("Le vol possède des escales, il est donc impossible de le décaler");
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
