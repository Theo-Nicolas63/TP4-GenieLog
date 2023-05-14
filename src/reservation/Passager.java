package reservation;

public class Passager {
    
    private String nom;
    private String prenom;
    private String numeroPieceIdentite;
    

    public Passager(String nom, String prenom, String iD){
        this.nom = nom;
        this.prenom = prenom;
        this.numeroPieceIdentite = iD;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroPieceIdentite() {
        return numeroPieceIdentite;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Passager))
            return false;

        Passager p = (Passager) o;    
        return this.numeroPieceIdentite.equals(p.getNumeroPieceIdentite());
    }

    @Override
    public String toString() {
        return "Passager au nom de " + this.nom + " " + this.prenom;
    }

    
}
