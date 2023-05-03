package reservation;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private String client;
    private ZonedDateTime date;
    private Integer id;

    private List<Passager> passagers = new ArrayList<>();

    public Reservation() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        //this.client = new Client(client, 0, "ququbc");
    }

    public List<Passager> getPassagers() {
        return passagers;
    }

    public void ajouterPassager(String nom, String prenom, Integer iD) {
        this.passagers.add(new Passager(nom, prenom, iD));
    }

    public void annuler(){

    }

    public void confirmer(){

    }

    public void payer(){
        
    }
}
