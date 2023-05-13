package reservation;
import java.time.ZonedDateTime;
import java.util.List;

import aeroport.Vol;

public class Reservation {

    private Client client;
    private ZonedDateTime date;
    private String id;
    private Passager passager;
    private Vol vol;

    private boolean isPaid = false;

    public Reservation(Client client, Passager passager, Vol vol) {

        if(vol.isReservable() && ZonedDateTime.now().isBefore(vol.getDateDepart())){
            this.client = client;
            this.passager = passager;
            this.vol = vol;
            this.date = ZonedDateTime.now();
            this.id = vol.getNumero() + client.getNom() + date.toString(); // Construction de l'id de reservation
         }
         else{
             System.out.println("Impossible de reserver ce vol");
         }

    }

    public String getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Passager getPassager() {
        return passager;
    }

    public void annuler(){
        vol.getReservations().remove(this);
        vol = null;
    }

    public void confirmer(){
        System.out.println("La reservation numero : " + id + " a été confirme");
    }

    public Vol getVol(){
        return this.vol;
    }

    //Set Vol avec bidirectional avec la classe Vol
    public void setVolWithBidirectional(Vol vol){
        
        this.vol = vol;

        if(!vol.getReservations().contains(this))
            vol.ajouterReservationWithBidirectional(this);
    }

    public void payer(){
        isPaid = true;
        confirmer();
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Reservation) {
            Reservation r = (Reservation) o;
            return this.id.equals(r.getId());
        }

        return false;
    }
}
