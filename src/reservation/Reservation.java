package reservation;
import java.time.ZonedDateTime;
import java.util.List;

import aeroport.Vol;

public class Reservation {

    private Client client;
    private ZonedDateTime date;
    private Integer id;
    private Passager passager;
    private Vol vol;

    private boolean isPaid = false;

    public Reservation() {
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

    public void payer(){
        isPaid = true;
        confirmer();
    }
}
