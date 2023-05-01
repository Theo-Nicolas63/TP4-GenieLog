package reservation;

public class Reservation {

    private Client client;
    private Date date;
    private Integer id;

    private List<Passager> passagers = new ArrayList<>();

    public Reservation() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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
