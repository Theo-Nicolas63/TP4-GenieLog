package aeroport;

public class Aeroport {

    private String nom;

    private Ville ville;

    private String code;

    public Aeroport(String nom, String ville) {
        this.nom = nom;
        this.ville = new Ville(ville);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville.getNom();
    }

    public void setVille(String ville) {
        this.ville = new Ville(ville);
    }

    public void setCode(String code) {
        this.code = code;
    }
}
