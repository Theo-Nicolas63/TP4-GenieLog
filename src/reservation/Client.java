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

    public String getNumeroCB(){
        return this.numeroCB;
    }

    @Override
    public boolean equals(Object o){ // devrait plutot utiliser la réfrence client mais pas implémenté
        if(!(o instanceof Client))
            return false;

        Client c = (Client) o;    
        return this.numeroCB.equals(c.getNumeroCB()); 
    }

    @Override
    public String toString() {
        return "Passager au nom de " + this.nom;
    }
    

}
