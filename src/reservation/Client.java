package reservation;

public class Client {

    private String nom;
    private Integer reference;
    private String paiement;
    private String numeroCB;

    
    public Client(String nom, Integer reference, String paiement, String numeroCB) {
        this.nom = nom;
        this.reference = reference;
        this.paiement = paiement;
        this.numeroCB = numeroCB;
    }

}
