package aeroport;

import java.time.ZoneId;

public class Aeroport {

    private String nom;

    private Ville ville;

    private String code;

    private ZoneId zoneId;

    public Aeroport(String nom, Ville ville, ZoneId zoneId) {
        this.nom = nom;
        this.ville = ville;
        this.zoneId = zoneId;
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

    public ZoneId getZoneId() {
            return zoneId;
    }
}
