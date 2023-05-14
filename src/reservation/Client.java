package reservation;

public class Client {

    private String nom;
    private String reference;
    private String paiement;
    private String numeroCB;

    
    public Client(String nom, String paiement, String numeroCB) {
        this.nom = nom;
        this.paiement = paiement;
        this.numeroCB = numeroCB;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

}
