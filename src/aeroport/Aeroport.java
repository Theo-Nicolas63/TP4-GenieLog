package aeroport;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Aeroport {

    private String nom; 

    private Ville ville; // Ville dans laquelle se trouve l'aéroport

    private List<Ville> villeDesservies = new ArrayList<Ville>(); // Liste des villes désservis par l'aéroport

    private String code; // Code de l'aeroport

    private ZoneId zoneId; // Fuseau horaire de l'aeroport

    public Aeroport(String nom, Ville ville, ZoneId zoneId) {
        this.nom = nom;
        this.ville = ville;
        this.zoneId = zoneId;
        this.villeDesservies.add(ville);
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

    // Ajoute une ville desservi par cet aéroport à la liste ds villes desservies
    public void addVilleDesservie(Ville ville) {
        this.villeDesservies.add(ville);
    } 

}
