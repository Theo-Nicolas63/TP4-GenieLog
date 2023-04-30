package aeroport;

public class Aeroport {

    private String nom;

    private String ville;

    private String code;

    public Aeroport(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
